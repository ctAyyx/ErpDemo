package com.ct.erp.vh

import android.view.View
import android.widget.TextView
import com.ct.erp.R
import com.ct.erp.vo.TabRowHeaderViewData
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder

class TableRowViewHolder(itemView: View) : AbstractViewHolder(itemView) {
    private var titleView: TextView? = null

    init {
        titleView = itemView.findViewById(R.id.tvTableRowTitle)
    }

    fun bindViewHolder(model: TabRowHeaderViewData?, isRowEnd: Boolean) {
        titleView?.text = if (isRowEnd) "报工" else model?.rowTitle
    }
}