package com.ct.utils

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.ct.utils.ext.getSupportFragmentManager


object FragmentUtils {
    fun fadeInFragment(
        fragmentTransaction: FragmentTransaction,
        fragmentContainerResId: Int,
        fragment: Fragment,
        tag: String,
        isReplace: Boolean = true,
        useBackStack: Boolean = false
    ) {
        fragmentTransaction.apply {
            setCustomAnimations(
                R.anim.fadein, R.anim.fadeout, R.anim.fadein, R.anim.fadeout
            )
            if (isReplace) {
                replace(fragmentContainerResId, fragment, tag)
            } else {
                add(fragmentContainerResId, fragment, tag)
            }

            if (useBackStack) {
                addToBackStack(null)
            }
        }
    }

    fun pushFromLeftFragment(
        fragmentTransaction: FragmentTransaction,
        fragmentContainerResId: Int,
        fragment: Fragment,
        tag: String,
        isReplace: Boolean = true,
        useBackStack: Boolean = false
    ) {
        fragmentTransaction.apply {
            setCustomAnimations(
                R.anim.slide_in_from_left, R.anim.slide_out_to_left, R.anim.slide_in_from_left, R.anim.slide_out_to_left
            )

            if (isReplace) {
                replace(fragmentContainerResId, fragment, tag)
            } else {
                add(fragmentContainerResId, fragment, tag)
            }

            if (useBackStack) {
                addToBackStack(null)
            }
        }
    }

    fun showDialogFragment(dialogFragment: DialogFragment?, parentFragment: Fragment?, tag: String?) {
        showDialogFragment(dialogFragment, parentFragment?.getSupportFragmentManager(), tag)
    }

    fun showDialogFragment(dialogFragment: DialogFragment?, activity: FragmentActivity?, tag: String?) {
        showDialogFragment(dialogFragment, activity?.supportFragmentManager, tag)
    }

    fun showDialogFragment(dialogFragment: DialogFragment?, fm: FragmentManager?, tag: String?) {
        if (dialogFragment == null || fm == null) return
        fm.run {
            if (isStateSaved || isDestroyed) return@run
            try {
                dialogFragment.show(fm, tag)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}