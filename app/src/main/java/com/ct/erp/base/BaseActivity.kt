package com.ct.erp.base

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.databinding.ViewDataBinding
import com.ct.erp.common.Constants
import com.ct.erp.ErpApp
import com.ct.erp.common.LoginManager
import com.ct.erp.R
import com.ct.erp.common.UserLoginState
import com.ct.erp.common.UserStateEvent
import com.ct.erp.ext.setVisibility
import com.ct.erp.popup.PopupHelper
import com.ct.erp.ui.LoginActivity
import com.ct.utils.ActivityUtils
import com.ct.utils.LiveDataBus
import com.ct.utils.LogUtils
import com.ct.utils.TaskStateManager
import com.ct.utils.click
import com.king.frame.mvvmframe.base.BaseActivity
import com.king.frame.mvvmframe.base.BaseModel
import com.king.frame.mvvmframe.base.BaseViewModel
import es.dmoral.toasty.Toasty

abstract class BaseActivity<VM : BaseViewModel<out BaseModel>, VDB : ViewDataBinding> : BaseActivity<VM, VDB>() {

    fun getApp() = application as ErpApp


    override fun onCreate(savedInstanceState: Bundle?) {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        super.onCreate(savedInstanceState)
        TaskStateManager.getInstance().onCreate(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        TaskStateManager.getInstance().onDestroy(this)
    }

    override fun initData(savedInstanceState: Bundle?) {
        registerMessageEvent {
            showToast(it)
        }
        registerLoginState()
        initToolbar()
        initView(binding = binding)
        initListener(binding = binding)
        bindEvent(binding = binding)
        loadData()
    }

    open fun registerLoginState() {
        LiveDataBus.get().with(Constants.BUS_USER_LOGIN, UserStateEvent::class.java).observe(this) {
            LogUtils.e(" 登录状态改变:$it")
            when (it.loginState) {
                UserLoginState.LOGIN_SUCCESS -> {
                    onUserLoginIn(it)
                }
                UserLoginState.LOGOUT_SUCCESS -> {
                    onUserLoginOut(it)
                }
            }
        }
    }

    open fun initToolbar() {
        getTitleView()?.text = getToolbarTitle()
        LoginManager.getInstance().userName.observe(this) {
            getUserView()?.text = it
        }

        LoginManager.getInstance().isAdmin.observe(this) {
            getLogoutView()?.setVisibility(it)
        }

        getLogoutView()?.click {
            handleLogoutClick()
        }

        getBackView()?.visibility = if (showBackView()) View.VISIBLE else View.INVISIBLE
        getBackView()?.click {
            if (showBackView())
                finish()
        }
    }

    open fun handleLogoutClick() {
        PopupHelper.showLogoutDialog(this, onCancel = {}, onSureClick = {
            LoginManager.getInstance().logout(true)
        })
    }

    open fun initView(binding: VDB) {}
    open fun initListener(binding: VDB) {}
    open fun bindEvent(binding: VDB) {}
    open fun loadData() {}

    open fun onUserLoginOut(event: UserStateEvent) {
        ActivityUtils.startActivitySafe(this, Intent(this, LoginActivity::class.java))
    }

    open fun onUserLoginIn(event: UserStateEvent) {
        loadData()
    }

    //-----------------------------------

    open fun getTitleView(): TextView? {
        return binding.root.findViewById(R.id.tvTitle)
    }

    open fun getUserView(): TextView? {
        return binding.root.findViewById(R.id.tvUserName)
    }

    open fun getLogoutView(): ImageView? {
        return binding.root.findViewById(R.id.imgLogout)
    }

    open fun showBackView(): Boolean = true
    open fun getBackView(): ImageView? {
        return binding.root.findViewById(R.id.imgBack)
    }

    open fun getToolbarTitle(): String = ""

    //-----------------------------------

    fun showToast(@StringRes resId: Int) {
        Toasty.normal(context, resId).show()
    }

    fun showToast(text: CharSequence) {
        Toasty.normal(context, text).show()
    }


    open fun canBack(): Boolean = true

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && !canBack()) {
            return true
        }
        return super.onKeyDown(keyCode, event)
    }


}