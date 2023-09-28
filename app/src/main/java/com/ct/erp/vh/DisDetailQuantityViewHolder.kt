package com.ct.erp.vh

import android.view.ViewGroup
import android.widget.TextView
import com.ct.erp.R
import com.ct.erp.base.adapter.BaseAdapter
import com.ct.erp.base.adapter.BaseDataBindingViewHolder
import com.ct.erp.databinding.ItemDisDetailQuantityBinding
import com.ct.erp.dto.DispatchPlanApiData
import com.ct.erp.ext.onEndDrawableClick
import com.ct.erp.popup.PopupHelper
import com.ct.erp.vo.DispatchDetailViewData

class DisDetailQuantityViewHolder(parent: ViewGroup) :
    BaseDataBindingViewHolder<ItemDisDetailQuantityBinding, DispatchDetailViewData>(
        parent = parent, resId = R.layout.item_dis_detail_quantity
    ) {
    override fun onBind(adapter: BaseAdapter<*>, data: DispatchDetailViewData, position: Int) {
        binding.model = data.model
        if (data.model != null) {
            initProcess(data.model)
            initQuantity(data.model)
            initRepair(data.model)
            initCollect(data.model)
            initQuality(data.model)

        }
    }


    /**
     * 初始化 工序模块
     */
    private fun initProcess(model: DispatchPlanApiData) {
        val entity = model.entity?.firstOrNull()
        val subEntity = entity?.subEntity?.firstOrNull()

        binding.tvItemQuantityNumStr.text = model.mONumber ?: ""
        binding.tvItemQuantityNum.text = model.mOEntrySeq ?: ""
        binding.tvItemQuantityWork.text = subEntity?.processId?.name?.firstOrNull()?.value ?: ""
        binding.tvItemOperDescription.text = subEntity?.operDescription?.firstOrNull()?.value ?: ""
        binding.tvItemSeqWorkCenterId.text = entity?.seqWorkCenterId?.name?.firstOrNull()?.value ?: ""
        binding.tvNum06Str.text = subEntity?.operStatus
        binding.tvNum07Str.text = subEntity?.operSrcType
        binding.tvNum08Str.setText(model.mTONo ?: "")
        binding.tvItemSeqNumber.text = entity?.seqNumber ?: ""
        // binding.tvNum10Str.text = ""//model.description
    }

    /**
     * 初始化 数量模块
     */
    private fun initQuantity(model: DispatchPlanApiData) {
        val entity = model.entity?.firstOrNull()
        val subEntity = entity?.subEntity?.firstOrNull()

        binding.tvItemQuantity01NumStr.setText("${subEntity?.qualifiedQty ?: 0}")
        binding.tvItemQuantity02NumStr.setText("${subEntity?.scrapQty ?: 0}")
        binding.tvItemQuantity03NumStr.setText("${subEntity?.matScrapQty ?: 0}")
        binding.tvItemQuantity04NumStr.setText("${subEntity?.wastageQty ?: 0}")
        binding.tvItemQuantity05NumStr.text = "${subEntity?.unqualifiedQty ?: 0}"
        binding.tvItemQuantity06NumStr.setText("${subEntity?.reWorkQty ?: 0}")
        binding.tvItemQuantity07NumStr.setText("${subEntity?.reFinishQty ?: 0}")
        binding.tvItemQuantity08NumStr.text = entity?.seqRefer ?: ""
        binding.tvItemQuantity09NumStr.text = subEntity?.operDescription?.firstOrNull()?.value ?: ""
    }

    /**
     * 初始化 返修处理模块
     */
    private fun initRepair(model: DispatchPlanApiData) {
        val entity = model.entity?.firstOrNull()
        val subEntity = entity?.subEntity?.firstOrNull()
    }

    /**
     * 初始化 累计数量模块
     */
    private fun initCollect(model: DispatchPlanApiData) {
        val entity = model.entity?.firstOrNull()
        val subEntity = entity?.subEntity?.firstOrNull()

        binding.tvItemCount01Str.text = "${subEntity?.qualifiedQty ?: 0}"
        binding.tvItemCount02Str.text = "${subEntity?.unqualifiedQty ?: 0}"
        binding.tvItemCount03Str.text = "${subEntity?.reFinishQty ?: 0}"
    }

    /**
     * 初始化 质量模块
     */
    private fun initQuality(model: DispatchPlanApiData) {
        val entity = model.entity?.firstOrNull()
        val subEntity = entity?.subEntity?.firstOrNull()

        binding.tvItemQuality08Num.isChecked = subEntity?.isFirstPieceInspect ?: false
        showCalender(binding.tvItemQuality03Str)
    }


    private fun showCalender(tv: TextView) {
        tv.onEndDrawableClick {
            PopupHelper.showDateChooseDialog(context = tv.context) { year, month, day ->
                tv.text = "$year-${month + 1}-$day"
            }
        }
    }
}