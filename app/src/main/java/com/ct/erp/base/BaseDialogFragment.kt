package com.ct.erp.base

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.databinding.ViewDataBinding
import com.ct.erp.ErpApp
import com.king.frame.mvvmframe.base.BaseDialogFragment
import com.king.frame.mvvmframe.base.BaseModel
import com.king.frame.mvvmframe.base.BaseViewModel

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
abstract class BaseDialogFragment<VM : BaseViewModel<out BaseModel>, VDB : ViewDataBinding> :
    BaseDialogFragment<VM, VDB>() {

    fun getApp() = requireActivity().application as ErpApp

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