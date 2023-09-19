package com.ct.erp.dto

import com.google.gson.annotations.SerializedName

/**
 * "FBillNo": "PGMX000001", //单据编号
"FResourceId.FNumber": "SC000007", //资源编号
"FWorkQty": 10, //派工数量
"FMoBillNo": "MO000011", //生产订单编号
"FProcessId.FName": "装触摸屏", //作业名称
"FEquipmentId.FNumber": null, //设备编号
"FReSelHeadQty": 0, //生产单位返修汇报选单数量
"FOptPlanNo": "OP000005", //工序计划单号
"FSeqNumber": "0", //工序序列
"FPlanEndTime": "2020-02-10T08:00:00", //计划结束时间
"FGroupId": 0, //组号
"FEmpText": "杜成婧", //操作工
"FShiftGroupId.FNumber": "BZ003", //班组编号
"FBarCode": "PGMX000001-100001", //条码
"FOperNumber": "10", //工序号
"FMOEntryId": 100016, //生产订单分录内码
"FBaseUnitID.FNumber": "Pcs", //基本计量单位编号
"FMouldProdMixId": 0, //模具产品组合
"FCreatorId.FName": "demo", //创建人
"FEmpId.FName": "杜成婧", //操作工基础资料名称
"FResourceId.FName": "切割组", //资源名称
"FFinishSelQty": 10, //完成选单数量
"FUnitTransOperQty": 1, //单位转换工序数量
"FOperUnitID.FName": "Pcs", //工序计量单位名称
"FReWorkBaseQty": 0, //基本单位待返修数量
"FBaseWorkQty": 10, //基本单位派工数量
"FReSelBaseQty": 0, //基本单位返修汇报选单数量
"FWorkCenterId": 100227, //工作中心ID
"FCreateMode": "A", //创建方式(A：HMI，B：PC)
"FMoSeq": 1, //生产订单行号
"FDispatchedQty": 10, //已派工数量
"FEquipmentId.FName": null, //设备名称
"FMaterialId.FNumber": "S1.06", //物料代码
"FOperUnitID.FNumber": "Pcs", //工序计量单位代码
"FFinishSelHeadQty": 10, //生产单位完成选单数量
"FUnitID.FName": "Pcs", //计量单位名称
"FUnitTransHeadQty": 1, //单位转换表头数量
"FEndTime": "2020-02-10T17:12:33.73", //实际结束日期
"FBaseFinishSelQty": 10, //基本单位完成选单数量
"FCreateDate": "2020-02-10T16:56:53.483", //创建日期
"FProcessId.FNumber": "PRC000010", //作业编号
"FBeginTime": "2020-02-10T17:11:21", //实际开始日期
"FShiftGroupId.FName": "包装组", //班组名称
"FWorkHeadQty": 10, //生产单位派工数量
"FMaterialId.FName": "智能手机-6S", //物料名称
"FUnitID.FNumber": "Pcs", //计量单位名称
"FOperId": 100037, //工序ID
"FShiftSliceId": 40405, //班次ID
"FCreatorId": "100002", //创建人
"FReWorkHeadQty": 0, //生产单位待返修数量
"FPlanBeginTime": "2020-02-10T08:00:00", //计划开始时间
"FEmpId.FStaffNumber": "201801006", //操作工编号
"FDispatchTime": "2020-02-10T16:40:11.07", //派工日期
"FReSelQty": 0, //返修汇报选单数量
"FBaseUnitID.FName": "Pcs", //基本计量单位名称
"FReWorkQty": 0, //待返修数量
"FPlanningQty": 10, //计划完工数量
"FStatus": "D", //状态{
"Value": "B",
"Caption": "开工",
"Seq": 2,
"Invalid": false
},
{
"Value": "A",
"Caption": "未开工",
"Seq": 1,
"Invalid": false
},
{
"Value": "P",
"Caption": "计划",
"Seq": 5,
"Invalid": false
},
{
"Value": "D",
"Caption": "完工",
"Seq": 4,
"Invalid": false
},
{
"Value": "C",
"Caption": "暂停",
"Seq": 3,
"Invalid": false
}
"FMouldId": 0 //模具
 */
data class DispatchDetailListApiData(
    @SerializedName("FBarCode") val fBarCode: String? = null,
    @SerializedName("FBaseFinishSelQty") val fBaseFinishSelQty: Int? = null,
    @SerializedName("FBaseUnitID.FName") val fBaseUnitIDFName: String? = null,
    @SerializedName("FBaseUnitID.FNumber") val fBaseUnitIDFNumber: String? = null,
    @SerializedName("FBaseWorkQty") val fBaseWorkQty: Int? = null,
    @SerializedName("FBeginTime") val fBeginTime: String? = null,
    @SerializedName("FBillNo") val fBillNo: String? = null,
    @SerializedName("FCreateDate") val fCreateDate: String? = null,
    @SerializedName("FCreateMode") val fCreateMode: String? = null,
    @SerializedName("FCreatorId") val fCreatorId: String? = null,
    @SerializedName("FCreatorId.FName") val fCreatorIdFName: String? = null,
    @SerializedName("FDispatchTime") val fDispatchTime: String? = null,
    @SerializedName("FDispatchedQty") val fDispatchedQty: Int? = null,
    @SerializedName("FEmpId.FName") val fEmpIdFName: String? = null,
    @SerializedName("FEmpId.FStaffNumber") val fEmpIdFStaffNumber: String? = null,
    @SerializedName("FEmpText") val fEmpText: String? = null,
    @SerializedName("FEndTime") val fEndTime: String? = null,
    @SerializedName("FEquipmentId.FName") val fEquipmentIdFName: String? = null,
    @SerializedName("FEquipmentId.FNumber") val fEquipmentIdFNumber: String? = null,
    @SerializedName("FFinishSelHeadQty") val fFinishSelHeadQty: Int? = null,
    @SerializedName("FFinishSelQty") val fFinishSelQty: Int? = null,
    @SerializedName("FGroupId") val fGroupId: Int? = null,
    @SerializedName("FMOEntryId") val fMOEntryId: Int? = null,
    @SerializedName("FMaterialId.FName") val fMaterialIdFName: String? = null,
    @SerializedName("FMaterialId.FNumber") val fMaterialIdFNumber: String? = null,
    @SerializedName("FMoBillNo") val fMoBillNo: String? = null,
    @SerializedName("FMoSeq") val fMoSeq: Int? = null,
    @SerializedName("FMouldId") val fMouldId: Int? = null,
    @SerializedName("FMouldProdMixId") val fMouldProdMixId: Int? = null,
    @SerializedName("FOperId") val fOperId: Int? = null,
    @SerializedName("FOperNumber") val fOperNumber: String? = null,
    @SerializedName("FOperUnitID.FName") val fOperUnitIDFName: String? = null,
    @SerializedName("FOperUnitID.FNumber") val fOperUnitIDFNumber: String? = null,
    @SerializedName("FOptPlanNo") val fOptPlanNo: String? = null,
    @SerializedName("FPlanBeginTime") val fPlanBeginTime: String? = null,
    @SerializedName("FPlanEndTime") val fPlanEndTime: String? = null,
    @SerializedName("FPlanningQty") val fPlanningQty: Int? = null,
    @SerializedName("FProcessId.FName") val fProcessIdFName: String? = null,
    @SerializedName("FProcessId.FNumber") val fProcessIdFNumber: String? = null,
    @SerializedName("FReSelBaseQty") val fReSelBaseQty: Int? = null,
    @SerializedName("FReSelHeadQty") val fReSelHeadQty: Int? = null,
    @SerializedName("FReSelQty") val fReSelQty: Int? = null,
    @SerializedName("FReWorkBaseQty") val fReWorkBaseQty: Int? = null,
    @SerializedName("FReWorkHeadQty") val fReWorkHeadQty: Int? = null,
    @SerializedName("FReWorkQty") val fReWorkQty: Int? = null,
    @SerializedName("FResourceId.FName") val fResourceIdFName: String? = null,
    @SerializedName("FResourceId.FNumber") val fResourceIdFNumber: String? = null,
    @SerializedName("FSeqNumber") val fSeqNumber: String? = null,
    @SerializedName("FShiftGroupId.FName") val fShiftGroupIdFName: String? = null,
    @SerializedName("FShiftGroupId.FNumber") val fShiftGroupIdFNumber: String? = null,
    @SerializedName("FShiftSliceId") val fShiftSliceId: Int? = null,
    @SerializedName("FStatus") val fStatus: String? = null,
    @SerializedName("FUnitID.FName") val fUnitIDFName: String? = null,
    @SerializedName("FUnitID.FNumber") val fUnitIDFNumber: String? = null,
    @SerializedName("FUnitTransHeadQty") val fUnitTransHeadQty: Int? = null,
    @SerializedName("FUnitTransOperQty") val fUnitTransOperQty: Int? = null,
    @SerializedName("FWorkCenterId") val fWorkCenterId: Int? = null,
    @SerializedName("FWorkHeadQty") val fWorkHeadQty: Int? = null,
    @SerializedName("FWorkQty") val fWorkQty: Int? = null
)

data class FStatus(
    @SerializedName("Caption") val caption: String? = null,
    @SerializedName("Invalid") val invalid: Boolean? = null,
    @SerializedName("Seq") val seq: Int? = null,
    @SerializedName("Value") val value: String? = null
) {
    companion object {
        fun buildStatus(status: String?): FStatus? {
            return when (status) {
                "A" -> FStatus(value = status, invalid = false, seq = 1, caption = "未开工")
                "B" -> FStatus(value = status, invalid = false, seq = 2, caption = "开工")
                "C" -> FStatus(value = status, invalid = false, seq = 3, caption = "暂停")
                "D" -> FStatus(value = status, invalid = false, seq = 4, caption = "完工")
                "P" -> FStatus(value = status, invalid = false, seq = 5, caption = "计划")
                else -> null
            }

        }
    }
}