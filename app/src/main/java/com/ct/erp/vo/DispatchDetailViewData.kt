package com.ct.erp.vo

import com.ct.erp.base.adapter.BaseViewHolderData

enum class DisDetailViewHolderType {
    BASIC, COLLECT, QUANTITY, DATE
}

data class DispatchDetailViewData(
    val id: String
) : BaseViewHolderData<DisDetailViewHolderType>() {
    override val viewHolderType: DisDetailViewHolderType = DisDetailViewHolderType.BASIC
    override fun getDataSourceKey(): String {
        return "dis/detail/$id"
    }
}
