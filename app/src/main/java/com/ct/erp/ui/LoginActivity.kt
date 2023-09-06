package com.ct.erp.ui

import com.ct.erp.R
import com.ct.erp.base.BaseActivity
import com.ct.erp.databinding.ActivityLoginBinding
import com.ct.erp.vm.LoginViewModel
import com.ct.utils.click
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>() {
    override fun getLayoutId(): Int = R.layout.activity_login

    override fun initListener(binding: ActivityLoginBinding) {
        super.initListener(binding)
        binding.btnLogin.click {
            viewModel.login("", "")
        }
    }

    override fun bindEvent(binding: ActivityLoginBinding) {
        super.bindEvent(binding)
        viewModel.loginStatus.observe(this) {

        }
    }

}