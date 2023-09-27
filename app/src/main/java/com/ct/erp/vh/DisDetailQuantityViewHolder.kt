package com.ct.erp.vh

import android.view.ViewGroup
import com.ct.erp.R
import com.ct.erp.base.adapter.BaseAdapter
import com.ct.erp.base.adapter.BaseDataBindingViewHolder
import com.ct.erp.databinding.ItemDisDetailQuantityBinding
import com.ct.erp.dto.DispatchPlanApiData
import com.ct.erp.vo.DispatchDetailViewData

class DisDetailQuantityViewHolder(parent: ViewGroup) :
    BaseDataBindingViewHolder<ItemDisDetailQuantityBinding, DispatchDetailViewData>(
        parent = parent, resId = R.layout.item_dis_detail_quantity
    ) {
    override fun onBind(adapter: BaseAdapter<*>, data: DispatchDetailViewData, position: Int) {
        binding.model = data.model
        initView(data = data.model)
    }

    private fun initView(data: DispatchPlanApiData) {
        val entity = data.entity?.firstOrNull()
        val subEntity = entity?.subEntity?.firstOrNull()

        entity?.let {
            binding.tvItemSeqWorkCenterId.text = it.seqWorkCenterId?.name?.firstOrNull()?.value ?: ""
            binding.tvItemSeqNumber.text = it.seqNumber ?: ""
        }

        subEntity?.let {
            binding.tvItemOperDescription.text = it.operDescription?.firstOrNull()?.value ?: ""
            binding.tvItemCount01Str.text = "${it.qualifiedQty}"
            binding.tvItemCount02Str.text = "${it.unqualifiedQty}"
            binding.tvItemCount03Str.text = "${it.reFinishQty}"
        }


    }
}