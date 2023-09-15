package com.ct.erp.ui

import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import com.ct.erp.R
import com.ct.erp.common.CommonPref
import com.ct.erp.common.LoginManager
import com.ct.erp.base.BaseActivity
import com.ct.erp.databinding.ActivityLoginBinding
import com.ct.erp.vm.LoginViewModel
import com.ct.utils.click
import com.ct.utils.ext.color
import dagger.hilt.android.AndroidEntryPoint
import es.dmoral.toasty.Toasty
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>() {
    override fun getLayoutId(): Int = R.layout.activity_login

    @Inject
    lateinit var commonPref: CommonPref

    override fun registerLoginState() {}
    override fun initToolbar() {}

    override fun initView(binding: ActivityLoginBinding) {
        super.initView(binding)
        build()
    }

    override fun initListener(binding: ActivityLoginBinding) {
        super.initListener(binding)
        binding.btnLogin.click {
            doLogin()
        }
    }

    private fun doLogin() {
        val userName = binding.etLoginUserName.text.toString()
        val userPwd = binding.etLoginUserPwd.text.toString()
        if (userName.isBlank()) {
            Toasty.error(this, "请输入用户名称").show()
            return
        }
        if (userPwd.isBlank()) {
            Toasty.error(this, "请输入用户密码").show()
            return
        }

        if (!checkAgreement()) {
            Toasty.error(this, "请阅读并同意隐私协议").show()
            return
        }

        viewModel.login(userName, userPwd)
    }

    override fun bindEvent(binding: ActivityLoginBinding) {
        super.bindEvent(binding)
        viewModel.loginStatus.observe(this) {
            //用户登录成功
            LoginManager.getInstance().initUserInfo(it)
            finish()
        }
    }


    private fun checkAgreement(): Boolean = binding?.radioAgreement?.isChecked ?: false
    private fun build() {
        val binding = binding ?: return

        val builder = SpannableStringBuilder()
        val clickSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {

            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = color(com.ct.env.R.color.grey04, context)
                ds.isUnderlineText = false
            }
        }

        val serverClickSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {

            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = color(com.ct.env.R.color.grey04, context)
                ds.isUnderlineText = false
            }
        }

        builder.append("同意")
        var start = builder.length
        builder.append(" ${getString(com.ct.env.R.string.privacy_service)} ")
        var end = builder.length
        builder.setSpan(clickSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        builder.append("和")
        start = builder.length
        builder.append(" ${getString(com.ct.env.R.string.privacy_service2)} ")
        end = builder.length
        builder.setSpan(serverClickSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)


        binding.radioAgreement.text = builder
        binding.radioAgreement.movementMethod = LinkMovementMethod.getInstance()
        binding.radioAgreement.setOnTouchListener { v, event ->
            if (v is TextView) {
                val method = v.movementMethod
                val text = v.text
                if ((text is Spannable) && method.onTouchEvent(
                            v, text, event
                        ) && (event.action == MotionEvent.ACTION_UP)
                ) {
                    event.action = MotionEvent.ACTION_CANCEL
                }
            }


            return@setOnTouchListener false
        }
    }


}