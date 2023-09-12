package com.ct.erp.ui

import com.ct.erp.CommonPref
import com.ct.erp.Constants
import com.ct.erp.LoginManager
import com.ct.erp.R
import com.ct.erp.base.BaseActivity
import com.ct.erp.databinding.ActivityLoginBinding
import com.ct.erp.vm.LoginViewModel
import com.ct.utils.LiveDataBus
import com.ct.utils.click
import dagger.hilt.android.AndroidEntryPoint
import es.dmoral.toasty.Toasty
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>() {
    override fun getLayoutId(): Int = R.layout.activity_login

    @Inject
    lateinit var commonPref: CommonPref



    override fun initListener(binding: ActivityLoginBinding) {
        super.initListener(binding)
        binding.btnLogin.click {
            viewModel.login("", "")
        }
    }

    override fun bindEvent(binding: ActivityLoginBinding) {
        super.bindEvent(binding)
        viewModel.loginStatus.observe(this) {
            //用户登录成功
            commonPref.userToken = LoginManager.getInstance().token
            //
            finish()
        }
    }

}