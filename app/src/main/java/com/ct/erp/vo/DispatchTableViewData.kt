package com.ct.erp.vo


data class DispatchTableViewData(
    val rowHeader: List<TabRowHeaderViewData>,
    val columnHeader: List<TabColumnHeaderViewData>,
    val cells: List<List<DispatchTabCellViewData>>
)

data class TabRowHeaderViewData(val rowTitle: String)
data class TabColumnHeaderViewData(val columnTitle: String, val columnKey: String)
data class DispatchTabCellViewData(val cellTitle: String)