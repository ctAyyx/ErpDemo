package com.ct.erp.vh

import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import com.ct.erp.R
import com.ct.erp.adapter.CommonSpinnerAdapter
import com.ct.erp.base.adapter.BaseAdapter
import com.ct.erp.base.adapter.BaseDataBindingViewHolder
import com.ct.erp.databinding.ItemDisDetailBasicBinding
import com.ct.erp.dto.DispatchPlanApiData
import com.ct.erp.ext.setCommonAdapter
import com.ct.erp.vo.DispatchDetailViewData
import com.ct.utils.LogUtils

class DisDetailBasicViewHolder(parent: ViewGroup) :
    BaseDataBindingViewHolder<ItemDisDetailBasicBinding, DispatchDetailViewData>(
        parent = parent, resId = R.layout.item_dis_detail_basic
    ) {
    override fun onBind(adapter: BaseAdapter<*>, data: DispatchDetailViewData, position: Int) {
        binding.model = data.model
        initDocType(data = data.model)
    }

    /**
     * 初始化单据类型
     */
    private fun initDocType(data: DispatchPlanApiData) {
        val billType = data.billType?.name ?: return
        val adapterData = billType.map {
            it.value ?: ""
        }
        binding.spinnerItemBasic.setCommonAdapter(adapterData) { position ->
            val model = billType[position]
        }
    }
}