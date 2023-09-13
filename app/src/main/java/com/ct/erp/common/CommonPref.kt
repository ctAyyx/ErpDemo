package com.ct.erp.common

import android.content.Context
import androidx.annotation.Keep
import com.ct.utils.BasePref
import javax.inject.Inject


class CommonPref @Inject constructor(context: Context) : BasePref(context, Constants.PREF_KEY_COMMON) {

    @Keep
    companion object {
        const val KEY_USER_TOKEN = "KEY_USER_TOKEN"
        const val KEY_USER_DATA = "KEY_USER_DATA"
    }


    /**
     * 用户Token数据
     */
    var userToken: String
        get() = getString(KEY_USER_TOKEN, "")
        set(value) = putString(KEY_USER_TOKEN, value)


    var userDataJson: String
        get() = getString(KEY_USER_DATA, "{}")
        set(value) = putString(KEY_USER_DATA, value)


}