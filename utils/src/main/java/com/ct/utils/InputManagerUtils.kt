package com.ct.utils

import android.content.Context
import android.content.res.Configuration
import android.os.IBinder
import android.view.View
import android.view.inputmethod.InputMethodManager


object InputManagerUtils {
    fun hideSoftKeyboard(context: Context, binder: IBinder?) {
        if (binder == null) {
            return
        }
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (inputManager.isActive) {
            inputManager.hideSoftInputFromWindow(binder, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }

    fun showSoftKeyBoardDelayed(view: View) {
        val context: Context = view.context
        view.postDelayed({
            val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            view.requestFocus()
            inputManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }, 300)
    }

    fun hideSoftKeyboard(view: View?) {
        view ?: return
        (view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).run {
            if (isActive) {
                hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
            }
        }
    }

    fun showSoftKeyBoard(view: View?) {
        view ?: return
        (view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).run {
            showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    fun setKeyboardListener(parent: View, screenHeight: Int, onSoftKeyboardListener: ((Boolean) -> Unit)? = null) {
        parent.addOnLayoutChangeListener { _, _, _, _, bottom, _, _, _, oldBottom ->
            val curScreenHeight = Configuration.ORIENTATION_PORTRAIT
            val defaultHeight = screenHeight / 3
            if (oldBottom != 0 && bottom != 0 && (oldBottom - bottom > defaultHeight)) {
                onSoftKeyboardListener?.invoke(true)
            } else if (oldBottom != 0 && bottom != 0 && (bottom - oldBottom) > defaultHeight) {
                onSoftKeyboardListener?.invoke(false)
            }

        }
    }
}
