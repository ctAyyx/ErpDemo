package com.ct.utils.ext

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat


@ColorInt
fun String.toColorInt(): Int = Color.parseColor(this)

fun color(@ColorRes id: Int, context: Context): Int {
    return ContextCompat.getColor(context, id)
}

