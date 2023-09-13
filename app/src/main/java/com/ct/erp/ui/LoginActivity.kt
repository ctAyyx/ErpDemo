package com.ct.erp.ui

import com.ct.erp.common.CommonPref
import com.ct.erp.common.LoginManager
import com.ct.erp.R
import com.ct.erp.base.BaseActivity
import com.ct.erp.databinding.ActivityLoginBinding
import com.ct.erp.vm.LoginViewModel
import com.ct.utils.click
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>() {
    override fun getLayoutId(): Int = R.layout.activity_login

    @Inject
    lateinit var commonPref: CommonPref

    override fun registerLoginState() {}
    override fun initToolbar() {}

    override fun initListener(binding: ActivityLoginBinding) {
        super.initListener(binding)
        binding.btnLogin.click {
            val userName = binding.etLoginUserName.text.toString()
            val userPwd = binding.etLoginUserPwd.text.toString()
            viewModel.login(userName, userPwd)
        }
    }

    override fun bindEvent(binding: ActivityLoginBinding) {
        super.bindEvent(binding)
        viewModel.loginStatus.observe(this) {
            //用户登录成功
            LoginManager.getInstance().initUserInfo(it)
            finish()
        }
    }

}