package com.ct.erp.base.adapter

import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.recyclerview.widget.ListAdapter
import com.ct.utils.getEnumValues

abstract class BaseAdapter<DATA : BaseViewHolderData<*>> :
    ListAdapter<DATA, BaseViewHolder<DATA>>(ViewDataDiffCallBack<DATA>()) {


    override fun getItemViewType(position: Int): Int {
        return if (position < 0) {
            -1
        } else {
            getItem(position).viewHolderType.ordinal
        }
    }

    fun appendList(@Nullable list: List<DATA>?) {
        if (list.isNullOrEmpty()) return
        val newList = mutableListOf<DATA>()
        newList.addAll(currentList)
        newList.addAll(list)
        submitList(newList)
    }

    @Suppress("UNCHECKED_CAST")
    final override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<DATA> =
        onCreateVH(parent, viewType) as BaseViewHolder<DATA>

    abstract fun onCreateVH(parent: ViewGroup, viewType: Int): BaseViewHolder<*>

    final override fun onBindViewHolder(holder: BaseViewHolder<DATA>, position: Int) {
        holder.onBind(this, getItem(position), position)
    }

    final override fun onBindViewHolder(
        holder: BaseViewHolder<DATA>, position: Int, payloads: MutableList<Any>
    ) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            holder.onBind(getItem(position), position, payloads)
        }
    }

    override fun onViewAttachedToWindow(holder: BaseViewHolder<DATA>) {
        super.onViewAttachedToWindow(holder)
        holder.onViewAttachedToWindow()
    }

    override fun onViewDetachedFromWindow(holder: BaseViewHolder<DATA>) {
        holder.onViewDetachedFromWindow()
        super.onViewDetachedFromWindow(holder)
    }

    final override fun onViewRecycled(holder: BaseViewHolder<DATA>) {
        holder.onRecycled()
        super.onViewRecycled(holder)
    }

    inline fun <reified VH_TYPE : Enum<VH_TYPE>> getViewHolderType(type: Int): VH_TYPE {
        return getEnumValues<VH_TYPE>()[type]
    }

}
