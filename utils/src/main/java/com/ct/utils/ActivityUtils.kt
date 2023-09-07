package com.ct.utils

import android.app.Activity
import android.app.ActivityManager
import android.app.ActivityManager.RunningAppProcessInfo
import android.app.ActivityOptions
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment



/**
 * This provides methods to help Activities load their UI.
 */

object ActivityUtils {
    /**
     * App 이 foreGround 에 있는지 확인
     *
     * @param context
     * @return
     */
    fun isAppForeGround(context: Context): Boolean {
        val appProcessInfo = RunningAppProcessInfo()
        ActivityManager.getMyMemoryState(appProcessInfo)
        return appProcessInfo.importance == RunningAppProcessInfo.IMPORTANCE_FOREGROUND || appProcessInfo.importance == RunningAppProcessInfo.IMPORTANCE_VISIBLE
    }

    fun startActivity(context: Context, intent: Intent): Boolean {
        var result = true
        try {
            context.startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            result = false
        } catch (e: SecurityException) {
            result = false
        } catch (e: NullPointerException) {
            result = false
        }
        return result
    }

    fun startActivity(context: Context, intent: Intent, options: Bundle?): Boolean {
        var result = true
        try {
            if (options != null) {
                context.startActivity(intent, options)
            } else {
                context.startActivity(intent)
            }
        } catch (e: ActivityNotFoundException) {
            result = false
        } catch (e: SecurityException) {
            result = false
        } catch (e: NullPointerException) {
            result = false
        }
        return result
    }

    fun startActivityForResult(activity: Activity, intent: Intent?, requestCode: Int): Boolean {
        var result = true
        try {
            activity.startActivityForResult(intent, requestCode)
        } catch (e: ActivityNotFoundException) {
            result = false
        } catch (e: SecurityException) {
            result = false
        } catch (e: NullPointerException) {
            result = false
        }
        return result
    }

    fun startActivitySafe(context: Context, intent: Intent) {
        try {
            context.startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun startActivityTransition(activity: Activity, intent: Intent) {
        try {
            activity.startActivity(
                intent,
                ActivityOptions.makeSceneTransitionAnimation(activity).toBundle()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            // no op
//
        }
    }

    fun startActivityTransition(activity: Activity, intent: Intent, targetView: View?) {
        try {
            if (targetView == null) {
                activity.startActivity(
                    intent,
                    ActivityOptions.makeSceneTransitionAnimation(activity).toBundle()
                )
            } else {
                activity.startActivity(
                    intent,
                    ActivityOptions.makeSceneTransitionAnimation(
                        activity,
                        targetView,
                        targetView.transitionName
                    ).toBundle()
                )
            }
        } catch (e: Exception) {
            // no op
//
        }
    }

    fun startActivityTransition(activity: Activity, intent: Intent, requestCode: Int) {
        try {
            activity.startActivityForResult(
                intent,
                requestCode,
                ActivityOptions.makeSceneTransitionAnimation(activity).toBundle()
            )
        } catch (e: Exception) {
            // no op
//
        }
    }

    fun startActivityTransition(fragment: Fragment, intent: Intent, requestCode: Int) {
        try {
            fragment.startActivityForResult(
                intent,
                requestCode,
                ActivityOptions.makeSceneTransitionAnimation(fragment.activity).toBundle()
            )
        } catch (e: Exception) {
            // no op
//
        }
    }

    fun startActivityTransition(activity: Activity, launcher: ActivityResultLauncher<Intent>, intent: Intent) {
        launcher.launch(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(activity))
    }

    fun finishActivity(activity: Activity) {
        activity.finishAfterTransition()
    }

    /**
     * 개발자 모드에서 "활동보관 안함"을 on 시켰는지 확인한다.
     */
    fun isFinishActivitiesOptionEnabled(context: Context): Boolean {
        val result = Settings.System.getInt(
            context.contentResolver,
            Settings.Global.ALWAYS_FINISH_ACTIVITIES,
            0
        )
        return result == 1
    }


    fun restart(activity: Activity?) {
        activity ?: return
        val restartIntent = activity.packageManager?.getLaunchIntentForPackage(activity.packageName)

        restartIntent?.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED

        val intent = PendingIntent.getActivity(
            activity, 0,
            restartIntent, PendingIntent.FLAG_UPDATE_CURRENT
        )

        val manager = activity.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        manager.set(AlarmManager.RTC, System.currentTimeMillis() + 1000, intent)
        System.exit(2)
    }
}