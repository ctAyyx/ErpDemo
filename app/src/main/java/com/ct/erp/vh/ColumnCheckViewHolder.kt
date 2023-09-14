package com.ct.erp.vh

import android.view.ViewGroup
import com.ct.erp.R
import com.ct.erp.base.adapter.BaseAdapter
import com.ct.erp.base.adapter.BaseDataBindingViewHolder
import com.ct.erp.databinding.ItemColumnCheckBinding
import com.ct.erp.vo.TabColumnHeaderViewData

class ColumnCheckViewHolder(parent: ViewGroup) :
    BaseDataBindingViewHolder<ItemColumnCheckBinding, TabColumnHeaderViewData>(
        parent, R.layout.item_column_check
    ) {
    override fun onBind(adapter: BaseAdapter<*>, data: TabColumnHeaderViewData, position: Int) {
        binding.checkItemColumn.text = data.columnTitle
        binding.checkItemColumn.isChecked = data.isChecked
        binding.checkItemColumn.setOnCheckedChangeListener { _, isChecked ->
            data.isChecked = isChecked
        }
    }
}