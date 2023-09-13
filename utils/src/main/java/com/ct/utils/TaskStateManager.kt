package com.ct.utils

import android.app.Activity
import java.lang.ref.WeakReference
import java.util.LinkedList

class TaskStateManager private constructor() {

    companion object : SingletonHolder<TaskStateManager>(::TaskStateManager)

    private val activityStackList: LinkedList<WeakReference<Activity>> = LinkedList()
    var isMainActivityCreated = false
        private set

    var skipMain = false

    fun onCreate(activity: Activity) {
        activityStackList.add(WeakReference(activity))
    }

    fun onDestroy(activity: Activity) {
        var removed: WeakReference<Activity>? = null
        for (wkActivity in activityStackList) {
            val inStack = wkActivity.get()
            if (activity == inStack) {
                removed = wkActivity
                break
            }
        }
        if (removed != null) {
            activityStackList.remove(removed)
        }

        if (activityStackList.isEmpty()) {
            isMainActivityCreated = false
        }
    }


    fun getTopActivity(): Activity? {
        return try {
            activityStackList.last.get()
        } catch (e: Exception) {
            null
        }
    }

    fun getBottomActivity(): Activity? {
        return try {
            activityStackList.first.get()
        } catch (e: Exception) {
            null
        }
    }


    private fun getActivityStackList(): LinkedList<WeakReference<Activity>> {
        return activityStackList.clone() as LinkedList<WeakReference<Activity>>
    }

    fun getCountActivityStack(): Int {
        return activityStackList.size
    }

    fun isActivityStackTop(activity: Activity?): Boolean {
        if (activity == null) return false
        val wkActivities = getActivityStackList()
        if (wkActivities.isEmpty()) {
            return false
        }
        val activityWeakReference = wkActivities[wkActivities.size - 1]
        val item = activityWeakReference.get()
        if (item == null || item.isFinishing) {
            return false
        }
        val className: Class<*> = item.javaClass
        return className == activity.javaClass
    }

    fun isActivitiesCreated(vararg targets: Class<*>): Boolean {
        val wkActivities = getActivityStackList()
        if (wkActivities.isEmpty()) {
            return false
        }
        for (activityWeakReference in wkActivities) {
            val activity = activityWeakReference.get()
            if (activity == null || activity.isFinishing) {
                continue
            }
            val className: Class<*> = activity.javaClass
            for (target in targets) {
                if (className == target) {
                    return true
                }
            }
        }
        return false
    }

    fun finishActivitiesExcept(vararg excepted: Class<*>) {
        val wkActivities = getActivityStackList()
        if (wkActivities.isEmpty()) {
            return
        }
        for (activityWeakReference in wkActivities) {
            val activity = activityWeakReference.get()
            if (activity == null || activity.isFinishing) {
                continue
            }
            val className: Class<*> = activity.javaClass
            var removed = true
            for (except in excepted) {
                if (className == except) {
                    removed = false
                }
            }
            if (removed) {
                activity.finish()
            }
        }
    }


    fun finishTargetActivity(vararg targets: Class<*>) {
        val wkActivities = getActivityStackList()
        if (wkActivities.isEmpty()) {
            return
        }
        for (activityWeakReference in wkActivities) {
            val activity = activityWeakReference.get()
            if (activity == null || activity.isFinishing) {
                continue
            }
            val className: Class<*> = activity.javaClass
            var removed = false
            for (except in targets) {
                if (className == except) {
                    removed = true
                }
            }
            if (removed) {
                activity.finish()
            }
        }
    }

    fun exitApp(activity: Activity) {
        TaskStateManager.getInstance().skipMain = true
        if (TaskStateManager.getInstance().isMainActivityCreated) {
            TaskStateManager.getInstance().finishActivitiesExcept(activity.javaClass)
        }
        activity.finish()
    }
}