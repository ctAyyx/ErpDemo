package com.ct.erp.popup

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.fragment.app.FragmentActivity
import com.ct.env.R
import com.ct.utils.FragmentUtils
import com.ct.utils.LogUtils
import java.util.Calendar

object PopupHelper {

    fun showLogoutDialog(
        activity: FragmentActivity, onCancel: NoParamsCallback? = null, onSureClick: NoParamsCallback? = null
    ) {
        val resource = activity.resources
        FragmentUtils.showDialogFragment(
            LogoutDialogFragment.newInstance(
                resource.getString(R.string.hint_logout), onCancel = onCancel, onSureClick = onSureClick
            ), activity, "LogoutDialog"
        )
    }

    fun showDateChooseDialog(
        context: Context,
        onDateChoose: ((Int, Int, Int) -> Unit)? = null
    ) {
        val ca = Calendar.getInstance()
        val cYear = ca.get(Calendar.YEAR)
        val cMonth = ca.get(Calendar.MONTH)
        val cDay = ca.get(Calendar.DAY_OF_MONTH)
        LogUtils.e("当前日期:$cYear-$cMonth-$cDay")
        val dialog = DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                onDateChoose?.invoke(year, month, dayOfMonth)
            }, cYear, cMonth, cDay
        )
        dialog.show()
    }
}