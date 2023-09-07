package com.ct.erp

import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import com.ct.erp.base.BaseActivity
import com.ct.erp.databinding.ActivityHomeBinding
import com.ct.erp.ui.ListActivity
import com.ct.erp.ui.LoginActivity
import com.ct.erp.ui.QRCodeScanActivity
import com.ct.erp.vm.HomeViewModel
import com.ct.utils.ActivityUtils
import com.ct.utils.LogUtils
import com.ct.utils.click
import com.king.camera.scan.CameraScan
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

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        val result = it.data?.getStringExtra(CameraScan.SCAN_RESULT)
        LogUtils.e("二维码数据:$result")
    }

    override fun initListener(binding: ActivityHomeBinding) {
        super.initListener(binding)
        binding.tvHome.click {
            viewModel.getOilPriceInfo("402e469d939079d5bb758fc5ca65967d")
        }

        binding.tvHomeQr.click {
            launcher.launch(Intent(this, QRCodeScanActivity::class.java))
        }

        binding.tvHomeList.click {
            ActivityUtils.startActivity(this, Intent(this, ListActivity::class.java))
        }
    }
}