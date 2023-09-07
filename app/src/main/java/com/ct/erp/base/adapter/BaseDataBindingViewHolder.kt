package com.ct.erp.base.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseDataBindingViewHolder<out BINDING : ViewDataBinding, DATA : ViewData> private constructor(
    view: View
) : BaseViewHolder<DATA>(view = view) {

    constructor(
        parent: ViewGroup, @LayoutRes resId: Int
    ) : this(LayoutInflater.from(parent.context).inflate(resId, parent, false))


    val binding: BINDING = DataBindingUtil.bind(itemView)!!

}