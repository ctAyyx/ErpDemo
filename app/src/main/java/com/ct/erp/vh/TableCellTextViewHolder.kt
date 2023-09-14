package com.ct.erp.vh

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import com.ct.erp.R
import com.ct.erp.vo.DispatchTabCellViewData
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder

class TableCellTextViewHolder(itemView: View) : AbstractViewHolder(itemView) {

    private var titleView: TextView? = null
    private var root: LinearLayoutCompat? = null

    init {
        titleView = itemView.findViewById(R.id.tvItemTableCellTitle)
        root = itemView.findViewById(R.id.linearRoot)
    }


    fun bindViewHolder(model: DispatchTabCellViewData?, columnPosition: Int, rowPosition: Int) {
        titleView?.text = model?.cellTitle
        root?.apply {
            layoutParams.width = LinearLayoutCompat.LayoutParams.WRAP_CONTENT
            titleView?.requestLayout()
        }
    }

}