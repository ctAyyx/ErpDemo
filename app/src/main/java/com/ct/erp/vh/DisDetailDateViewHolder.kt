package com.ct.erp.vh

import android.view.ViewGroup
import com.ct.erp.R
import com.ct.erp.base.adapter.BaseAdapter
import com.ct.erp.base.adapter.BaseDataBindingViewHolder
import com.ct.erp.databinding.ItemDisDetailDateBinding
import com.ct.erp.vo.DispatchDetailViewData

class DisDetailDateViewHolder(parent: ViewGroup) :
    BaseDataBindingViewHolder<ItemDisDetailDateBinding, DispatchDetailViewData>(
        parent = parent,
        resId = R.layout.item_dis_detail_date
    ) {
    override fun onBind(adapter: BaseAdapter<*>, data: DispatchDetailViewData, position: Int) {

    }
}