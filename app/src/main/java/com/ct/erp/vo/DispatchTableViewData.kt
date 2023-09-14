package com.ct.erp.vo

import com.ct.erp.base.adapter.BaseViewHolderData


data class DispatchTableViewData(
    val rowHeader: List<TabRowHeaderViewData>,
    val columnHeader: List<TabColumnHeaderViewData>,
    val cells: List<List<DispatchTabCellViewData>>
)

data class TabRowHeaderViewData(val rowTitle: String)
data class TabColumnHeaderViewData(val columnTitle: String, val columnKey: String, var isChecked: Boolean = false) :
    BaseViewHolderData<HomeViewHolderType>() {
    override fun getDataSourceKey(): String = ""
    override val viewHolderType: HomeViewHolderType = HomeViewHolderType.TYPE_TITLE

}

data class DispatchTabCellViewData(val cellTitle: String)