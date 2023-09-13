package com.ct.utils.ext

import android.content.Context
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


fun <T : Fragment> T.withArguments(vararg pairs: Pair<String, *>) = apply {
    arguments = bundleOf(*pairs)
}


inline fun <reified T : Any> Fragment.arguments(key: String, default: T? = null) = lazy {
    val value = arguments?.get(key)
    if (value is T) value else default
}

fun Fragment.getSupportChildFragmentManager(): FragmentManager? = try {
    childFragmentManager
} catch (e: IllegalStateException) {
    null
}

fun Fragment.getSupportFragmentManager(): FragmentManager? = try {
    parentFragmentManager
} catch (e: IllegalStateException) {
    null
}

fun Fragment.getSupportContext(): Context? = try {
    requireContext()
} catch (e: IllegalStateException) {
    null
}



