package com.ct.erp

import android.content.Context
import androidx.annotation.Keep
import com.ct.utils.BasePref
import javax.inject.Inject


class CommonPref @Inject constructor(context: Context) : BasePref(context, Constants.PREF_KEY_COMMON) {

    @Keep
    companion object {
        const val KEY_USER_DATA = "KEY_USER_DATA"
    }

    var userDataJson: String
        get() = getString(KEY_USER_DATA, "{}")
        set(value) = putString(KEY_USER_DATA, value)

}