package com.ct.erp.base.adapter

import androidx.recyclerview.widget.DiffUtil

class ViewDataDiffCallBack<DATA : ViewData> : DiffUtil.ItemCallback<DATA>() {
    override fun areItemsTheSame(oldItem: DATA, newItem: DATA) =
        oldItem.getDataSourceKey() == newItem.getDataSourceKey()

    override fun areContentsTheSame(oldItem: DATA, newItem: DATA) = oldItem == newItem

    override fun getChangePayload(oldItem: DATA, newItem: DATA): Any? {
        return if (oldItem.getPayloadHash() != 0) {
            oldItem.getChangePayload(newItem)
        } else {
            null
        }
    }
}