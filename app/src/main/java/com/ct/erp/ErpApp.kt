package com.ct.erp

import android.app.Application
import android.content.Context
import android.hardware.lights.LightsManager
import androidx.multidex.MultiDex
import com.ct.erp.dto.UserViewData
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
        //TODO 加载已登录的用户数据
        loadUserData()
    }

    private fun loadUserData() {
        val userJson = commonPref.userDataJson
        val userViewData = Gson().fromJson(userJson, UserViewData::class.java)
        if (userViewData.isAlive())
            LoginManager.getInstance().login(userViewData, true)
    }
}