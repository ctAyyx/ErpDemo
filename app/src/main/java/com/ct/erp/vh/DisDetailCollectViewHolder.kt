package com.ct.erp.vh

import android.view.ViewGroup
import com.ct.erp.R
import com.ct.erp.base.adapter.BaseAdapter
import com.ct.erp.base.adapter.BaseDataBindingViewHolder
import com.ct.erp.databinding.ItemDisDetailCollectBinding
import com.ct.erp.dto.DispatchPlanApiData
import com.ct.erp.vo.DispatchDetailViewData
import com.ct.erp.vo.TabColumnHeaderViewData

class DisDetailCollectViewHolder(parent: ViewGroup) :
    BaseDataBindingViewHolder<ItemDisDetailCollectBinding, DispatchDetailViewData>(
        parent = parent,
        resId = R.layout.item_dis_detail_collect
    ) {
    override fun onBind(adapter: BaseAdapter<*>, data: DispatchDetailViewData, position: Int) {
        if (data.model != null) {
            initRow(data.model)
        }

    }

    private fun initRow(model: DispatchPlanApiData) {
        val entity = model.entity?.firstOrNull()
        val subEntity = entity?.subEntity?.firstOrNull()

        binding.tvItemCollect01.text = model.mONumber ?: ""
        binding.tvItemCollect02.text = model.mOEntrySeq ?: ""
        binding.tvItemCollect03.text = "未知字段"
        binding.tvItemCollect04.text = subEntity?.operNumber ?: ""
        binding.tvItemCollect05.text = model.productId?.number ?: ""
        binding.tvItemCollect06.text = "Pcs"
        binding.tvItemCollect07.text = "${subEntity?.qualifiedQty ?: 0}"
        binding.tvItemCollect08.text = "${subEntity?.wastageQty ?: 0}"
        binding.tvItemCollect09.text = "${subEntity?.scrapQty ?: 0}"
        binding.tvItemCollect10.text = "${subEntity?.matScrapQty ?: 0}"
        binding.tvItemCollect11.text = "${subEntity?.reWorkQty ?: 0}"
        binding.tvItemCollect12.text = "${subEntity?.reFinishQty ?: 0}"
        binding.tvItemCollect13.text = model.productType ?: ""
        binding.tvItemCollect14.text = subEntity?.operDescription?.firstOrNull()?.value ?: ""
        binding.tvItemCollect15.text = model.productId?.name?.firstOrNull()?.value ?: ""

        model.addCallback {
            binding.tvItemCollect07.text = "${subEntity?.qualifiedQty ?: 0}"
            binding.tvItemCollect08.text = "${subEntity?.wastageQty ?: 0}"
            binding.tvItemCollect09.text = "${subEntity?.scrapQty ?: 0}"
            binding.tvItemCollect10.text = "${subEntity?.matScrapQty ?: 0}"
            binding.tvItemCollect11.text = "${subEntity?.reWorkQty ?: 0}"
            binding.tvItemCollect12.text = "${subEntity?.reFinishQty ?: 0}"
        }
    }

}