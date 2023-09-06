package com.ct.erp

import com.ct.erp.base.BaseActivity
import com.ct.erp.databinding.ActivityHomeBinding
import com.ct.erp.vm.HomeViewModel
import com.ct.utils.LogUtils
import com.ct.utils.click
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<HomeViewModel, ActivityHomeBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_home
    override fun bindEvent(binding: ActivityHomeBinding) {
        super.bindEvent(binding)
        viewModel.priceInfo.observe(this) {
            LogUtils.e("==>获取到的数据:${it}")
        }
    }

    override fun initListener(binding: ActivityHomeBinding) {
        super.initListener(binding)
        binding.tvHome.click {
            viewModel.getOilPriceInfo("402e469d939079d5bb758fc5ca65967d")
        }
    }
}