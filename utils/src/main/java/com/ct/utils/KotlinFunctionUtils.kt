package com.ct.utils

import android.content.ContentResolver
import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.util.SparseArray
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.annotation.ColorRes
import androidx.annotation.LayoutRes
import androidx.core.content.res.ResourcesCompat
import kotlin.math.roundToInt

/**
 * Created by erkas on 2017. 12. 15..
 */
inline fun <T : View> T.click(checkDouble: Boolean = true, crossinline function: (v: View) -> Unit): T {
    setOnClickListener { v ->
        if (checkDouble) {
            if (!UiUtils.checkDoubleClick2()) {
                function(v)
            }
        } else {
            function(v)
        }
    }
    return this
}

inline fun <T : View> T.afterMeasured(crossinline function: T.() -> Unit) {
    viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            if (measuredWidth > 0 && measuredHeight > 0) {
                viewTreeObserver.removeOnGlobalLayoutListener(this)
                function()
            }
        }
    })
}

inline fun <T : View> T.preDraw(crossinline function: T.() -> Unit) {
    viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
        override fun onPreDraw(): Boolean {
            viewTreeObserver.removeOnPreDrawListener(this)
            function()

            return false
        }
    })
}

fun String?.toUri(): Uri {
    return Uri.parse(this)
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun Resources.getColorFromId(@ColorRes colorRes: Int): Int {
    return ResourcesCompat.getColor(this, colorRes, null)
}

fun Resources.getColorStateListFromId(@ColorRes colorRes: Int): ColorStateList? {
    return ResourcesCompat.getColorStateList(this, colorRes, null)
}

fun Resources.getDipToPx(dp: Float): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics)
}

fun View.setElevationCompat(elevation: Float) {
    if (Build.VERSION.SDK_INT >= 21) {
        setElevation(elevation)
    }
}



fun String?.stringColorToInt(defaultColor: Int = Color.BLACK): Int {
    val color = this
    return if (color.isNullOrEmpty()) {
        defaultColor
    } else {
        try {
            if (color.contains("#")) {
                Color.parseColor("$color")
            } else {
                Color.parseColor("#$color")
            }

        } catch (e: Throwable) {
            defaultColor
        }
    }
}

fun String?.stringColorToIntOrNull(): Int? {
    val color = this
    return if (color.isNullOrEmpty()) {
        null
    } else {
        try {
            if (color.contains("#")) {
                Color.parseColor("$color")
            } else {
                Color.parseColor("#$color")
            }

        } catch (e: Throwable) {
            null
        }
    }
}


fun Int.getColorWithAlpha(opacity: Float): Int {
    return Color.argb((0xFF * opacity).roundToInt(), Color.red(this), Color.green(this), Color.blue(this))
}

inline fun <T, reified E : T> Array<T>.findCast(clazz: Class<E>): E? = find { it is E }?.let { clazz.cast(it) }


fun Resources.resourceUri(resourceId: Int): Uri =
    Uri.Builder().scheme(ContentResolver.SCHEME_ANDROID_RESOURCE).authority(getResourcePackageName(resourceId))
            .appendPath(getResourceTypeName(resourceId)).appendPath(getResourceEntryName(resourceId)).build()

fun View.margin(left: Int? = 0, top: Int? = 0, right: Int? = 0, bottom: Int? = 0) {
    layoutParams<ViewGroup.MarginLayoutParams> {
        left?.run { leftMargin = this }
        top?.run { topMargin = this }
        right?.run { rightMargin = this }
        bottom?.run { bottomMargin = this }
    }
}

inline fun <reified T : ViewGroup.LayoutParams> View.layoutParams(block: T.() -> Unit) {
    if (layoutParams is T) block(layoutParams as T)
}

inline fun <T> SparseArray<T>.forEachIndexed(action: (index: Int, T) -> Unit) {
    for (index in 0 until this.size()) action(index, this[index])
}

fun Boolean?.toYN(): String {
    return if (this == true) {
        "Y"
    } else {
        "N"
    }
}

