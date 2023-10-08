package com.ct.erp.ui

import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.RecyclerView
import com.ct.erp.R
import com.ct.erp.adapter.DispatchTableAdapter
import com.ct.erp.base.BaseActivity
import com.ct.erp.common.LoginManager

import com.ct.erp.databinding.ActivityDispatchListBinding
import com.ct.erp.popup.ColumnDialogFragment
import com.ct.erp.vm.DispatchViewModel
import com.ct.utils.ActivityUtils
import com.ct.utils.FragmentUtils
import com.ct.utils.LogUtils
import com.ct.utils.click
import com.evrencoskun.tableview.listener.ITableViewListener
import com.evrencoskun.tableview.listener.SimpleTableViewListener
import com.king.camera.scan.CameraScan
import dagger.hilt.android.AndroidEntryPoint
import es.dmoral.toasty.Toasty
import javax.inject.Inject

/**
 *
 */
@AndroidEntryPoint
class DispatchListActivity : BaseActivity<DispatchViewModel, ActivityDispatchListBinding>() {
    override fun getLayoutId(): Int = R.layout.activity_dispatch_list
    override fun getToolbarTitle(): String = "做工明显列表"

    @Inject
    lateinit var mAdapter: DispatchTableAdapter

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        val result = it.data?.getStringExtra(CameraScan.SCAN_RESULT)
        LogUtils.e("二维码数据:$result")
//        Toasty.error(this, "二维码数据:$result").show()
        doFilter(result)
    }

    override fun initView(binding: ActivityDispatchListBinding) {
        super.initView(binding)

        binding.tableDispatchDetailList.setAdapter(mAdapter)
        binding.tableDispatchDetailList.setHasFixedWidth(false)

    }

    override fun initListener(binding: ActivityDispatchListBinding) {
        super.initListener(binding)
        binding.tableDispatchDetailList.tableViewListener = tabListener
        binding.btnTableQr.click {
            launcher.launch(Intent(this, QRCodeScanActivity::class.java))
        }

        binding.btnTableColumn.click {
            FragmentUtils.showDialogFragment(ColumnDialogFragment.newInstance(), this, ColumnDialogFragment.TAG)
        }

        binding.btnTableFilter.click {
            val filter = binding.etTableFilter.text.toString().trim()
            doFilter(filter)
        }
    }

    private fun doFilter(filter: String?) {
        if (filter.isNullOrBlank()) {
            showToast("筛选条件不能为空!")
            return
        }
        viewModel.doRefresh(filter)
    }


    override fun bindEvent(binding: ActivityDispatchListBinding) {
        super.bindEvent(binding)
        viewModel.dispatchViewData.observe(this) {
            LogUtils.e("$this $it")
            mAdapter.setAllItems(it.columnHeader, it.rowHeader, it.cells)
        }
        viewModel.doRefresh(LoginManager.getInstance().xkUserName)
    }

    private val tabListener = object : SimpleTableViewListener() {
        override fun onRowHeaderClicked(rowHeaderView: RecyclerView.ViewHolder, row: Int, isRowEnd: Boolean) {
            LogUtils.e("onRowHeaderClicked $row  $isRowEnd ${viewModel.tableAllCell[row]}")
            if (isRowEnd) {
                ActivityUtils.startActivitySafe(
                    this@DispatchListActivity, Intent(this@DispatchListActivity, DispatchDetailActivity::class.java)
                )
            }

        }
    }
}