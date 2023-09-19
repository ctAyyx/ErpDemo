package com.ct.erp.vh

import android.view.ViewGroup
import com.ct.erp.R
import com.ct.erp.base.adapter.BaseAdapter
import com.ct.erp.base.adapter.BaseDataBindingViewHolder
import com.ct.erp.databinding.ItemDisDetailCollectBinding
import com.ct.erp.vo.DispatchDetailViewData

class DisDetailCollectViewHolder(parent: ViewGroup) :
    BaseDataBindingViewHolder<ItemDisDetailCollectBinding, DispatchDetailViewData>(
        parent = parent,
        resId = R.layout.item_dis_detail_collect
    ) {
    override fun onBind(adapter: BaseAdapter<*>, data: DispatchDetailViewData, position: Int) {

    }
}