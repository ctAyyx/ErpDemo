package com.ct.erp.base.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<DATA : ViewData> : RecyclerView.ViewHolder {

    constructor(
        parent: ViewGroup,
        @LayoutRes resId: Int,
    ) : super(LayoutInflater.from(parent.context).inflate(resId, parent, false))

    constructor(view: View) : super(view)

    /**
     * 正常加载数据时调用
     */
    abstract fun onBind(adapter: BaseAdapter<*>, data: DATA, position: Int)

    /**
     * 数据更新时调用
     */
    open fun onBind(
        data: DATA, position: Int, payloads: MutableList<Any>
    ) {
    }

    open fun onRecycled() {}

    open fun onViewAttachedToWindow() {}

    open fun onViewDetachedFromWindow() {}

}