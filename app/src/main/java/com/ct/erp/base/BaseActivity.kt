package com.ct.erp.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.KeyEvent
import android.view.WindowManager
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.databinding.ViewDataBinding
import com.ct.erp.ErpApp
import com.ct.erp.R
import com.ct.utils.LogUtils
import com.king.frame.mvvmframe.base.BaseActivity
import com.king.frame.mvvmframe.base.BaseModel
import com.king.frame.mvvmframe.base.BaseViewModel
import es.dmoral.toasty.Toasty

abstract class BaseActivity<VM : BaseViewModel<out BaseModel>, VDB : ViewDataBinding> : BaseActivity<VM, VDB>() {

    fun getApp() = application as ErpApp

    fun setToolbarTitle(title: String?) {
        title?.let {
            viewDataBinding?.root?.findViewById<TextView>(getTitleViewId())?.text = it
        }
    }

    open fun getTitleViewId(): Int = R.id.tvTitle

    override fun onCreate(savedInstanceState: Bundle?) {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        super.onCreate(savedInstanceState)
    }

    override fun initData(savedInstanceState: Bundle?) {
        registerMessageEvent {
            showToast(it)
        }
        initView(binding = viewDataBinding)
        initListener(binding = viewDataBinding)
        bindEvent(binding = viewDataBinding)

    }

    open fun initView(binding: VDB) {}
    open fun initListener(binding: VDB) {}
    open fun bindEvent(binding: VDB) {}


    //-----------------------------------

    fun showToast(@StringRes resId: Int) {
        Toasty.normal(context, resId).show()
    }

    fun showToast(text: CharSequence) {
        Toasty.normal(context, text).show()
        LogUtils.e("showToast:$text")
    }


    open fun canBack(): Boolean = true

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && !canBack()) {
            return true
        }
        return super.onKeyDown(keyCode, event)
    }


}