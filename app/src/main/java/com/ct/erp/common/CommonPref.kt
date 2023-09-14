package com.ct.erp.common

import android.content.Context
import androidx.annotation.Keep
import com.ct.erp.vo.UserViewData
import com.ct.utils.BasePref
import javax.inject.Inject


class CommonPref @Inject constructor(context: Context) : BasePref(context, Constants.PREF_KEY_COMMON) {

    @Keep
    companion object {
        const val KEY_USER_DATA = "KEY_USER_DATA"
    }


    var userDataJson: UserViewData?
        get():UserViewData? {
            val json = getString(KEY_USER_DATA, "{}")
            return try {
                gson.fromJson(json, UserViewData::class.java)
            } catch (e: Exception) {
                remove(KEY_USER_DATA)
                null
            }
        }
        set(value) {
            val json = gson.toJson(value)
            putString(KEY_USER_DATA, json)
        }

    fun clearUserInfo() {
        remove(KEY_USER_DATA)
    }

}