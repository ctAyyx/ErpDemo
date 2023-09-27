package com.ct.erp.ext

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Outline
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.GradientDrawable.Orientation
import android.view.MotionEvent
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.ct.erp.adapter.CommonSpinnerAdapter
import com.ct.utils.image.ImageManager


@BindingAdapter(value = ["is_selected"])
fun View.setViewSelected(isSelected: Boolean) {
    this.isSelected = isSelected
}

@BindingAdapter(value = ["is_activated"])
fun View.setViewActivated(isActivated: Boolean) {
    this.isActivated = isActivated
}

private fun loadImage(
    imageView: ImageView, url: String?, type: ImageManager.Type = ImageManager.Type.NONE
) {
    if (url.isNullOrEmpty()) {
        imageView.setImageDrawable(null)
        return
    }
    ImageManager.getInstance().loadImageIntoImageView(url, imageView, type)
}

@BindingAdapter(value = ["none_img_url"])
fun ImageView.loadImageNone(url: String?) = loadImage(this, url, ImageManager.Type.NONE)

@BindingAdapter(value = ["img_url"])
fun ImageView.loadImageJpg(url: String?) = loadImage(this, url, ImageManager.Type.JPG)

@BindingAdapter(value = ["png_img_url"])
fun ImageView.loadImagePng(url: String?) = loadImage(this, url, ImageManager.Type.PNG)

@BindingAdapter(value = ["webp_img_url"])
fun ImageView.loadImageWebp(url: String?) {
    return loadImage(this, url, ImageManager.Type.WEBP)
}

@BindingAdapter(value = ["img_path"])
fun ImageView.loadImagePathNoneType(path: String?) {
    return loadImage(this, path, ImageManager.Type.NONE)
}

@BindingAdapter(value = ["image_url"])
fun ImageView.loadImage(url: String?) {
    if (url?.endsWith("jpg", true) == true || url?.endsWith("jpeg", true) == true || url?.endsWith(
                "png", true
            ) == true || url?.endsWith("webp", true) == true || url?.endsWith("gif", true) == true
    ) {
        loadImageNone(url)
    } else {
        loadImageWebp(url)
    }
}


@BindingAdapter(value = ["set_visibility"])
fun View.setVisibility(value: Boolean?) {
    isVisible = value ?: false
}

@BindingAdapter(value = ["dimension_ratio"])
fun View.dimensionRatio(value: String) {
    (layoutParams as? ConstraintLayout.LayoutParams)?.let {
        it.dimensionRatio = value
        requestLayout()
    }
}


@BindingAdapter(value = ["set_radius"])
fun View.setRadius(radius: Float) {
    outlineProvider = object : ViewOutlineProvider() {
        override fun getOutline(view: View?, outline: Outline?) {
            view ?: return
            outline?.setRoundRect(0, 0, view.width, view.height, radius)
        }
    }
    clipToOutline = true
}


@BindingAdapter(value = ["set_bt_gradient"])
fun View.setBtGradient(color: Int) {
    setGradient(Orientation.BOTTOM_TOP, intArrayOf(color, Color.TRANSPARENT), 0f)
}

@BindingAdapter(value = ["set_lr_gradient"])
fun View.setLrGradient(color: Int) {
    setGradient(Orientation.LEFT_RIGHT, intArrayOf(color, Color.TRANSPARENT), 0f)
}

fun View.setGradient(orientation: Orientation, colors: IntArray, radius: Float = 0f) {
    try {
        val gradient = GradientDrawable(orientation, colors)
        gradient.cornerRadius = radius
        background = gradient
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

@SuppressLint("ClickableViewAccessibility")
fun TextView.onEndDrawableClick(onClick: () -> Unit) {
    try {
        setOnTouchListener { v, event ->
            val endDrawable = compoundDrawables[2]
            if (endDrawable != null && event.action == MotionEvent.ACTION_UP) {
                val downX = event.x
                val endBound = v.right - v.paddingEnd - endDrawable.bounds.width()
                if (downX >= endBound) {
                    onClick.invoke()
                    return@setOnTouchListener true
                }
            }


            return@setOnTouchListener false
        }
    } catch (e: Exception) {
    }
}

fun Spinner.setCommonAdapter(data: List<String>, onItemSelect: ((Int) -> Unit)? = null) {
    if (data.isEmpty()) return
    adapter = CommonSpinnerAdapter(context, data)
    onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            onItemSelect?.invoke(position)
        }
        override fun onNothingSelected(parent: AdapterView<*>?) {
        }
    }
}