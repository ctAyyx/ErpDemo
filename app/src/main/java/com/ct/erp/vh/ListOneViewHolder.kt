package com.ct.erp.vh

import android.view.ViewGroup
import com.ct.erp.R
import com.ct.erp.base.adapter.BaseAdapter
import com.ct.erp.base.adapter.BaseDataBindingViewHolder
import com.ct.erp.databinding.ItemListOneBinding
import com.ct.erp.dto.TestItemViewData

class ListOneViewHolder(parent: ViewGroup) :
    BaseDataBindingViewHolder<ItemListOneBinding, TestItemViewData.TestOneViewData>(
        parent = parent, resId = R.layout.item_list_one
    ) {
    override fun onBind(adapter: BaseAdapter<*>, data: TestItemViewData.TestOneViewData, position: Int) {
        binding.tvItemListOne.text = data.name
    }
}