package com.ct.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.util.DisplayMetrics
import android.util.Log
import android.view.WindowManager
import android.webkit.WebView
import androidx.core.app.NotificationManagerCompat
import java.net.Inet4Address
import java.net.NetworkInterface
import java.net.SocketException
import java.util.Locale
import java.util.UUID


object DeviceInfoUtil {

    private const val TAG = "DeviceInfoUtil"

    /**
     * ANDROID_ID 를 사용할때 문제가 발생하면 randomUUID를 사용 한다.
     * 즉 호출할때마다 다른 값이 발생 할 수도 있으니 preference 에 저장해두고 사용 하자.
     */
    @SuppressLint("HardwareIds")
    fun getDeviceUUID(c: Context?): String {
        c ?: return ""
        return try {
            UUID.nameUUIDFromBytes(
                (Settings.Secure.getString(
                    c.contentResolver,
                    Settings.Secure.ANDROID_ID
                ) + c.packageName).toByteArray()
            ).toString()
        } catch (e: Exception) {
            //InternalError, SecurityException 등 다양한 단말과 상황에서 에러 발생 가능
            null
        } ?: run {
            //에러가 발생해도 랜덤으로 생성 한다.
            UUID.randomUUID().toString()
        }
    }

    fun isDeviceNotificationOn(context: Context?): Boolean {
        context ?: return false
        return try {
            NotificationManagerCompat.from(context).areNotificationsEnabled()
        } catch (e: Exception) {
            false
        }
    }

    fun openDeviceNotificationSettings(context: Context) {
        Intent().run {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                action = Settings.ACTION_APP_NOTIFICATION_SETTINGS
                putExtra(Settings.EXTRA_APP_PACKAGE, context.packageName)
            } else {
                action = "android.settings.APP_NOTIFICATION_SETTINGS"
                putExtra("android.provider.extra.APP_PACKAGE", context.packageName)
                putExtra("app_package", context.packageName)
                putExtra("app_uid", context.applicationInfo.uid)
            }
            context.startActivity(this)
        }
    }

    fun openDeviceNotificationSettingsCompat(context: Context) {
        try {
            openDeviceNotificationSettings(context)
        } catch (e: Exception) {
            openDeviceSettings(context)
        }
    }

    fun openDeviceSettings(context: Context) {
        val intent = Intent()
        intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
        intent.data = Uri.parse("package:" + context.packageName);
        context.startActivity(intent)
    }

    fun getUserAgent(context: Context): String? {
        return try {
            WebView(context).settings.userAgentString
        } catch (var2: Exception) {
            ""
        }
    }

    fun getCountry(context: Context): String? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            context.resources.configuration.locales.get(0).country
        } else {
            context.resources.configuration.locale.country
        }
    }

    fun getOsName(): String {
        return "Android"
    }

    fun getOsVersion(): String {
        return Build.VERSION.RELEASE
    }

    fun getDeviceModelName(): String {
        return Build.MODEL
    }

    fun getAppVersionName(): String {
        // return BuildConfig.VERSION_NAME
        return ""
    }

    fun getCurrentIp(): String? {
        try {
            val enumeration = NetworkInterface.getNetworkInterfaces()
            while (enumeration.hasMoreElements()) {
                val networkInterface = enumeration.nextElement()
                val enumIpAddress = networkInterface.inetAddresses
                while (enumIpAddress.hasMoreElements()) {
                    val inetAddress = enumIpAddress.nextElement()
                    if (!inetAddress.isLoopbackAddress && inetAddress is Inet4Address) {
                        return inetAddress.getHostAddress()
                    }
                }
            }
        } catch (ex: SocketException) {
            Log.e(TAG, "Error getCurrentIp() : ${ex.message}")
            return null
        }

        return null
    }

    fun getDeviceLanguage(): String? {
        return Locale.getDefault().displayLanguage
    }

    fun getDeviceName(): String {
        return Build.MODEL
    }

    fun getDeviceOS(): String {
        return try {
            val clz = Class.forName("com.huawei.system.BuildEx")
            val method = clz.getMethod("getOsBrand")
            val osBrand = method.invoke(clz)
            if (osBrand == "harmony")
                "harmony ${getHarmonyVersion()}"
            else
                "Android ${Build.VERSION.RELEASE}"
        } catch (e: Exception) {
            "Android ${Build.VERSION.RELEASE}"
        }
    }

    private fun getHarmonyVersion(): String {
        return try {
            val clz = Class.forName("android.os.SystemProperties")
            val method = clz.getDeclaredMethod("get", String::class.java)
            method.isAccessible = true
            val version = method.invoke(clz, "hw_sc.build.platform.version")
            version.toString()

        } catch (e: Exception) {
            Build.VERSION.RELEASE
        }
    }

    fun getDeviceBrand(): String {
        return Build.BRAND
    }


    /**
     *  获取设备宽度
     */
    fun getDeviceWidth(context: Context): Int {
        val outMetrics = DisplayMetrics() // 创建了一张白纸
        val manager = context.getSystemService(Context.WINDOW_SERVICE) as? WindowManager
        manager?.defaultDisplay?.getMetrics(outMetrics) // 给白纸设置宽高
        return outMetrics.widthPixels
    }

    /**
     *  获取设备高度
     */
    fun getDeviceHeight(context: Context): Int {
        val outMetrics = DisplayMetrics() // 创建了一张白纸
        val manager = context.getSystemService(Context.WINDOW_SERVICE) as? WindowManager
        manager?.defaultDisplay?.getMetrics(outMetrics) // 给白纸设置宽高
        return outMetrics.heightPixels
    }

}