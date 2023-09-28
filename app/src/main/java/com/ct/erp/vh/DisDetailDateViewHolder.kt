package com.ct.erp.vh

import android.view.ViewGroup
import android.widget.TextView
import com.ct.erp.R
import com.ct.erp.base.adapter.BaseAdapter
import com.ct.erp.base.adapter.BaseDataBindingViewHolder
import com.ct.erp.databinding.ItemDisDetailDateBinding
import com.ct.erp.dto.DispatchPlanApiData
import com.ct.erp.ext.onEndDrawableClick
import com.ct.erp.popup.PopupHelper
import com.ct.erp.vo.DispatchDetailViewData

class DisDetailDateViewHolder(parent: ViewGroup) :
    BaseDataBindingViewHolder<ItemDisDetailDateBinding, DispatchDetailViewData>(
        parent = parent, resId = R.layout.item_dis_detail_date
    ) {
    override fun onBind(adapter: BaseAdapter<*>, data: DispatchDetailViewData, position: Int) {
        if (data.model != null) {
            initProcess(data.model)
            initDate(data.model)
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
        binding.tvItemQuantityNum2Str.text = entity?.seqNumber ?: ""
        binding.tvItemQuantityNum2.text = "${subEntity?.operQty}"
        binding.tvItemQuantityNum3Str.text = subEntity?.operDescription?.firstOrNull()?.value ?: ""
        binding.tvItemQuantityNum4Str.text = subEntity?.shiftSliceIdId ?: ""
        binding.tvItemQuantityNum5Str.text = subEntity?.shiftGroupIdId ?: ""
        binding.tvItemQuantityNum6Str.text = subEntity?.resourceIdId ?: ""
        binding.tvItemQuantityNum7Str.text = subEntity?.equipmentIdId ?: ""
        binding.tvItemQuantityNum08Str.text = model.auxPropIdId ?: ""
        binding.tvItemQuantityNum09Str.text = subEntity?.equipmentIdId ?: ""
    }

    private fun initEvent(model: DispatchPlanApiData) {

    }

    /**
     * 初始化 日期模块
     */
    private fun initDate(model: DispatchPlanApiData) {
        showCalender(binding.tvItemDateReal01Date)
        showCalender(binding.tvItemDateReal02Date)
        showCalender(binding.tvItemDateReal03Date)
        showCalender(binding.tvItemDateReal04Date)
        showCalender(binding.tvItemDateReal05Date)
        showCalender(binding.tvItemDateReal06Date)

        val entity = model.entity?.firstOrNull()
        val subEntity = entity?.subEntity?.firstOrNull()

        binding.tvItemDateReal01Date.text = subEntity?.prepareStartTime ?: ""
        binding.tvItemDateReal02Date.text = subEntity?.prepareFinishTime ?: ""
        binding.tvItemDateReal03Date.text = subEntity?.processStartTime ?: ""
        binding.tvItemDateReal04Date.text = subEntity?.processFinishTime ?: ""
        binding.tvItemDateReal05Date.text = subEntity?.removeStartTime ?: ""
        binding.tvItemDateReal06Date.text = subEntity?.removeFinishTime ?: ""

    }

    private fun showCalender(tv: TextView) {
        tv.onEndDrawableClick {
            PopupHelper.showDateChooseDialog(context = tv.context) { year, month, day ->
                tv.text = "$year-${month + 1}-$day"
            }
        }
    }
}