package com.ct.erp.base.adapter


/**
 * 标记当前ViewHolder 是否充满
 */
interface IsFullViewHolder {
    fun isFullViewHolder(): Boolean
}

/**
 *  当ItemView被点击
 */
interface OnItemClickHolder<T> {
    fun onItemClick(data: T, position: Int)
}