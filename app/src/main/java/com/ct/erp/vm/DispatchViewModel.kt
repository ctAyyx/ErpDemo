package com.ct.erp.vm

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.ct.erp.base.BaseModel
import com.ct.erp.base.BaseViewModel
import com.ct.erp.dto.DispatchDetailListApiData
import com.ct.erp.dto.ServiceResult
import com.ct.erp.vo.DispatchTabCellViewData
import com.ct.erp.vo.TabColumnHeaderViewData
import com.ct.erp.vo.TabRowHeaderViewData
import com.ct.erp.vo.DispatchTableViewData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DispatchViewModel @Inject constructor(application: Application, model: BaseModel?) :
    BaseViewModel(application, model) {

    // 所有的可配置选项
    val tableAllColumn by lazy { mutableListOf<TabColumnHeaderViewData>() }

    // 所有数据
    val tableAllCell by lazy { mutableListOf<DispatchDetailListApiData>() }

    private val checkedTabColumn = mutableListOf<TabColumnHeaderViewData>()

    val dispatchViewData by lazy { MutableLiveData<DispatchTableViewData>() }

    fun setCheckedTableColumn(newList: List<TabColumnHeaderViewData>) {
        checkedTabColumn.clear()
        checkedTabColumn.addAll(newList)
        dispatchViewData.value = convertDispatchApiData2ViewData(tableAllCell)
    }

    fun loadDispatchList() {
        launch {
            // 加载所有配置选项
            val columnList = getColumnHeaderList()
            tableAllColumn.clear()
            tableAllColumn.addAll(columnList)
            setCheckedTableColumn(getDefaultColumnHeaderList())
            //记载数据
            val response = mock()//serviceApi.getDispatchList()


            if (isSuccess(response)) {
                tableAllCell.clear()
                response.data?.let { tableAllCell.addAll(it) }
                dispatchViewData.value = convertDispatchApiData2ViewData(response.data)
            }
        }
    }

    private fun mock() = ServiceResult(
        code = "200", errorMsg = "", data = listOf(
            DispatchDetailListApiData(),
            DispatchDetailListApiData(),
            DispatchDetailListApiData(),
            DispatchDetailListApiData(),
            DispatchDetailListApiData(),
            DispatchDetailListApiData(),
            DispatchDetailListApiData(),
            DispatchDetailListApiData(),
            DispatchDetailListApiData(),
            DispatchDetailListApiData(),
            DispatchDetailListApiData(),
            DispatchDetailListApiData(),
            DispatchDetailListApiData(),
            DispatchDetailListApiData(),
            DispatchDetailListApiData(),
            DispatchDetailListApiData(),
            DispatchDetailListApiData(),
            DispatchDetailListApiData(),
            DispatchDetailListApiData(),
            DispatchDetailListApiData(),
        )
    )

    private fun convertDispatchApiData2ViewData(apiData: List<DispatchDetailListApiData>?): DispatchTableViewData {

        val rowHeaderList = mutableListOf<TabRowHeaderViewData>()
        val cellList = mutableListOf<List<DispatchTabCellViewData>>()
        apiData?.forEachIndexed { index, data ->
            rowHeaderList.add(TabRowHeaderViewData("序号:$index"))
            val rowList = mutableListOf<DispatchTabCellViewData>()
            checkedTabColumn.forEach { columnHeader ->
                val cell = buildCell(columnHeader, data)
                rowList.add(cell)
            }
            cellList.add(rowList)
        }
        return DispatchTableViewData(rowHeader = rowHeaderList, columnHeader = checkedTabColumn, cells = cellList)
    }


    private fun buildCell(
        header: TabColumnHeaderViewData, data: DispatchDetailListApiData
    ): DispatchTabCellViewData {
        return when (header.columnKey) {
            "" -> DispatchTabCellViewData("${header.columnTitle}")
            else -> DispatchTabCellViewData("")
        }
    }


    /**
     *
     */
    private fun getColumnHeaderList() = listOf<TabColumnHeaderViewData>(
        TabColumnHeaderViewData("生产工单号", ""),
        TabColumnHeaderViewData("产品", ""),
        TabColumnHeaderViewData("图号", ""),
        TabColumnHeaderViewData("批号", ""),
        TabColumnHeaderViewData("版次", ""),
        TabColumnHeaderViewData("工序", ""),
        TabColumnHeaderViewData("计划数量", ""),
        TabColumnHeaderViewData("计划开工时间", ""),
        TabColumnHeaderViewData("计划完工时间", ""),
        TabColumnHeaderViewData("报工状态", ""),
        TabColumnHeaderViewData("实际开工时间", ""),
        TabColumnHeaderViewData("实际完工时间", ""),
        TabColumnHeaderViewData("实作工时", ""),
        TabColumnHeaderViewData("操作工", ""),
        TabColumnHeaderViewData("车间", ""),
        TabColumnHeaderViewData("工作中心", ""),
        TabColumnHeaderViewData("设备", ""),
        TabColumnHeaderViewData("班组", ""),
        TabColumnHeaderViewData("班次", ""),
        TabColumnHeaderViewData("报工", ""),
    )

    private fun getDefaultColumnHeaderList(): List<TabColumnHeaderViewData> {
        val result = mutableListOf<TabColumnHeaderViewData>()

        tableAllColumn.forEach {
            when (it.columnTitle) {
                "生产工单号", "产品", "图号", "批号" -> {
                    it.isChecked = true
                    result.add(it)
                }
            }
        }

        return result
    }
}