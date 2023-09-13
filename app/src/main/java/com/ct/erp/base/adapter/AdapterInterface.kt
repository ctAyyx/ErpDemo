package com.ct.erp.base.adapter


/**
 * 标记当前ViewHolder 是否充满
 */
interface SpanSizeLookHolder {
    fun getItemColumnSpan(position: Int, spanCount: Int): Int
}

/**
 *  当ItemView被点击
 */
interface OnItemClickHolder<T> {
    fun onItemClick(data: T, position: Int)
}