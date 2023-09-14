package com.ct.erp.vh

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import com.ct.erp.R
import com.ct.erp.vo.TabColumnHeaderViewData
import com.evrencoskun.tableview.ITableView
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractSorterViewHolder

class TableColumnViewHolder(itemView: View, tableView: ITableView) : AbstractSorterViewHolder(itemView) {

    private var titleView: TextView? = null
    private var root: LinearLayoutCompat? = null

    init {
        titleView = itemView.findViewById<TextView>(R.id.tvTableColumnTitle)
        root = itemView.findViewById(R.id.linearRoot)
    }

    fun bindViewHolder(data: TabColumnHeaderViewData?) {
        titleView?.text = data?.columnTitle

        root?.apply {
            layoutParams.width = LinearLayoutCompat.LayoutParams.WRAP_CONTENT
            titleView?.requestLayout()
        }
    }
}