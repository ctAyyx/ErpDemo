package com.ct.erp.popup

import androidx.fragment.app.FragmentActivity
import com.ct.env.R
import com.ct.utils.FragmentUtils

object PopupHelper {

    fun showLogoutDialog(
        activity: FragmentActivity, onCancel: NoParamsCallback? = null, onSureClick: NoParamsCallback? = null
    ) {
        val resource = activity.resources
        FragmentUtils.showDialogFragment(
            HintDialogFragment.newInstance(
                resource.getString(R.string.hint_logout), onCancel = onCancel, onSureClick = onSureClick
            ), activity, "LogoutDialog"
        )
    }
}