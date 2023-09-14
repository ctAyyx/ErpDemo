package com.ct.erp.popup

import android.os.Bundle
import com.ct.erp.R
import com.ct.erp.base.BaseDialogFragment
import com.ct.erp.databinding.DialogHintBinding
import com.ct.erp.vm.LoginViewModel
import com.ct.utils.click
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LogoutDialogFragment : BaseDialogFragment<LoginViewModel, DialogHintBinding>() {

    companion object {
        private const val P_TITLE = "P_TITLE"
        fun newInstance(
            hintText: String, onCancel: NoParamsCallback? = null, onSureClick: NoParamsCallback? = null
        ): LogoutDialogFragment {
            val dialog = LogoutDialogFragment()

            val bundle = Bundle()
            bundle.putString(P_TITLE, hintText)

            dialog.arguments = bundle

            dialog.onCancel = onCancel
            dialog.onSureClick = onSureClick
            return dialog

        }
    }


    private var hintTitle: String = ""

    private var onCancel: NoParamsCallback? = null
    private var onSureClick: NoParamsCallback? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            hintTitle = it.getString(P_TITLE, "")
        }

    }

    override fun getLayoutId(): Int = R.layout.dialog_hint

    override fun initData(savedInstanceState: Bundle?) {
        binding.tvDialogLogoutTitle.text = hintTitle

        binding.btnDialogLogoutCancel.click {
            onCancel?.invoke()
            dismiss()
        }

        binding.btnDialogLogoutSure.click {
            viewModel.logout()
        }

        viewModel.loginStatus.observe(this) {
            dismiss()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        onCancel = null
        onSureClick = null
    }
}