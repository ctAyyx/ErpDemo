package com.kakaopage.kakaowebtoon.framework.image

import android.graphics.Bitmap
import android.graphics.drawable.Drawable

interface ImageRequestListener {
    fun onResourceReady(resource: Drawable?)
    fun onLoadFailed(e: Exception?)
}

interface BitmapRequestListener {
    fun onResourceReady(bitmapList: ArrayList<Bitmap>?)
}

fun interface ImageLoadFailedListener {
    fun onLoadFailed(e: Exception?)
}