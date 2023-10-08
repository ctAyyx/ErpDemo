package com.ct.erp.vh

import android.provider.ContactsContract.Data
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import com.ct.erp.R
import com.ct.erp.base.adapter.BaseAdapter
import com.ct.erp.base.adapter.BaseDataBindingViewHolder
import com.ct.erp.databinding.ItemDisDetailQuantityBinding
import com.ct.erp.dto.DispatchPlanApiData
import com.ct.erp.dto.SubEntity
import com.ct.erp.ext.onEndDrawableClick
import com.ct.erp.popup.PopupHelper
import com.ct.erp.vo.DispatchDetailViewData
import com.ct.utils.LogUtils
import com.ct.utils.TimeUtils
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.Calendar
import java.util.Date

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

        binding.tvItemQuantityNum2Str.text = "未知字段"
        binding.tvItemQuantityNum2.text = subEntity?.operNumber ?: ""

        binding.tvItemQuantityWork.text = subEntity?.processId?.name?.firstOrNull()?.value ?: ""
        binding.tvItemOperDescription.text = subEntity?.operDescription?.firstOrNull()?.value ?: ""
        binding.tvItemSeqWorkCenterId.text =
            entity?.seqWorkCenterId?.name?.firstOrNull()?.value ?: ""
        binding.tvNum06Str.text = subEntity?.operStatus
        binding.tvNum07Str.text = subEntity?.operSrcType
        binding.tvNum08Str.setText(model.mTONo ?: "")
        binding.tvItemSeqNumber.text = entity?.seqNumber ?: ""
        binding.tvNum10Str.setText("未知字段") //model.description
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
        binding.tvItemQuantity07NumStr.text = "${subEntity?.reFinishQty ?: 0}"
        binding.tvItemQuantity08NumStr.text = entity?.seqRefer ?: ""
        binding.tvItemQuantity09NumStr.text = subEntity?.operDescription?.firstOrNull()?.value ?: ""

        binding.tvItemQuantity01NumStr.doAfterTextChanged {
            allCount(model, subEntity)
        }
        binding.tvItemQuantity02NumStr.doAfterTextChanged {
            allCount(model, subEntity)
        }
        binding.tvItemQuantity03NumStr.doAfterTextChanged {
            allCount(model, subEntity)
        }
        binding.tvItemQuantity04NumStr.doAfterTextChanged {
            allCount(model, subEntity)
        }
        binding.tvItemQuantity06NumStr.doAfterTextChanged {
            allCount(model, subEntity)
        }
    }


    private fun allCount(model: DispatchPlanApiData, subEntity: SubEntity?) {
        val num1 = binding.tvItemQuantity01NumStr.text.toString().toIntOrNull() ?: 0
        val num2 = binding.tvItemQuantity02NumStr.text.toString().toIntOrNull() ?: 0
        val num3 = binding.tvItemQuantity03NumStr.text.toString().toIntOrNull() ?: 0
        val num4 = binding.tvItemQuantity04NumStr.text.toString().toIntOrNull() ?: 0
        val num5 = binding.tvItemQuantity06NumStr.text.toString().toIntOrNull() ?: 0

        subEntity?.qualifiedQty = num1
        subEntity?.scrapQty = num2
        subEntity?.matScrapQty = num3
        subEntity?.wastageQty = num4
        subEntity?.reWorkQty = num5

        subEntity?.unqualifiedQty = num2 + num3 + num4
        subEntity?.reFinishQty = num1 + num2 + num3 + num4 + num5

        binding.tvItemQuantity05NumStr.text = "${subEntity?.unqualifiedQty}"
        binding.tvItemQuantity07NumStr.text = "${subEntity?.reFinishQty}"

        model.notifyDataChanged()
    }

    /**
     * 初始化 返修处理模块
     */
    private fun initRepair(model: DispatchPlanApiData) {
        val entity = model.entity?.firstOrNull()
        val subEntity = entity?.subEntity?.firstOrNull()

        binding.tvItemBack01Str.text = "未知字段"
        binding.tvItemBack02Str.text = "未知字段"
        binding.tvItemBack03Str.text = "未知字段"

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

        binding.tvItemQuality01Str.text = "未知字段"
        binding.tvItemQuality02Str.text = "未知字段"
        binding.tvItemQuality03Str.text = "未知字段"

        binding.tvItemQuality05Str.text = "未知字段"
        binding.tvItemQuality06Str.text = "未知字段"
        binding.tvItemQuality07Str.text = "未知字段"
        binding.tvItemQuality08Str.text = "未知字段"

        binding.tvItemQuality08Num.isChecked = subEntity?.isFirstPieceInspect ?: false
        showCalender(binding.tvItemQuality03Str) {

        }
    }


    private fun showCalender(tv: TextView, callback: (String) -> Unit) {
        tv.onEndDrawableClick {
            PopupHelper.showDateChooseDialog(context = tv.context) { year, month, day, hour, minute ->
                val newTime = TimeUtils.getFormatTimeBy01(year, month, day, hour, minute)
                tv.text = newTime
                callback.invoke(newTime)




            }
        }
    }
}