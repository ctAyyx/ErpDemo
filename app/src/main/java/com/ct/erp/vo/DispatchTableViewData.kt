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

    fun getFieldKey(): String {
        val array = columnKey.toCharArray()
        val builder = StringBuilder()
        array.forEachIndexed { index, c ->
            if (index == 0) {
                builder.append(c.toString().lowercase())
            } else if (c != '.') {
                builder.append(c.toString())
            }
        }
        return builder.toString()
    }
}

data class DispatchTabCellViewData(val cellTitle: String)