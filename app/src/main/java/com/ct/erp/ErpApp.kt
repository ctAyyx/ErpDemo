package com.ct.erp

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.ct.erp.common.CommonPref
import com.ct.erp.common.LoginManager
import com.ct.erp.dto.LoginApiData
import com.google.gson.Gson
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class ErpApp : Application() {

    @Inject
    lateinit var commonPref: CommonPref
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }

    override fun onCreate() {
        super.onCreate()
        loadUserData()
    }

    private fun loadUserData() {
        val user = commonPref.userDataJson
        if (user != null) {
            LoginManager.getInstance().login(userToken = user.userToken)
            LoginManager.getInstance().initUserInfo(user, true)
        }

    }
}