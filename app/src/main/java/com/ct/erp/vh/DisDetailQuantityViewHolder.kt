package com.ct.erp.vh

import android.view.ViewGroup
import com.ct.erp.R
import com.ct.erp.base.adapter.BaseAdapter
import com.ct.erp.base.adapter.BaseDataBindingViewHolder
import com.ct.erp.databinding.ItemDisDetailQuantityBinding
import com.ct.erp.vo.DispatchDetailViewData

class DisDetailQuantityViewHolder(parent: ViewGroup) :
    BaseDataBindingViewHolder<ItemDisDetailQuantityBinding, DispatchDetailViewData>(
        parent = parent,
        resId = R.layout.item_dis_detail_quantity
    ) {
    override fun onBind(adapter: BaseAdapter<*>, data: DispatchDetailViewData, position: Int) {

    }
}