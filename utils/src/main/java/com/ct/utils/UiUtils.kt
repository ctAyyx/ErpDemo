/*
 * Copyright 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ct.utils

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import android.content.res.Resources
import android.os.Build
import android.os.SystemClock
import android.provider.Settings
import android.util.DisplayMetrics
import android.view.Surface
import android.view.View
import android.view.WindowManager
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

/**
 * An assortment of UI helpers.
 */
object UiUtils {
    const val SCREEN_ORIENTATION_PORTRAIT = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    const val SCREEN_ORIENTATION_LANDSCAPE = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

    private const val GALAXY_S8 = "SM-G950"
    private const val GALAXY_S8_PLUS = "SM-G955"
    private const val GALAXY_FOLD = "SM-F9"
    private const val LG_V40 = "LM-V409"
    private const val LG_G7 = "LM-G710"
    private const val LG_G9_FIT = "LM-Q925"

    /**
     * 중복 클릭 방지 시간 설정
     */
    private const val MIN_CLICK_INTERVAL: Long = 200
    private var mLastClickTime: Long = 0

    /**
     * 중복 드래그 방지 시간 설정
     */
    private const val MIN_DRAG_INTERVAL: Long = 1_500
    private var mLastDragTime: Long = 0
    var isFullScreenMode = false
        private set
    val isAndroid10: Boolean
        get() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.P

    fun setFullScreenMode(activity: Activity?, isFullScreen: Boolean) {
        if (hasDisplayCutoutDevice()) {
            return
        }
        if (activity == null || activity.isFinishing) {
            return
        }

        //삼성 단말에서 JELLY_BEAN 이상에서 WindowManager.LayoutParams.FLAG_FULLSCREEN를 해주어야 정상동작함
//        setFullScreenModeGBICS(activity, isFullScreen)
//        setFullScreenModeKK(activity, isFullScreen)
        isFullScreenMode = isFullScreen

        val window = activity.window
        val windowInsetsController = WindowInsetsControllerCompat(window, window.decorView)

        if (isFullScreen) {
            windowInsetsController.hide(WindowInsetsCompat.Type.statusBars())
        } else {
            windowInsetsController.show(WindowInsetsCompat.Type.statusBars())
        }
    }

    private fun setFullScreenModeGBICS(activity: Activity, isFullScreen: Boolean) {
        val window = activity.window
        if (isFullScreen) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        } else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
    }

    private fun setFullScreenModeKK(activity: Activity, isFullScreen: Boolean) {
        val decorView = activity.window.decorView
        var flags = decorView.systemUiVisibility
        flags = if (isFullScreen) {
            flags or (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        } else {
            flags and (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY).inv()
        }
        decorView.systemUiVisibility = flags
    }

    inline fun checkDoubleClick(block: () -> Unit) {
        if (checkDoubleClick2()) {
            block.invoke()
        }
    }

    fun checkDoubleClick2(): Boolean {
        val currentClickTime = SystemClock.uptimeMillis()
        val elapsedTime = currentClickTime - mLastClickTime
        mLastClickTime = currentClickTime
        return elapsedTime <= MIN_CLICK_INTERVAL
    }

    fun checkDoubleDrag(): Boolean {
        val currentDragTime = SystemClock.uptimeMillis()
        val elapsedTime = currentDragTime - mLastDragTime
        mLastDragTime = currentDragTime

        // 중복 드래그인 경우
        return elapsedTime <= MIN_DRAG_INTERVAL
    }

    fun getScreenOrientation(activity: Activity?, currentOrientation: Int): Int {
        if (activity == null) {
            return ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        val systemOrientation = Settings.System.getInt(
            activity.contentResolver,
            Settings.System.ACCELEROMETER_ROTATION,
            0
        )
        // 화면 고정인경우
        if (systemOrientation == 0 && !(currentOrientation == ActivityInfo.SCREEN_ORIENTATION_SENSOR ||
                        currentOrientation == ActivityInfo.SCREEN_ORIENTATION_USER)
        ) {
            return currentOrientation
        }
        val rotation = activity.windowManager.defaultDisplay.rotation
        val dm = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(dm)
        val width = dm.widthPixels
        val height = dm.heightPixels
        val orientation: Int

        // 일반적인 세로 디바이스
        orientation =
            if ((rotation == Surface.ROTATION_0 || rotation == Surface.ROTATION_180) && height > width
                    || (rotation == Surface.ROTATION_90 || rotation == Surface.ROTATION_270) && width > height
            ) {
                when (rotation) {
                    Surface.ROTATION_0 -> ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                    Surface.ROTATION_90 -> ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                    Surface.ROTATION_180 -> ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT
                    Surface.ROTATION_270 -> ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE
                    else -> ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                }
            } else {
                when (rotation) {
                    Surface.ROTATION_0 -> ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                    Surface.ROTATION_90 -> ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                    Surface.ROTATION_180 -> ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE
                    Surface.ROTATION_270 -> ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT
                    else -> ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                }
            }
        return orientation
    }

    fun keepScreenOn(activity: Activity?) {
        if (activity == null) {
            return
        }
        val window = activity.window
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            activity.setTurnScreenOn(true)
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON)
        }
    }

    fun keepScreenOff(activity: Activity?) {
        if (activity == null) {
            return
        }
        val window = activity.window
        window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            activity.setTurnScreenOn(false)
        } else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON)
        }
    }

    fun getMainScreenSize(context: Context): DisplayMetrics {
        // DisplayMetrics width and height changes as device orientation changes
        val metrics = DisplayMetrics()
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        wm.defaultDisplay.getMetrics(metrics)
        return metrics
    }


    /**
     * v28 미만이면서 DisplayCutout을 가진 기기가 존재한다.
     * 따라서 해당 기기를 블랙리스트해서 관리한다.
     *
     * v28 이상에서는 DisplayCutout 관련 API 존재하기 때문에 문제가 없다.
     *
     */
    fun hasDisplayCutoutDevice(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            false
        } else Build.MODEL.contains(
            LG_V40
        ) || Build.MODEL.contains(LG_G7)
    }

    val density = Resources.getSystem().displayMetrics.density
    fun dpToPx(dp: Int): Int {
        return (dp * density).toInt()
    }

}