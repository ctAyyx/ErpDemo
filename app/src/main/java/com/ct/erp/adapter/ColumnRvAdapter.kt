package com.ct.erp.adapter

import android.view.ViewGroup
import com.ct.erp.base.adapter.BaseAdapter
import com.ct.erp.base.adapter.BaseViewHolder
import com.ct.erp.vh.ColumnCheckViewHolder
import com.ct.erp.vo.TabColumnHeaderViewData
import javax.inject.Inject

class ColumnRvAdapter @Inject constructor() : BaseAdapter<TabColumnHeaderViewData>() {
    override fun onCreateVH(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return ColumnCheckViewHolder(parent)
    }
}