package com.ct.erp.vh

import android.view.ViewGroup
import com.ct.erp.R
import com.ct.erp.base.adapter.BaseAdapter
import com.ct.erp.base.adapter.BaseDataBindingViewHolder
import com.ct.erp.databinding.ItemDisDetailBasicBinding
import com.ct.erp.vo.DispatchDetailViewData

class DisDetailBasicViewHolder(parent: ViewGroup) :
    BaseDataBindingViewHolder<ItemDisDetailBasicBinding, DispatchDetailViewData>(
        parent = parent, resId = R.layout.item_dis_detail_basic
    ) {
    override fun onBind(adapter: BaseAdapter<*>, data: DispatchDetailViewData, position: Int) {
    }
}