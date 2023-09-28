package com.ct.erp.vm

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.ct.erp.base.BaseModel
import com.ct.erp.base.BaseViewModel
import com.ct.erp.dto.DispatchDetailListApiData
import com.ct.erp.dto.DispatchPlanApiData
import com.ct.erp.dto.ServiceResult
import com.ct.erp.vo.DispatchDetailViewData
import com.ct.erp.vo.DispatchTabCellViewData
import com.ct.erp.vo.DispatchTableViewData
import com.ct.erp.vo.TabColumnHeaderViewData
import com.ct.erp.vo.TabRowHeaderViewData
import com.ct.utils.LogUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import java.io.InputStreamReader
import javax.inject.Inject

@HiltViewModel
class DispatchViewModel @Inject constructor(application: Application, model: BaseModel?) :
    BaseViewModel(application, model) {
    /**
     * 所有头部
     */
    val tableAllColumn by lazy { mutableListOf<TabColumnHeaderViewData>() }

    /**
     * 接口响应数据  每个 DispatchDetailListApiData 表示表格中的一列
     */
    val tableAllCell by lazy { mutableListOf<DispatchDetailListApiData>() }

    /**
     * 需要显示的头部
     */
    private val checkedTabColumn = mutableListOf<TabColumnHeaderViewData>()


    private var startRow: Int = 0
    private val limit: Int = 10
    private var filter: String = ""

    val dispatchViewData by lazy { MutableLiveData<DispatchTableViewData>() }

    fun setCheckedTableColumn(newList: List<TabColumnHeaderViewData>) {
        checkedTabColumn.clear()
        checkedTabColumn.addAll(newList)
        dispatchViewData.value = convertDispatchApiData2ViewData(tableAllCell)
    }

    fun doRefresh(filter: String) {
        clearAll()
        loadDispatchList(filter = filter, startRow = startRow, limit = limit)
    }

    fun loadMore() {
        loadDispatchList(filter = filter, startRow = startRow, limit = limit)
    }

    val dispatchDetail by lazy { MutableLiveData<List<DispatchDetailViewData>>() }

    fun loadDispatchDetail() {
        launch {
            delay(3000)
            val open = getApp().assets.open("dis_detail.json")
            val ins = InputStreamReader(open)
            val data = Gson().fromJson(ins, DispatchPlanApiData::class.java)
            val response = ServiceResult(code = "200", errorMsg = "", data = data)
            if (isSuccess(response)) {
                val viewData = DispatchDetailViewData(id = "0", model = response.data)
                dispatchDetail.value = listOf(viewData, viewData, viewData, viewData)
            }
        }
    }


    private fun loadDispatchList(filter: String, startRow: Int, limit: Int) {
        launch {
            loadAllColumnHeader()
            loadDefaultShowColumnHeader()
            //记载数据
            delay(3000)
            val response = mock()//serviceApi.getDispatchList()
            if (isSuccess(response)) {
                saveTableResponse(startRow == 0, response.data)
                this.filter = filter
                this.startRow = startRow + 1

                dispatchViewData.value = convertDispatchApiData2ViewData(response.data)
            }
        }
    }

    /**
     * 加载所有头部
     */
    private suspend fun loadAllColumnHeader() {
        if (tableAllColumn.isEmpty()) {
            // 加载所有配置选项
            val columnList = getColumnHeaderList()
            tableAllColumn.addAll(columnList)
        }
    }

    /**
     * 加载默认显示的头部
     */
    private suspend fun loadDefaultShowColumnHeader() {
        if (checkedTabColumn.isEmpty()) {
            checkedTabColumn.addAll(getDefaultColumnHeaderList())
        }
    }

    /**
     * 保存数据
     */
    private suspend fun saveTableResponse(isRefresh: Boolean, result: List<DispatchDetailListApiData>?) {
        if (isRefresh) tableAllCell.clear()
        if (!result.isNullOrEmpty()) tableAllCell.addAll(result)


    }


    /**
     * 清除数据
     */
    private fun clearAll() {
        tableAllColumn.clear()
        checkedTabColumn.clear()
        tableAllCell.clear()

        filter = ""
        startRow = 0
    }


    private fun matchKey(key: String, data: DispatchDetailListApiData): Any? {
        return try {
            val cls = data::class.java
            val field = cls.getDeclaredField(key)
            field.isAccessible = true
            field.get(data)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }


    private fun mock(): ServiceResult<List<DispatchDetailListApiData>> {
        val open = getApp().assets.open("dis_list.json")
        val ins = InputStreamReader(open)
        val data = Gson().fromJson<List<DispatchDetailListApiData>>(
            ins, object : TypeToken<List<DispatchDetailListApiData>>() {}.type
        )
        return ServiceResult(code = "200", errorMsg = "", data = data)
    }

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
        return DispatchTabCellViewData("${matchKey(header.getFieldKey(), data)}")
    }


    /**
     *
     */
    private fun getColumnHeaderList() = listOf<TabColumnHeaderViewData>(

        //
        TabColumnHeaderViewData("单据编号", "FBillNo"),
        TabColumnHeaderViewData("资源编号", "FResourceId.FNumber"),
        TabColumnHeaderViewData("派工数量", "FWorkQty"),
        TabColumnHeaderViewData("生产订单编号", "FMoBillNo"),
        TabColumnHeaderViewData("作业名称", "FProcessId.FName"),
        TabColumnHeaderViewData("设备编号", "FEquipmentId.FNumber"),
        TabColumnHeaderViewData("生产单位返修汇报选单数量", "FReSelHeadQty"),
        TabColumnHeaderViewData("工序计划单号", "FOptPlanNo"),
        TabColumnHeaderViewData("工序序列", "FSeqNumber"),
        TabColumnHeaderViewData("计划结束时间", "FPlanEndTime"),
        TabColumnHeaderViewData("组号", "FGroupId"),
        TabColumnHeaderViewData("操作工", "FEmpText"),
        TabColumnHeaderViewData("班组编号", "FShiftGroupId.FNumber"),
        TabColumnHeaderViewData("条码", "FBarCode"),
        TabColumnHeaderViewData("工序号", "FOperNumber"),
        TabColumnHeaderViewData("生产订单分录内码", "FMOEntryId"),
        TabColumnHeaderViewData("基本计量单位编号", "FBaseUnitID.FNumber"),
        TabColumnHeaderViewData("模具产品组合", "FMouldProdMixId"),
        TabColumnHeaderViewData("创建人", "FCreatorId.FName"),
        TabColumnHeaderViewData("操作工基础资料名称", "FEmpId.FName"),
        TabColumnHeaderViewData("资源名称", "FResourceId.FName"),
        TabColumnHeaderViewData("完成选单数量", "FFinishSelQty"),
        TabColumnHeaderViewData("单位转换工序数量", "FUnitTransOperQty"),
        TabColumnHeaderViewData("工序计量单位名称", "FOperUnitID.FName"),
        TabColumnHeaderViewData("基本单位待返修数量", "FReWorkBaseQty"),
        TabColumnHeaderViewData("基本单位派工数量", "FBaseWorkQty"),
        TabColumnHeaderViewData("基本单位返修汇报选单数量", "FReSelBaseQty"),
        TabColumnHeaderViewData("工作中心ID", "FWorkCenterId"),
        TabColumnHeaderViewData("创建方式", "FCreateMode"),
        TabColumnHeaderViewData("生产订单行号", "FMoSeq"),
        TabColumnHeaderViewData("已派工数量", "FDispatchedQty"),
        TabColumnHeaderViewData("设备名称", "FEquipmentId.FName"),
        TabColumnHeaderViewData("物料代码", "FMaterialId.FNumber"),
        TabColumnHeaderViewData("工序计量单位代码", "FOperUnitID.FNumber"),
        TabColumnHeaderViewData("生产单位完成选单数量", "FFinishSelHeadQty"),
        TabColumnHeaderViewData("计量单位名称", "FUnitID.FName"),
        TabColumnHeaderViewData("单位转换表头数量", "FUnitTransHeadQty"),
        TabColumnHeaderViewData("实际结束日期", "FEndTime"),
        TabColumnHeaderViewData("基本单位完成选单数量", "FBaseFinishSelQty"),
        TabColumnHeaderViewData("创建日期", "FCreateDate"),
        TabColumnHeaderViewData("作业编号", "FProcessId.FNumber"),
        TabColumnHeaderViewData("实际开始日期", "FBeginTime"),
        TabColumnHeaderViewData("班组名称", "FShiftGroupId.FName"),
        TabColumnHeaderViewData("生产单位派工数量", "FWorkHeadQty"),
        TabColumnHeaderViewData("物料名称", "FMaterialId.FName"),
        TabColumnHeaderViewData("计量单位名称", "FUnitID.FNumber"),
        TabColumnHeaderViewData("工序ID", "FOperId"),
        TabColumnHeaderViewData("班次ID", "FShiftSliceId"),
        TabColumnHeaderViewData("创建人ID", "FCreatorId"),
        TabColumnHeaderViewData("生产单位待返修数量", "FReWorkHeadQty"),
        TabColumnHeaderViewData("计划开始时间", "FPlanBeginTime"),
        TabColumnHeaderViewData("操作工编号", "FEmpId.FStaffNumber"),
        TabColumnHeaderViewData("派工日期", "FDispatchTime"),
        TabColumnHeaderViewData("返修汇报选单数量", "FReSelQty"),
        TabColumnHeaderViewData("基本计量单位名称", "FBaseUnitID.FName"),
        TabColumnHeaderViewData("待返修数量", "FReWorkQty"),
        TabColumnHeaderViewData("计划完工数量", "FPlanningQty"),
        TabColumnHeaderViewData("状态", "FStatus"),
        TabColumnHeaderViewData("模具", "FMouldId"),
    )

    /**
     *    "生产工单号",
    "产品",
    "图号",
    "批号",
    "版次",
    "工序",
    "计划数量",
    "计划开工时间",
    "计划完工时间",
    "报工状态",
    "实际开工时间",
    "实际完工时间",
    "实作工时",
    "操作工",
    "车间",
    "工作中心",
    "设备",
    "班组",
    "班次"
     */
    private fun getDefaultColumnHeaderList(): List<TabColumnHeaderViewData> {
        val result = mutableListOf<TabColumnHeaderViewData>()

        tableAllColumn.forEach {
            when (it.columnTitle) {
                "单据编号",
                "资源编号",
                "派工数量",
                "生产订单编号",
                "作业名称",
                "设备编号",
                "生产单位返修汇报选单数量",
                "工序计划单号",
                "工序序列",
                "计划结束时间",
                "组号",
                "操作工",
                "班组编号",
                "条码",
                "工序号",
                "生产订单分录内码",
                "基本计量单位编号",
                "模具产品组合",
                "创建人",
                "操作工基础资料名称",
                "资源名称",
                "完成选单数量",
                "单位转换工序数量",
                "工序计量单位名称",
                -> {
                    it.isChecked = true
                    result.add(it)
                }
            }
        }

        return result
    }
}