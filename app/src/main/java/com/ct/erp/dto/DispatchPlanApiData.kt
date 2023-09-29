package com.ct.erp.dto

import androidx.databinding.BaseObservable
import com.google.gson.annotations.SerializedName
import java.lang.ref.WeakReference


data class DispatchPlanApiData(
    @SerializedName("ApproveDate")
    val approveDate: String? = "",
    @SerializedName("ApproverId")
    val approverId: ApproverId? = null,
    @SerializedName("ApproverId_Id")
    val approverIdId: String? = null,
    @SerializedName("AutoInStore")
    val autoInStore: String? = "",
    @SerializedName("AuxPropId_Id")
    val auxPropIdId: String? = null,
    @SerializedName("BFLowId_Id")
    val bFLowIdId: String? = "",
    @SerializedName("BaseQty")
    val baseQty: Int? = 0,
    @SerializedName("BaseUnitId")
    val baseUnitId: BaseUnitId? = null,
    @SerializedName("BaseUnitId_Id")
    val baseUnitIdId: String? = null,
    @SerializedName("BillNo")
    val billNo: String? = "",
    @SerializedName("BillType")
    val billType: BillType? = null,
    @SerializedName("BillType_Id")
    val billTypeId: String? = "",
    @SerializedName("BomId")
    val bomId: BomId? = null,
    @SerializedName("BomId_Id")
    val bomIdId: String? = null,
    @SerializedName("CANCELER_Id")
    val cANCELERId: String? = null,
    @SerializedName("CancelStatus")
    val cancelStatus: String? = "",
    @SerializedName("CreateDate")
    val createDate: String? = "",
    @SerializedName("CreatorId")
    val creatorId: CreatorId? = null,
    @SerializedName("CreatorId_Id")
    val creatorIdId: String? = null,
    @SerializedName("DecuctionTime")
    val decuctionTime: String? = "",
    @SerializedName("DemandBillEntryId")
    val demandBillEntryId: String? = null,
    @SerializedName("DemandBillId")
    val demandBillId: String? = null,
    @SerializedName("DemandType")
    val demandType: String? = "",
    @SerializedName("Description")
    val description: List<Any>? = null,
    @SerializedName("DocumentStatus")
    val documentStatus: String? = "",
    @SerializedName("Entity")
    val entity: List<Entity>? = null,
    @SerializedName("FBillHead_Link")
    val fBillHeadLink: List<FBillHeadLink>? = null,
    @SerializedName("FFormId")
    val fFormId: String? = "",
    @SerializedName("FailAutoInStore")
    val failAutoInStore: String? = "",
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("InspectCheckSchemaId_Id")
    val inspectCheckSchemaIdId: String? = null,
    @SerializedName("IsEntrust")
    val isEntrust: Boolean? = false,
    @SerializedName("IsWastageInStock")
    val isWastageInStock: Boolean? = false,
    @SerializedName("Lot_Id")
    val lotId: String? = null,
    @SerializedName("Lot_Text")
    val lotText: String? = "",
    @SerializedName("MOEntryId")
    val mOEntryId: String? = null,
    @SerializedName("MOEntrySeq")
    val mOEntrySeq: String? = null,
    @SerializedName("MOId")
    val mOId: String? = null,
    @SerializedName("MOIsSuspend")
    val mOIsSuspend: String? = "",
    @SerializedName("MONumber")
    val mONumber: String? = "",
    @SerializedName("MOQty")
    val mOQty: Int? = 0,
    @SerializedName("MOStatus")
    val mOStatus: String? = "",
    @SerializedName("MOUnitId")
    val mOUnitId: MOUnitId? = null,
    @SerializedName("MOUnitId_Id")
    val mOUnitIdId: String? = null,
    @SerializedName("MTONo")
    val mTONo: String? = "",
    @SerializedName("ModifierId")
    val modifierId: ModifierId? = null,
    @SerializedName("ModifierId_Id")
    val modifierIdId: String? = null,
    @SerializedName("ModifyDate")
    val modifyDate: String? = "",
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<Any>? = null,
    @SerializedName("OutSrcWay")
    val outSrcWay: String? = "",
    @SerializedName("OwnerId")
    val ownerId: OwnerId? = null,
    @SerializedName("OwnerId_Id")
    val ownerIdId: String? = null,
    @SerializedName("OwnerTypeId")
    val ownerTypeId: String? = "",
    @SerializedName("ParentId")
    val parentId: String? = null,
    @SerializedName("PlanFinishTime")
    val planFinishTime: String? = "",
    @SerializedName("PlanStartTime")
    val planStartTime: String? = "",
    @SerializedName("PlanType")
    val planType: String? = "",
    @SerializedName("PrintTimes")
    val printTimes: Int? = 0,
    @SerializedName("ProDepartmentId")
    val proDepartmentId: ProDepartmentId? = null,
    @SerializedName("ProDepartmentId_Id")
    val proDepartmentIdId: String? = null,
    @SerializedName("ProOrgId")
    val proOrgId: ProOrgId? = null,
    @SerializedName("ProOrgId_Id")
    val proOrgIdId: String? = null,
    @SerializedName("ProcessCheckSchemaId_Id")
    val processCheckSchemaIdId: String? = null,
    @SerializedName("ProduceType")
    val produceType: String? = "",
    @SerializedName("ProductId")
    val productId: ProductId? = null,
    @SerializedName("ProductId_Id")
    val productIdId: String? = null,
    @SerializedName("ProductLine_Id")
    val productLineId: String? = null,
    @SerializedName("ProductType")
    val productType: String? = "",
    @SerializedName("ProjectNo")
    val projectNo: String? = "",
    @SerializedName("RootBillId")
    val rootBillId: String? = null,
    @SerializedName("RouteId")
    val routeId: RouteId? = null,
    @SerializedName("RouteId_Id")
    val routeIdId: String? = null,
    @SerializedName("SaleOrderEntrySeq")
    val saleOrderEntrySeq: Int? = 0,
    @SerializedName("SaleOrderNumber")
    val saleOrderNumber: String? = "",
    @SerializedName("ScheduleModelId")
    val scheduleModelId: ScheduleModelId? = null,
    @SerializedName("ScheduleModelId_Id")
    val scheduleModelIdId: String? = null,
    @SerializedName("ScheduleSeq")
    val scheduleSeq: Int? = 0,
    @SerializedName("SourceBillNo")
    val sourceBillNo: String? = "",
    @SerializedName("SourceBillType")
    val sourceBillType: String? = "",
    @SerializedName("StockInOrgId")
    val stockInOrgId: StockInOrgId? = null,
    @SerializedName("StockInOrgId_Id")
    val stockInOrgIdId: String? = null
) : BaseObservable() {


    private var callback: WeakReference<OnDispatchCallback>? = null

    fun addCallback(callback: OnDispatchCallback) {
        this.callback = WeakReference(callback)
    }

    fun removeCallback(callback: OnDispatchCallback) {
        this.callback?.clear()
    }

    fun notifyDataChanged() {
        this.callback?.get()?.invoke()
    }

    /**
     * 获取产品序列号
     */
    fun getProductSerialNum(): String {
        return ""
    }

    fun getProcessUnit(): String {
        return entity?.firstOrNull()?.subEntity?.firstOrNull()?.processUnit ?: ""
    }
}

data class ApproverId(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("Name")
    val name: String? = null,
    @SerializedName("UserAccount")
    val userAccount: String? = null
)

data class BaseUnitId(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("msterID")
    val msterId: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText?>? = null,
    @SerializedName("Name")
    val name: List<Name?>? = null,
    @SerializedName("Number")
    val number: String? = null,
    @SerializedName("Precision")
    val precision: Int? = null,
    @SerializedName("RoundType")
    val roundType: String? = null,
    @SerializedName("UNITCONVERTRATE")
    val uNITCONVERTRATE: List<UNITCONVERTRATE?>? = null
)

data class BillType(
    @SerializedName("Id")
    val id: String? = "",
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)

data class BomId(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("msterID")
    val msterId: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<Any?>? = null,
    @SerializedName("Name")
    val name: List<Any?>? = null,
    @SerializedName("Number")
    val number: String? = null
)

data class CreatorId(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("Name")
    val name: String? = null,
    @SerializedName("UserAccount")
    val userAccount: String? = null
)

data class Entity(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("RptWriteBackBaseQty")
    val rptWriteBackBaseQty: Int? = 0,
    @SerializedName("RptWriteBackQty")
    val rptWriteBackQty: Int? = 0,
    @SerializedName("SchMainSeq")
    val schMainSeq: Boolean? = false,
    @SerializedName("Seq")
    val seq: Int? = 0,
    @SerializedName("SeqAlignment")
    val seqAlignment: String? = "",
    @SerializedName("SeqIn")
    val seqIn: Int? = 0,
    @SerializedName("SeqName")
    val seqName: List<SeqName>? = null,
    @SerializedName("SeqNumber")
    val seqNumber: String? = "",
    @SerializedName("SeqOut")
    val seqOut: Int? = 0,
    @SerializedName("SeqPlanFinishTime")
    val seqPlanFinishTime: String? = "",
    @SerializedName("SeqPlanStartTime")
    val seqPlanStartTime: String? = "",
    @SerializedName("SeqQty")
    val seqQty: Int? = 0,
    @SerializedName("SeqRefer")
    val seqRefer: String? = "",
    @SerializedName("SeqSrcEntryId")
    val seqSrcEntryId: String? = null,
    @SerializedName("SeqSrcType")
    val seqSrcType: String? = "",
    @SerializedName("SeqType")
    val seqType: String? = "",
    @SerializedName("SeqWorkCenterId")
    val seqWorkCenterId: SeqWorkCenterId? = null,
    @SerializedName("SeqWorkCenterId_Id")
    val seqWorkCenterIdId: String? = null,
    @SerializedName("SplitFromOper")
    val splitFromOper: Int? = 0,
    @SerializedName("SplitQty")
    val splitQty: Int? = 0,
    @SerializedName("SplitToOper")
    val splitToOper: Int? = 0,
    @SerializedName("SrcEntityId")
    val srcEntityId: String? = null,
    @SerializedName("SubEntity")
    val subEntity: List<SubEntity>? = null
) {

}

data class FBillHeadLink(
    @SerializedName("BaseQty")
    val baseQty: Int? = null,
    @SerializedName("BaseQtyOld")
    val baseQtyOld: Int? = null,
    @SerializedName("FlowId")
    val flowId: String? = null,
    @SerializedName("FlowLineId")
    val flowLineId: String? = null,
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("RuleId")
    val ruleId: String? = null,
    @SerializedName("SBillId")
    val sBillId: String? = null,
    @SerializedName("SId")
    val sId: String? = null,
    @SerializedName("STableId")
    val sTableId: String? = null,
    @SerializedName("STableName")
    val sTableName: String? = null
)

data class MOUnitId(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("msterID")
    val msterId: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = "",
    @SerializedName("Precision")
    val precision: Int? = 0,
    @SerializedName("RoundType")
    val roundType: String? = "",
    @SerializedName("UNITCONVERTRATE")
    val uNITCONVERTRATE: List<UNITCONVERTRATE>? = null
)

data class ModifierId(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("Name")
    val name: String? = null,
    @SerializedName("UserAccount")
    val userAccount: String? = null
)

data class OwnerId(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("msterID")
    val msterId: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)

data class ProDepartmentId(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("msterID")
    val msterId: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)

data class ProOrgId(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)

data class ProductId(
    @SerializedName("DocumentStatus")
    val documentStatus: String? = "",
    @SerializedName("ForbidStatus")
    val forbidStatus: String? = "",
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("MaterialAuxPty")
    val materialAuxPty: List<MaterialAuxPty>? = null,
    @SerializedName("MaterialBase")
    val materialBase: List<MaterialBase>? = null,
    @SerializedName("MaterialStock")
    val materialStock: List<MaterialStock>? = null,
    @SerializedName("msterID")
    val msterId: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = "",
    @SerializedName("Specification")
    val specification: List<Specification>? = null,
    @SerializedName("UseOrgId")
    val useOrgId: UseOrgId? = null,
    @SerializedName("UseOrgId_Id")
    val useOrgIdId: String? = null
)

data class RouteId(
    @SerializedName("FFormId")
    val fFormId: String? = "",
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("IsWastageInStock")
    val isWastageInStock: Boolean? = false,
    @SerializedName("msterID")
    val msterId: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = "",
    @SerializedName("ProduceType")
    val produceType: String? = "",
    @SerializedName("RouteOperSeq")
    val routeOperSeq: List<RouteOperSeq>? = null
)

data class ScheduleModelId(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("msterID")
    val msterId: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = "",
    @SerializedName("SchedulingWay")
    val schedulingWay: String? = ""
)

data class StockInOrgId(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)


data class Name(
    @SerializedName("Key")
    val key: Int? = null,
    @SerializedName("Value")
    val value: String? = null
)

data class UNITCONVERTRATE(
    @SerializedName("ConvertType")
    val convertType: String? = null,
    @SerializedName("Id")
    val Id: String? = null
)


data class SeqName(
    @SerializedName("Key")
    val key: Int? = null,
    @SerializedName("Value")
    val value: String? = null
)

data class SeqWorkCenterId(
    @SerializedName("DeptID")
    val deptID: DeptID? = null,
    @SerializedName("DeptID_Id")
    val deptIDId: String? = null,
    @SerializedName("EffectDate")
    val effectDate: String? = "",
    @SerializedName("ExpireDate")
    val expireDate: String? = "",
    @SerializedName("FFormId")
    val fFormId: String? = "",
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("IsDiscreteOperDispDetail")
    val isDiscreteOperDispDetail: Boolean? = false,
    @SerializedName("msterID")
    val msterId: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = "",
    @SerializedName("OptCtrlCodeID")
    val optCtrlCodeID: OptCtrlCodeId? = null,
    @SerializedName("OptCtrlCodeID_Id")
    val optCtrlCodeIDId: String? = null,
    @SerializedName("ProcessID_Id")
    val processIDId: String? = null,
    @SerializedName("UseOrgId")
    val useOrgId: UseOrgId? = null,
    @SerializedName("UseOrgId_Id")
    val useOrgIdId: String? = null,
    @SerializedName("WorkCenterCapacity")
    val workCenterCapacity: List<WorkCenterCapacity>? = null,
    @SerializedName("WorkCenterScheduling")
    val workCenterScheduling: List<WorkCenterScheduling>? = null
)


class SubEntity {
    @SerializedName("Activity1BaseQty")
    val activity1BaseQty: Int? = null

    @SerializedName("Activity1FormulaId")
    val activity1FormulaId: ActivityFormulaId? = null

    @SerializedName("Activity1FormulaId_Id")
    val activity1FormulaIdId: String? = null

    @SerializedName("Activity1Id")
    val activity1Id: ActivityId? = null

    @SerializedName("Activity1Id_Id")
    val activity1IdId: String? = null

    @SerializedName("Activity1Qty")
    val activity1Qty: Int? = null

    @SerializedName("Activity1RepFormulaId")
    val activity1RepFormulaId: ActivityRepFormulaId? = null

    @SerializedName("Activity1RepFormulaId_Id")
    val activity1RepFormulaIdId: String? = null

    @SerializedName("Activity1ReportQty")
    val activity1ReportQty: Int? = null

    @SerializedName("Activity1UnitId")
    val activity1UnitId: ActivityUnitId? = null

    @SerializedName("Activity1UnitId_Id")
    val activity1UnitIdId: String? = null

    @SerializedName("Activity2BaseQty")
    val activity2BaseQty: Int? = null

    @SerializedName("Activity2FormulaId")
    val activity2FormulaId: ActivityFormulaId? = null

    @SerializedName("Activity2FormulaId_Id")
    val activity2FormulaIdId: String? = null

    @SerializedName("Activity2Id")
    val activity2Id: ActivityId? = null

    @SerializedName("Activity2Id_Id")
    val activity2IdId: String? = null

    @SerializedName("Activity2Qty")
    val activity2Qty: Int? = null

    @SerializedName("Activity2RepFormulaId")
    val activity2RepFormulaId: ActivityRepFormulaId? = null

    @SerializedName("Activity2RepFormulaId_Id")
    val activity2RepFormulaIdId: String? = null

    @SerializedName("Activity2ReportQty")
    val activity2ReportQty: Int? = null

    @SerializedName("Activity2UnitId")
    val activity2UnitId: ActivityUnitId? = null

    @SerializedName("Activity2UnitId_Id")
    val activity2UnitIdId: String? = null

    @SerializedName("Activity3BaseQty")
    val activity3BaseQty: Int? = null

    @SerializedName("Activity3FormulaId")
    val activity3FormulaId: ActivityFormulaId? = null

    @SerializedName("Activity3FormulaId_Id")
    val activity3FormulaIdId: String? = null

    @SerializedName("Activity3Id")
    val activity3Id: ActivityId? = null

    @SerializedName("Activity3Id_Id")
    val activity3IdId: String? = null

    @SerializedName("Activity3Qty")
    val activity3Qty: Int? = null

    @SerializedName("Activity3RepFormulaId")
    val activity3RepFormulaId: ActivityRepFormulaId? = null

    @SerializedName("Activity3RepFormulaId_Id")
    val activity3RepFormulaIdId: String? = null

    @SerializedName("Activity3ReportQty")
    val activity3ReportQty: Int? = null

    @SerializedName("Activity3UnitId")
    val activity3UnitId: ActivityUnitId? = null

    @SerializedName("Activity3UnitId_Id")
    val activity3UnitIdId: String? = null

    @SerializedName("Activity4BaseQty")
    val activity4BaseQty: Int? = null

    @SerializedName("Activity4FormulaId_Id")
    val activity4FormulaIdId: String? = null

    @SerializedName("Activity4Id_Id")
    val activity4IdId: String? = null

    @SerializedName("Activity4Qty")
    val activity4Qty: Int? = null

    @SerializedName("Activity4RepFormulaId_Id")
    val activity4RepFormulaIdId: String? = null

    @SerializedName("Activity4ReportQty")
    val activity4ReportQty: Int? = null

    @SerializedName("Activity4UnitId_Id")
    val activity4UnitIdId: String? = null

    @SerializedName("Activity5BaseQty")
    val activity5BaseQty: Int? = null

    @SerializedName("Activity5FormulaId_Id")
    val activity5FormulaIdId: String? = null

    @SerializedName("Activity5Id_Id")
    val activity5IdId: String? = null

    @SerializedName("Activity5Qty")
    val activity5Qty: Int? = null

    @SerializedName("Activity5RepFormulaId_Id")
    val activity5RepFormulaIdId: String? = null

    @SerializedName("Activity5ReportQty")
    val activity5ReportQty: Int? = null

    @SerializedName("Activity5UnitId_Id")
    val activity5UnitIdId: String? = null

    @SerializedName("Activity6BaseQty")
    val activity6BaseQty: Int? = null

    @SerializedName("Activity6FormulaId_Id")
    val activity6FormulaIdId: String? = null

    @SerializedName("Activity6Id_Id")
    val activity6IdId: String? = null

    @SerializedName("Activity6Qty")
    val activity6Qty: Int? = null

    @SerializedName("Activity6RepFormulaId_Id")
    val activity6RepFormulaIdId: String? = null

    @SerializedName("Activity6ReportQty")
    val activity6ReportQty: Int? = null

    @SerializedName("Activity6UnitId_Id")
    val activity6UnitIdId: String? = null

    @SerializedName("AdviceSplitQty")
    val adviceSplitQty: Int? = null

    @SerializedName("BarCode")
    val barCode: String? = null

    @SerializedName("BaseBatch")
    val baseBatch: Int? = null

    @SerializedName("BaseCheckDiffQty")
    val baseCheckDiffQty: Int? = null

    @SerializedName("BaseExcessCtrlQty")
    val baseExcessCtrlQty: Int? = null

    @SerializedName("BaseResStockQty")
    val baseResStockQty: Int? = null

    @SerializedName("BaseWastageQty")
    val baseWastageQty: Int? = null

    @SerializedName("BetweenFinishTime")
    val betweenFinishTime: String? = null

    @SerializedName("BetweenStartTime")
    val betweenStartTime: String? = null

    @SerializedName("BetweenUnit")
    val betweenUnit: String? = null

    @SerializedName("BetweenWorkTime")
    val betweenWorkTime: Int? = null

    @SerializedName("ConvertType")
    val convertType: String? = null

    @SerializedName("ConveyDate")
    val conveyDate: String? = null

    @SerializedName("DefectReworkMode")
    val defectReworkMode: String? = null

    @SerializedName("DepartmentId")
    val departmentId: DepartmentId? = null

    @SerializedName("DepartmentId_Id")
    val departmentIdId: String? = null

    @SerializedName("EmpId")
    val empId: List<Any>? = null

    @SerializedName("EnableLocationNo")
    val enableLocationNo: Boolean? = null

    @SerializedName("EquipmentId_Id")
    val equipmentIdId: String? = null

    @SerializedName("FinishLowerLimit")
    val finishLowerLimit: Int? = null

    @SerializedName("FirstInspectControl")
    val firstInspectControl: String? = null

    @SerializedName("IPQCOperNumber")
    val iPQCOperNumber: Int? = null

    @SerializedName("Id")
    val Id: String? = null

    @SerializedName("InspectCheckSchemaEntryId_Id")
    val inspectCheckSchemaEntryIdId: String? = null

    @SerializedName("InspectStatus")
    val inspectStatus: String? = null

    @SerializedName("IsCheckProcessInspect")
    val isCheckProcessInspect: Boolean? = null

    @SerializedName("IsCheckProcessRecord")
    val isCheckProcessRecord: Boolean? = null

    @SerializedName("IsDiscreteOperDispDetail")
    val isDiscreteOperDispDetail: Boolean? = null

    @SerializedName("IsFirstOper")
    val isFirstOper: Boolean? = null

    @SerializedName("IsFirstOperPhase")
    val isFirstOperPhase: Boolean? = null

    @SerializedName("IsFirstPieceInspect")
    val isFirstPieceInspect: Boolean? = null

    @SerializedName("IsIteration")
    val isIteration: Boolean? = null

    @SerializedName("IsLinkageSchedule")
    val isLinkageSchedule: Boolean? = null

    @SerializedName("IsManualFinished")
    val isManualFinished: Boolean? = null

    @SerializedName("IsManualReport")
    val isManualReport: Boolean? = null

    @SerializedName("IsOutSrc")
    val isOutSrc: Boolean? = null

    @SerializedName("IsProcessRecordStation")
    val isProcessRecordStation: Boolean? = null

    @SerializedName("IsQualityInspectStation")
    val isQualityInspectStation: Boolean? = null

    @SerializedName("IsRptCheckProcessInspect")
    val isRptCheckProcessInspect: Boolean? = null

    @SerializedName("IsRptCheckProcessRecord")
    val isRptCheckProcessRecord: Boolean? = null

    @SerializedName("IsSameTime")
    val isSameTime: Boolean? = null

    @SerializedName("IsSplitSchedule")
    val isSplitSchedule: Boolean? = null

    @SerializedName("IsStoreInPoint")
    val isStoreInPoint: Boolean? = null

    @SerializedName("IsWorkTime")
    val isWorkTime: Boolean? = null

    @SerializedName("IterationMinBatch")
    val iterationMinBatch: Int? = null

    @SerializedName("IterationMinTime")
    val iterationMinTime: Int? = null

    @SerializedName("IterationMinTimeUnit")
    val iterationMinTimeUnit: String? = null

    @SerializedName("KeyOper")
    val keyOper: String? = null

    @SerializedName("LeadTime")
    val leadTime: Int? = null

    @SerializedName("LockEquipment")
    val lockEquipment: Boolean? = null

    @SerializedName("MOBaseUnitId")
    val mOBaseUnitId: MOBaseUnitId? = null

    @SerializedName("MOBaseUnitId_Id")
    val mOBaseUnitIdId: String? = null

    @SerializedName("ManualAddNew")
    val manualAddNew: Boolean? = null

    @SerializedName("MatScrapBaseQty")
    val matScrapBaseQty: Int? = null

    @SerializedName("MatScrapHeadQty")
    val matScrapHeadQty: Int? = null

    @SerializedName("MatScrapPrice")
    val matScrapPrice: Int? = null

    @SerializedName("MatScrapQty")
    var matScrapQty: Int? = null

    @SerializedName("MatScrapTaxPrice")
    val matScrapTaxPrice: Int? = null

    @SerializedName("MinMoveTime")
    val minMoveTime: Int? = null

    @SerializedName("MinMoveTimeUnit")
    val minMoveTimeUnit: String? = null

    @SerializedName("MinQueueTime")
    val minQueueTime: Int? = null

    @SerializedName("MinQueueTimeUnit")
    val minQueueTimeUnit: String? = null

    @SerializedName("MinWaitTime")
    val minWaitTime: Int? = null

    @SerializedName("MinWaitTimeUnit")
    val minWaitTimeUnit: String? = null

    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null

    @SerializedName("OffsetTime")
    val offsetTime: Int? = null

    @SerializedName("OperAlterEntrySeq")
    val operAlterEntrySeq: Int? = null

    @SerializedName("OperAlterNumber")
    val operAlterNumber: String? = null

    @SerializedName("OperCancel")
    val operCancel: String? = null

    @SerializedName("OperCheckDiffQty")
    val operCheckDiffQty: Int? = null

    @SerializedName("OperDescription")
    val operDescription: List<OperDescription>? = null

    @SerializedName("OperExcessCtrlQty")
    val operExcessCtrlQty: Int? = null

    @SerializedName("OperFirstFinishTime")
    val operFirstFinishTime: String? = null

    @SerializedName("OperFirstStartTime")
    val operFirstStartTime: String? = null

    @SerializedName("OperHeadBaseQty")
    val operHeadBaseQty: Int? = null

    @SerializedName("OperHeadQty")
    val operHeadQty: Int? = null

    @SerializedName("OperLastFinishTime")
    val operLastFinishTime: String? = null

    @SerializedName("OperLastStartTime")
    val operLastStartTime: String? = null

    @SerializedName("OperMOUnitId")
    val operMOUnitId: OperMOUnitId? = null

    @SerializedName("OperMOUnitId_Id")
    val operMOUnitIdId: String? = null

    @SerializedName("OperNumber")
    val operNumber: String? = null

    @SerializedName("OperPhase")
    val operPhase: Int? = null

    @SerializedName("OperPickStauts")
    val operPickStauts: String? = null

    @SerializedName("OperPlanFinishTime")
    val operPlanFinishTime: String? = null

    @SerializedName("OperPlanStartTime")
    val operPlanStartTime: String? = null

    @SerializedName("OperQty")
    val operQty: Int? = null

    @SerializedName("OperResStockQty")
    val operResStockQty: Int? = null

    @SerializedName("OperSrcDetailId")
    val operSrcDetailId: String? = null

    @SerializedName("OperSrcType")
    val operSrcType: String? = null

    @SerializedName("OperStatus")
    val operStatus: String? = null

    @SerializedName("OperUnitId")
    val operUnitId: OperUnitId? = null

    @SerializedName("OperUnitId_Id")
    val operUnitIdId: String? = null

    @SerializedName("OptCtrlCodeId")
    val optCtrlCodeId: OptCtrlCodeId? = null

    @SerializedName("OptCtrlCodeId_Id")
    val optCtrlCodeIdId: String? = null

    @SerializedName("OutSrcCurrency_Id")
    val outSrcCurrencyId: String? = null

    @SerializedName("OutSrcLeadTime")
    val outSrcLeadTime: Int? = null

    @SerializedName("OutSrcPrice")
    val outSrcPrice: Int? = null

    @SerializedName("OutSrcTaxPrice")
    val outSrcTaxPrice: Int? = null

    @SerializedName("PatrolStatus")
    val patrolStatus: String? = null

    @SerializedName("PickingQty")
    val pickingQty: Int? = null

    @SerializedName("PrdCheckDiffQty")
    val prdCheckDiffQty: Int? = null

    @SerializedName("PrdExcessCtrlQty")
    val prdExcessCtrlQty: Int? = null

    @SerializedName("PrdResStockQty")
    val prdResStockQty: Int? = null

    @SerializedName("PrdWastageQty")
    val prdWastageQty: Int? = null

    @SerializedName("PrepareFinishTime")
    var prepareFinishTime: String? = null

    @SerializedName("PrepareStartTime")
    var prepareStartTime: String? = null

    @SerializedName("PrepareUnit")
    val prepareUnit: String? = null

    @SerializedName("PrepareWorkTime")
    val prepareWorkTime: Int? = null

    @SerializedName("PriceList_Id")
    val priceListId: String? = null

    @SerializedName("ProcessCheckSchemaEntryId_Id")
    val processCheckSchemaEntryIdId: String? = null

    @SerializedName("ProcessFinishTime")
    var processFinishTime: String? = null

    @SerializedName("ProcessId")
    val processId: ProcessId? = null

    @SerializedName("ProcessId_Id")
    val processIdId: String? = null

    @SerializedName("ProcessOrgId")
    val processOrgId: ProcessOrgId? = null

    @SerializedName("ProcessOrgId_Id")
    val processOrgIdId: String? = null

    @SerializedName("ProcessRemainWorkTime")
    val processRemainWorkTime: Int? = null

    @SerializedName("ProcessStartTime")
    var processStartTime: String? = null

    @SerializedName("ProcessUnit")
    val processUnit: String? = null

    @SerializedName("ProcessWorkTime")
    val processWorkTime: Int? = null

    @SerializedName("PurchaseGroupId_Id")
    val purchaseGroupIdId: String? = null

    @SerializedName("PurchaseOrgId")
    val purchaseOrgId: PurchaseOrgId? = null

    @SerializedName("PurchaseOrgId_Id")
    val purchaseOrgIdId: String? = null

    @SerializedName("QCSchemeId_Id")
    val qCSchemeIdId: String? = null

    @SerializedName("QualifiedBaseQty")
    val qualifiedBaseQty: Int? = null

    @SerializedName("QualifiedHeadQty")
    val qualifiedHeadQty: Int? = null

    @SerializedName("QualifiedQty")
    var qualifiedQty: Int? = null

    @SerializedName("RateOperQty")
    val rateOperQty: Int? = null

    @SerializedName("RateProQty")
    val rateProQty: Int? = null

    @SerializedName("RateValQty")
    val rateValQty: Int? = null

    @SerializedName("ReFinishBaseQty")
    val reFinishBaseQty: Int? = null

    @SerializedName("ReFinishHeadQty")
    val reFinishHeadQty: Int? = null

    @SerializedName("ReFinishQty")
    var reFinishQty: Int? = null

    @SerializedName("ReSelBaseQty")
    val reSelBaseQty: Int? = null

    @SerializedName("ReSelHeadQty")
    val reSelHeadQty: Int? = null

    @SerializedName("ReSelQty")
    val reSelQty: Int? = null

    @SerializedName("ReTransOutBaseQty")
    val reTransOutBaseQty: Int? = null

    @SerializedName("ReTransOutHeadQty")
    val reTransOutHeadQty: Int? = null

    @SerializedName("ReTransOutQty")
    val reTransOutQty: Int? = null

    @SerializedName("ReWorkBaseQty")
    val reWorkBaseQty: Int? = null

    @SerializedName("ReWorkHeadQty")
    val reWorkHeadQty: Int? = null

    @SerializedName("ReWorkQty")
    var reWorkQty: Int? = null

    @SerializedName("RealPrepareFinishTime")
    val realPrepareFinishTime: String? = null

    @SerializedName("RealPrepareStartTime")
    val realPrepareStartTime: String? = null

    @SerializedName("RealProcessFinishTime")
    val realProcessFinishTime: String? = null

    @SerializedName("RealProcessStartTime")
    val realProcessStartTime: String? = null

    @SerializedName("RealRemoveFinishTime")
    val realRemoveFinishTime: String? = null

    @SerializedName("RealRemoveStartTime")
    val realRemoveStartTime: String? = null

    @SerializedName("RealSplitQty")
    val realSplitQty: Int? = null

    @SerializedName("RejectionRate")
    val rejectionRate: Int? = null

    @SerializedName("RemoveFinishTime")
    var removeFinishTime: String? = null

    @SerializedName("RemoveRemainWorkTime")
    val removeRemainWorkTime: Int? = null

    @SerializedName("RemoveStartTime")
    var removeStartTime: String? = null

    @SerializedName("RemoveUnit")
    val removeUnit: String? = null

    @SerializedName("RemoveWorkTime")
    val removeWorkTime: Int? = null

    @SerializedName("ReportBaseQty")
    val reportBaseQty: Int? = null

    @SerializedName("ReportHeadQty")
    val reportHeadQty: Int? = null

    @SerializedName("ReportQty")
    val reportQty: Int? = null

    @SerializedName("ResourceId_Id")
    val resourceIdId: String? = null

    @SerializedName("ScanFeatureCode")
    val scanFeatureCode: String? = null

    @SerializedName("ScheduleTime")
    val scheduleTime: String? = null

    @SerializedName("ScrapBaseQty")
    val scrapBaseQty: Int? = null

    @SerializedName("ScrapHeadQty")
    val scrapHeadQty: Int? = null

    @SerializedName("ScrapPrice")
    val scrapPrice: Int? = null

    @SerializedName("ScrapQty")
    var scrapQty: Int? = null

    @SerializedName("ScrapTaxPrice")
    val scrapTaxPrice: Int? = null

    @SerializedName("SelMoType")
    val selMoType: String? = null

    @SerializedName("Seq")
    val seq: Int? = null

    @SerializedName("ShiftGroupId_Id")
    val shiftGroupIdId: String? = null

    @SerializedName("ShiftSliceId_Id")
    val shiftSliceIdId: String? = null

    @SerializedName("SplitMinWorkTime")
    val splitMinWorkTime: Int? = null

    @SerializedName("SplitMinWorkTimeUnit")
    val splitMinWorkTimeUnit: String? = null

    @SerializedName("SrcSubEntityId")
    val srcSubEntityId: String? = null

    @SerializedName("StdMoveTime")
    val stdMoveTime: Int? = null

    @SerializedName("StdMoveTimeUnit")
    val stdMoveTimeUnit: String? = null

    @SerializedName("StdQueueTime")
    val stdQueueTime: Int? = null

    @SerializedName("StdQueueTimeUnit")
    val stdQueueTimeUnit: String? = null

    @SerializedName("StdWaitTime")
    val stdWaitTime: Int? = null

    @SerializedName("StdWaitTimeUnit")
    val stdWaitTimeUnit: String? = null

    @SerializedName("Supplier_Id")
    val supplierId: String? = null

    @SerializedName("TaxRate")
    val taxRate: Int? = null

    @SerializedName("TransInBaseQty")
    val transInBaseQty: Int? = null

    @SerializedName("TransInHeadQty")
    val transInHeadQty: Int? = null

    @SerializedName("TransInQty")
    val transInQty: Int? = null

    @SerializedName("TransOutBaseQty")
    val transOutBaseQty: Int? = null

    @SerializedName("TransOutHeadQty")
    val transOutHeadQty: Int? = null

    @SerializedName("TransOutQty")
    val transOutQty: Int? = null

    @SerializedName("TransSelBaseQty")
    val transSelBaseQty: Int? = null

    @SerializedName("TransSelHeadQty")
    val transSelHeadQty: Int? = null

    @SerializedName("TransSelQty")
    val transSelQty: Int? = null

    @SerializedName("UnitTransHeadQty")
    val unitTransHeadQty: Int? = null

    @SerializedName("UnitTransOperQty")
    val unitTransOperQty: Int? = null

    @SerializedName("UnqualifiedBaseQty")
    val unqualifiedBaseQty: Int? = null

    @SerializedName("UnqualifiedHeadQty")
    val unqualifiedHeadQty: Int? = null

    @SerializedName("UnqualifiedQty")
    var unqualifiedQty: Int? = null

    @SerializedName("ValuationQty")
    val valuationQty: Int? = null

    @SerializedName("ValuationUnitId_Id")
    val valuationUnitIdId: String? = null

    @SerializedName("WIPQty")
    val wIPQty: Int? = null

    @SerializedName("WastageQty")
    var wastageQty: Int? = null

    @SerializedName("WorkCenterId")
    val workCenterId: WorkCenterId? = null

    @SerializedName("WorkCenterId_Id")
    val workCenterIdId: String? = null

    @SerializedName("WorkTimeColect")
    val workTimeColect: String? = null
}

data class DeptID(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("msterID")
    val msterId: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)


data class UseOrgId(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)

data class WorkCenterCapacity(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("JoinScheduling")
    val joinScheduling: Boolean? = false,
    @SerializedName("RESOURCEID")
    val rESOURCEID: RESOURCEID? = null,
    @SerializedName("RESOURCEID_Id")
    val rESOURCEIDId: String? = null,
    @SerializedName("Seq")
    val seq: Int? = 0
)

data class WorkCenterScheduling(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("MinCarryTime")
    val minCarryTime: Int? = 0,
    @SerializedName("MinCarryTimeUnit")
    val minCarryTimeUnit: String? = "",
    @SerializedName("MinQueueTime")
    val minQueueTime: Int? = 0,
    @SerializedName("MinQueueTimeUnit")
    val minQueueTimeUnit: String? = "",
    @SerializedName("MinWaitTime")
    val minWaitTime: Int? = 0,
    @SerializedName("MinWaitTimeUnit")
    val minWaitTimeUnit: String? = "",
    @SerializedName("ProcessTimeFormula")
    val processTimeFormula: ProcessTimeFormula? = null,
    @SerializedName("ProcessTimeFormula_Id")
    val processTimeFormulaId: String? = null,
    @SerializedName("Seq")
    val seq: Int? = 0,
    @SerializedName("SetTimeFormula")
    val setTimeFormula: SetTimeFormula? = null,
    @SerializedName("SetTimeFormula_Id")
    val setTimeFormulaId: String? = null,
    @SerializedName("StdCarryTime")
    val stdCarryTime: Int? = 0,
    @SerializedName("StdCarryTimeUnit")
    val stdCarryTimeUnit: String? = "",
    @SerializedName("StdQueueTime")
    val stdQueueTime: Int? = 0,
    @SerializedName("StdQueueTimeUnit")
    val stdQueueTimeUnit: String? = "",
    @SerializedName("StdWaitTime")
    val stdWaitTime: Int? = 0,
    @SerializedName("StdWaitTimeUnit")
    val stdWaitTimeUnit: String? = "",
    @SerializedName("TearDownTimeFormula")
    val tearDownTimeFormula: TearDownTimeFormula? = null,
    @SerializedName("TearDownTimeFormula_Id")
    val tearDownTimeFormulaId: String? = null
)

data class RESOURCEID(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("msterID")
    val msterId: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)

data class ProcessTimeFormula(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("msterID")
    val msterId: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)

data class SetTimeFormula(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("msterID")
    val msterId: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)

data class TearDownTimeFormula(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("msterID")
    val msterId: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)

data class ActivityFormulaId(
    @SerializedName("FormulaUse")
    val formulaUse: String? = "",
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("msterID")
    val msterId: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)

data class ActivityId(
    @SerializedName("DefaultValue")
    val defaultValue: Int? = 0,
    @SerializedName("FUnitID")
    val fUnitID: FUnitID? = null,
    @SerializedName("FUnitID_Id")
    val fUnitIDId: String? = null,
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("msterID")
    val msterId: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = "",
    @SerializedName("Phase")
    val phase: String? = ""
)

data class ActivityRepFormulaId(
    @SerializedName("FormulaUse")
    val formulaUse: String? = "",
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("msterID")
    val msterId: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)

data class ActivityUnitId(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("msterID")
    val msterId: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = "",
    @SerializedName("Precision")
    val precision: Int? = 0,
    @SerializedName("RoundType")
    val roundType: String? = "",
    @SerializedName("UNITCONVERTRATE")
    val uNITCONVERTRATE: List<UNITCONVERTRATE>? = null
)

data class DepartmentId(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("msterID")
    val msterId: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)

data class MOBaseUnitId(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("msterID")
    val msterId: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = "",
    @SerializedName("Precision")
    val precision: Int? = 0,
    @SerializedName("RoundType")
    val roundType: String? = "",
    @SerializedName("UNITCONVERTRATE")
    val uNITCONVERTRATE: List<UNITCONVERTRATE>? = null
)


data class OperDescription(
    @SerializedName("Key")
    val key: Int? = null,
    @SerializedName("Value")
    val value: String? = null
)

data class OperMOUnitId(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("msterID")
    val msterId: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = "",
    @SerializedName("Precision")
    val precision: Int? = 0,
    @SerializedName("RoundType")
    val roundType: String? = "",
    @SerializedName("UNITCONVERTRATE")
    val uNITCONVERTRATE: List<UNITCONVERTRATE>? = null
)

data class OperUnitId(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("msterID")
    val msterId: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = "",
    @SerializedName("Precision")
    val precision: Int? = 0,
    @SerializedName("RoundType")
    val roundType: String? = "",
    @SerializedName("UNITCONVERTRATE")
    val uNITCONVERTRATE: List<UNITCONVERTRATE>? = null
)


data class OptCtrlCodeId(
    @SerializedName("CheckType")
    val checkType: String? = "",
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("IsScheduling")
    val isScheduling: Boolean? = false,
    @SerializedName("msterID")
    val msterId: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = "",
    @SerializedName("OptTimeUnit")
    val optTimeUnit: String? = "",
    @SerializedName("ProcessingMode")
    val processingMode: String? = "",
    @SerializedName("ReportMode")
    val reportMode: String? = "",
    @SerializedName("ReportSequenceControl")
    val reportSequenceControl: String? = "",
    @SerializedName("ReworkType")
    val reworkType: String? = ""
)

data class ProcessId(
    @SerializedName("DataAcOrder")
    val dataAcOrder: String? = "",
    @SerializedName("Description")
    val description: List<Description>? = null,
    @SerializedName("EffectDate")
    val effectDate: String? = "",
    @SerializedName("ExpireDate")
    val expireDate: String? = "",
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("msterID")
    val msterId: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)

data class ProcessOrgId(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)

data class PurchaseOrgId(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)

data class WorkCenterId(
    @SerializedName("DeptID")
    val deptID: DeptID? = null,
    @SerializedName("DeptID_Id")
    val deptIDId: String? = null,
    @SerializedName("EffectDate")
    val effectDate: String? = "",
    @SerializedName("ExpireDate")
    val expireDate: String? = "",
    @SerializedName("FFormId")
    val fFormId: String? = "",
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("IsDiscreteOperDispDetail")
    val isDiscreteOperDispDetail: Boolean? = false,
    @SerializedName("msterID")
    val msterId: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = "",
    @SerializedName("OptCtrlCodeID")
    val optCtrlCodeID: OptCtrlCodeId? = null,
    @SerializedName("OptCtrlCodeID_Id")
    val optCtrlCodeIDId: String? = null,
    @SerializedName("ProcessID_Id")
    val processIDId: String? = null,
    @SerializedName("UseOrgId")
    val useOrgId: UseOrgId? = null,
    @SerializedName("UseOrgId_Id")
    val useOrgIdId: String? = null,
    @SerializedName("WorkCenterCapacity")
    val workCenterCapacity: List<WorkCenterCapacity>? = null,
    @SerializedName("WorkCenterScheduling")
    val workCenterScheduling: List<WorkCenterScheduling>? = null
)

data class FUnitID(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("msterID")
    val msterId: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)


data class Description(
    @SerializedName("Key")
    val key: Int? = null,
    @SerializedName("Value")
    val value: String? = null
)


data class MaterialAuxPty(
    @SerializedName("AuxPropertyId")
    val auxPropertyId: AuxPropertyId? = null,
    @SerializedName("AuxPropertyId_Id")
    val auxPropertyIdId: String? = null,
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("IsAffectPrice")
    val isAffectPrice: Boolean? = false,
    @SerializedName("IsComControl")
    val isComControl: Boolean? = false,
    @SerializedName("IsEnable1")
    val isEnable1: Boolean? = false
)

data class MaterialBase(
    @SerializedName("BaseUnitId")
    val baseUnitId: BaseUnitId? = null,
    @SerializedName("BaseUnitId_Id")
    val baseUnitIdId: String? = null,
    @SerializedName("Id")
    val Id: String? = null
)

data class MaterialStock(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("IsExpParToFlot")
    val isExpParToFlot: Boolean? = false,
    @SerializedName("StoreUnitID")
    val storeUnitID: StoreUnitID? = null,
    @SerializedName("StoreUnitID_Id")
    val storeUnitIDId: String? = null
)

data class MultiLanguageText(
    @SerializedName("LocaleId")
    val localeId: String? = null,
    @SerializedName("Name")
    val name: String? = null,
    @SerializedName("PkId")
    val pkId: String? = null,
    @SerializedName("Specification")
    val specification: String? = null,
    @SerializedName("Description")
    val description: String? = null,
)

data class Specification(
    @SerializedName("Key")
    val key: Int? = null,
    @SerializedName("Value")
    val value: String? = null
)


data class AuxPropertyId(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("msterID")
    val msterId: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)


data class StoreUnitID(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("msterID")
    val msterId: String? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)

data class RouteOperSeq(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("RouteOperDetail")
    val routeOperDetail: List<RouteOperDetail?>? = null,
    @SerializedName("Seq")
    val seq: Int? = null,
    @SerializedName("SeqNumber")
    val seqNumber: String? = null
)

data class RouteOperDetail(
    @SerializedName("Id")
    val Id: String? = null,
    @SerializedName("OperNumber")
    val operNumber: String? = null,
    @SerializedName("ReportCeilRatio")
    val reportCeilRatio: Int? = null,
    @SerializedName("ReportFloorRatio")
    val reportFloorRatio: Int? = null,
    @SerializedName("Seq")
    val seq: Int? = null
)