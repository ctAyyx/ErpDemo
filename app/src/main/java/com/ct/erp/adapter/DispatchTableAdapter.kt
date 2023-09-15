package com.ct.erp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ct.erp.R
import com.ct.erp.vh.TableCellTextViewHolder
import com.ct.erp.vh.TableColumnViewHolder
import com.ct.erp.vh.TableRowViewHolder
import com.ct.erp.vo.DispatchTabCellViewData
import com.ct.erp.vo.TabColumnHeaderViewData
import com.ct.erp.vo.TabRowHeaderViewData
import com.evrencoskun.tableview.adapter.AbstractTableAdapter
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder
import javax.inject.Inject

class DispatchTableAdapter @Inject constructor() :
    AbstractTableAdapter<TabColumnHeaderViewData, TabRowHeaderViewData, DispatchTabCellViewData>() {


    /**
     * 创建不同的Cell ViewHolder
     */
    override fun onCreateCellViewHolder(parent: ViewGroup, viewType: Int): AbstractViewHolder {
        return TableCellTextViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_table_cell_text, parent, false)
        )
    }

    override fun onBindCellViewHolder(
        holder: AbstractViewHolder, cellItemModel: DispatchTabCellViewData?, columnPosition: Int, rowPosition: Int
    ) {
        if (holder is TableCellTextViewHolder) holder.bindViewHolder(cellItemModel, columnPosition, rowPosition)
    }

    override fun onCreateColumnHeaderViewHolder(parent: ViewGroup, viewType: Int): AbstractViewHolder {
        return TableColumnViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_table_column, parent, false), tableView
        )
    }

    override fun onBindColumnHeaderViewHolder(
        holder: AbstractViewHolder, columnHeaderItemModel: TabColumnHeaderViewData?, columnPosition: Int
    ) {
        if (holder is TableColumnViewHolder) holder.bindViewHolder(columnHeaderItemModel)
    }


    override fun onCreateRowHeaderViewHolder(parent: ViewGroup, viewType: Int, isRowEnd: Boolean): AbstractViewHolder {
        return TableRowViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_table_row, parent, false)
        )
    }


    override fun onBindRowHeaderViewHolder(
        holder: AbstractViewHolder, rowHeaderItemModel: TabRowHeaderViewData?, rowPosition: Int, isRowEnd: Boolean
    ) {
        if (holder is TableRowViewHolder) holder.bindViewHolder(rowHeaderItemModel, isRowEnd)
    }

    override fun onCreateCornerView(parent: ViewGroup): View {
        return LayoutInflater.from(parent.context).inflate(R.layout.item_corner, parent, false)
    }

    override fun onCreateCornerEndView(parent: ViewGroup): View {
        return LayoutInflater.from(parent.context).inflate(R.layout.item_corner, parent, false)
    }


}