package com.ct.erp.ui

import androidx.activity.result.contract.ActivityResultContracts
import com.ct.erp.R
import com.ct.erp.adapter.DispatchTableAdapter
import com.ct.erp.base.BaseActivity
import com.ct.erp.databinding.ActivityDispatchDetailBinding
import com.ct.erp.vm.DispatchViewModel
import com.ct.utils.LogUtils
import com.king.camera.scan.CameraScan
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 *
 */
@AndroidEntryPoint
class DispatchDetailListActivity : BaseActivity<DispatchViewModel, ActivityDispatchDetailBinding>() {
    override fun getLayoutId(): Int = R.layout.activity_dispatch_detail

    @Inject
    lateinit var mAdapter: DispatchTableAdapter

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        val result = it.data?.getStringExtra(CameraScan.SCAN_RESULT)
        LogUtils.e("二维码数据:$result")
    }

    override fun initView(binding: ActivityDispatchDetailBinding) {
        super.initView(binding)

        binding.tableDispatchDetailList.setAdapter(mAdapter)
        binding.tableDispatchDetailList.setHasFixedWidth(false)

    }

    override fun bindEvent(binding: ActivityDispatchDetailBinding) {
        super.bindEvent(binding)
        viewModel.dispatchViewData.observe(this) {
            mAdapter.setAllItems(it.columnHeader, it.rowHeader, it.cells)
        }
        viewModel.loadDispatchList()
    }
}