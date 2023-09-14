package com.ct.erp.vm

import android.app.Application
import androidx.lifecycle.MutableLiveData
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

    val dispatchViewData by lazy { MutableLiveData<DispatchTableViewData>() }

    fun loadDispatchList() {
        launch {
            val response = mock()//serviceApi.getDispatchList()
            if (isSuccess(response)) {
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
        val rowList = mutableListOf<TabRowHeaderViewData>()
        val columnList = getColumnHeaderList()
        val cellList = mutableListOf<List<DispatchTabCellViewData>>()
        apiData?.forEachIndexed { index, data ->
            rowList.add(TabRowHeaderViewData("序号:$index"))
            val rowList = mutableListOf<DispatchTabCellViewData>()
            columnList.forEach { columnHeader ->
                val cell = buildCell(columnHeader, data)
                rowList.add(cell)
            }
            cellList.add(rowList)
        }
        return DispatchTableViewData(rowHeader = rowList, columnHeader = columnList, cells = cellList)
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
}