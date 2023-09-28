package com.ct.erp.vo

import com.ct.erp.base.adapter.BaseViewHolderData
import com.ct.erp.dto.DispatchPlanApiData

enum class DisDetailViewHolderType {
    BASIC, COLLECT, QUANTITY, DATE
}

data class DispatchDetailViewData(
    val id: String,

    val model: DispatchPlanApiData?=null,
) : BaseViewHolderData<DisDetailViewHolderType>() {
    override val viewHolderType: DisDetailViewHolderType = DisDetailViewHolderType.BASIC
    override fun getDataSourceKey(): String {
        return "dis/detail/$id"
    }


}
