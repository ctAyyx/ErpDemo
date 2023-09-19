package com.ct.erp.ui

import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.RecyclerView
import com.ct.erp.R
import com.ct.erp.adapter.DispatchTableAdapter
import com.ct.erp.base.BaseActivity
import com.ct.erp.common.LoginManager
import com.ct.erp.databinding.ActivityDispatchDetailBinding
import com.ct.erp.popup.ColumnDialogFragment
import com.ct.erp.vm.DispatchViewModel
import com.ct.utils.FragmentUtils
import com.ct.utils.LogUtils
import com.ct.utils.click
import com.evrencoskun.tableview.listener.ITableViewListener
import com.king.camera.scan.CameraScan
import dagger.hilt.android.AndroidEntryPoint
import es.dmoral.toasty.Toasty
import javax.inject.Inject

/**
 *
 */
@AndroidEntryPoint
class DispatchDetailListActivity : BaseActivity<DispatchViewModel, ActivityDispatchDetailBinding>() {
    override fun getLayoutId(): Int = R.layout.activity_dispatch_detail
    override fun getToolbarTitle(): String = "做工明显列表"

    @Inject
    lateinit var mAdapter: DispatchTableAdapter

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        val result = it.data?.getStringExtra(CameraScan.SCAN_RESULT)
        LogUtils.e("二维码数据:$result")
        Toasty.error(this, "二维码数据:$result").show()
    }

    override fun initView(binding: ActivityDispatchDetailBinding) {
        super.initView(binding)

        binding.tableDispatchDetailList.setAdapter(mAdapter)
        binding.tableDispatchDetailList.setHasFixedWidth(false)

    }

    override fun initListener(binding: ActivityDispatchDetailBinding) {
        super.initListener(binding)
        binding.tableDispatchDetailList.tableViewListener = tabListener
        binding.btnTableQr.click {
            launcher.launch(Intent(this, QRCodeScanActivity::class.java))
        }

        binding.btnTableColumn.click {
            FragmentUtils.showDialogFragment(ColumnDialogFragment.newInstance(), this, ColumnDialogFragment.TAG)
        }
        LogUtils.e("Activity:$viewModel")
    }

    override fun bindEvent(binding: ActivityDispatchDetailBinding) {
        super.bindEvent(binding)
        viewModel.dispatchViewData.observe(this) {
            LogUtils.e("$this $it")
            mAdapter.setAllItems(it.columnHeader, it.rowHeader, it.cells)
        }
        viewModel.doRefresh(LoginManager.getInstance().xkUserName)
    }

    private val tabListener = object : ITableViewListener {
        override fun onCellClicked(cellView: RecyclerView.ViewHolder, column: Int, row: Int) {
            Toasty.normal(this@DispatchDetailListActivity, "被点击了:$column-$row").show()
        }

        override fun onCellDoubleClicked(cellView: RecyclerView.ViewHolder, column: Int, row: Int) {
        }

        override fun onCellLongPressed(cellView: RecyclerView.ViewHolder, column: Int, row: Int) {
        }

        override fun onColumnHeaderClicked(columnHeaderView: RecyclerView.ViewHolder, column: Int) {
        }

        override fun onColumnHeaderDoubleClicked(columnHeaderView: RecyclerView.ViewHolder, column: Int) {
        }

        override fun onColumnHeaderLongPressed(columnHeaderView: RecyclerView.ViewHolder, column: Int) {
        }

        override fun onRowHeaderClicked(rowHeaderView: RecyclerView.ViewHolder, row: Int, isRowEnd: Boolean) {
            LogUtils.e("onRowHeaderClicked $row  $isRowEnd ${viewModel.tableAllCell[row]}")

        }

        override fun onRowHeaderDoubleClicked(rowHeaderView: RecyclerView.ViewHolder, row: Int) {
        }

        override fun onRowHeaderLongPressed(rowHeaderView: RecyclerView.ViewHolder, row: Int) {
        }

    }
}