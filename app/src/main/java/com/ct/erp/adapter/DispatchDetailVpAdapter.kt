package com.ct.erp.adapter

import android.view.ViewGroup
import com.ct.erp.base.adapter.BaseAdapter
import com.ct.erp.base.adapter.BaseViewHolder
import com.ct.erp.vh.DisDetailBasicViewHolder
import com.ct.erp.vh.DisDetailCollectViewHolder
import com.ct.erp.vh.DisDetailDateViewHolder
import com.ct.erp.vh.DisDetailQuantityViewHolder
import com.ct.erp.vo.DispatchDetailViewData

class DispatchDetailVpAdapter : BaseAdapter<DispatchDetailViewData>() {
    override fun onCreateVH(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (viewType) {
            0 -> DisDetailBasicViewHolder(parent)
            1 -> DisDetailCollectViewHolder(parent)
            2 -> DisDetailQuantityViewHolder(parent)
            else -> DisDetailDateViewHolder(parent)
        }
    }


    override fun getItemViewType(position: Int): Int {
        return position
    }
}