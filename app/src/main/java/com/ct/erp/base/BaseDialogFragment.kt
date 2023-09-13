package com.ct.erp.base

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.StringRes
import androidx.databinding.ViewDataBinding
import com.ct.erp.ErpApp
import com.ct.erp.R
import com.king.frame.mvvmframe.base.BaseDialogFragment
import com.king.frame.mvvmframe.base.BaseModel
import com.king.frame.mvvmframe.base.BaseViewModel

abstract class BaseDialogFragment<VM : BaseViewModel<out BaseModel>, VDB : ViewDataBinding> :
    BaseDialogFragment<VM, VDB>() {
    protected open val dialogStyle: Int = R.style.FloatingDialogFragment
    fun getApp() = requireActivity().application as ErpApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, dialogStyle)
    }

    override fun initData(savedInstanceState: Bundle?) {
        registerMessageEvent {
            showToast(it)
        }

    }

    //-----------------------------------

    fun showToast(@StringRes resId: Int) {
        //Toasty.normal(requireContext(), resId).show()
    }

    fun showToast(text: CharSequence) {
        //Toasty.normal(requireContext(), text).show()
    }


}