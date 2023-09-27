package com.ct.erp.dto

import androidx.databinding.BaseObservable
import com.google.gson.annotations.SerializedName


data class DispatchPlanApiData(
    @SerializedName("ApproveDate")
    val approveDate: String? = "",
    @SerializedName("ApproverId")
    val approverId: ApproverId? = null,
    @SerializedName("ApproverId_Id")
    val approverIdId: Int? = 0,
    @SerializedName("AutoInStore")
    val autoInStore: String? = "",
    @SerializedName("AuxPropId_Id")
    val auxPropIdId: Int? = 0,
    @SerializedName("BFLowId_Id")
    val bFLowIdId: String? = "",
    @SerializedName("BaseQty")
    val baseQty: Int? = 0,
    @SerializedName("BaseUnitId")
    val baseUnitId: BaseUnitId? = null,
    @SerializedName("BaseUnitId_Id")
    val baseUnitIdId: Int? = 0,
    @SerializedName("BillNo")
    val billNo: String? = "",
    @SerializedName("BillType")
    val billType: BillType? = null,
    @SerializedName("BillType_Id")
    val billTypeId: String? = "",
    @SerializedName("BomId")
    val bomId: BomId? = null,
    @SerializedName("BomId_Id")
    val bomIdId: Int? = 0,
    @SerializedName("CANCELER_Id")
    val cANCELERId: Int? = 0,
    @SerializedName("CancelStatus")
    val cancelStatus: String? = "",
    @SerializedName("CreateDate")
    val createDate: String? = "",
    @SerializedName("CreatorId")
    val creatorId: CreatorId? = null,
    @SerializedName("CreatorId_Id")
    val creatorIdId: Int? = 0,
    @SerializedName("DecuctionTime")
    val decuctionTime: String? = "",
    @SerializedName("DemandBillEntryId")
    val demandBillEntryId: Int? = 0,
    @SerializedName("DemandBillId")
    val demandBillId: Int? = 0,
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
    val id: Int? = 0,
    @SerializedName("InspectCheckSchemaId_Id")
    val inspectCheckSchemaIdId: Int? = 0,
    @SerializedName("IsEntrust")
    val isEntrust: Boolean? = false,
    @SerializedName("IsWastageInStock")
    val isWastageInStock: Boolean? = false,
    @SerializedName("Lot_Id")
    val lotId: Int? = 0,
    @SerializedName("Lot_Text")
    val lotText: String? = "",
    @SerializedName("MOEntryId")
    val mOEntryId: Int? = 0,
    @SerializedName("MOEntrySeq")
    val mOEntrySeq: Int? = 0,
    @SerializedName("MOId")
    val mOId: Int? = 0,
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
    val mOUnitIdId: Int? = 0,
    @SerializedName("MTONo")
    val mTONo: String? = "",
    @SerializedName("ModifierId")
    val modifierId: ModifierId? = null,
    @SerializedName("ModifierId_Id")
    val modifierIdId: Int? = 0,
    @SerializedName("ModifyDate")
    val modifyDate: String? = "",
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<Any>? = null,
    @SerializedName("OutSrcWay")
    val outSrcWay: String? = "",
    @SerializedName("OwnerId")
    val ownerId: OwnerId? = null,
    @SerializedName("OwnerId_Id")
    val ownerIdId: Int? = 0,
    @SerializedName("OwnerTypeId")
    val ownerTypeId: String? = "",
    @SerializedName("ParentId")
    val parentId: Int? = 0,
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
    val proDepartmentIdId: Int? = 0,
    @SerializedName("ProOrgId")
    val proOrgId: ProOrgId? = null,
    @SerializedName("ProOrgId_Id")
    val proOrgIdId: Int? = 0,
    @SerializedName("ProcessCheckSchemaId_Id")
    val processCheckSchemaIdId: Int? = 0,
    @SerializedName("ProduceType")
    val produceType: String? = "",
    @SerializedName("ProductId")
    val productId: ProductId? = null,
    @SerializedName("ProductId_Id")
    val productIdId: Int? = 0,
    @SerializedName("ProductLine_Id")
    val productLineId: Int? = 0,
    @SerializedName("ProductType")
    val productType: String? = "",
    @SerializedName("ProjectNo")
    val projectNo: String? = "",
    @SerializedName("RootBillId")
    val rootBillId: Int? = 0,
    @SerializedName("RouteId")
    val routeId: RouteId? = null,
    @SerializedName("RouteId_Id")
    val routeIdId: Int? = 0,
    @SerializedName("SaleOrderEntrySeq")
    val saleOrderEntrySeq: Int? = 0,
    @SerializedName("SaleOrderNumber")
    val saleOrderNumber: String? = "",
    @SerializedName("ScheduleModelId")
    val scheduleModelId: ScheduleModelId? = null,
    @SerializedName("ScheduleModelId_Id")
    val scheduleModelIdId: Int? = 0,
    @SerializedName("ScheduleSeq")
    val scheduleSeq: Int? = 0,
    @SerializedName("SourceBillNo")
    val sourceBillNo: String? = "",
    @SerializedName("SourceBillType")
    val sourceBillType: String? = "",
    @SerializedName("StockInOrgId")
    val stockInOrgId: StockInOrgId? = null,
    @SerializedName("StockInOrgId_Id")
    val stockInOrgIdId: Int? = 0
) : BaseObservable() {


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
    val id: Int? = null,
    @SerializedName("Name")
    val name: String? = null,
    @SerializedName("UserAccount")
    val userAccount: String? = null
)

data class BaseUnitId(
    @SerializedName("Id")
    val id: Int? = null,
    @SerializedName("msterID")
    val msterID: Int? = null,
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
    val id: Int? = null,
    @SerializedName("msterID")
    val msterID: Int? = null,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<Any?>? = null,
    @SerializedName("Name")
    val name: List<Any?>? = null,
    @SerializedName("Number")
    val number: String? = null
)

data class CreatorId(
    @SerializedName("Id")
    val id: Int? = null,
    @SerializedName("Name")
    val name: String? = null,
    @SerializedName("UserAccount")
    val userAccount: String? = null
)

data class Entity(
    @SerializedName("Id")
    val id: Int? = 0,
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
    val seqSrcEntryId: Int? = 0,
    @SerializedName("SeqSrcType")
    val seqSrcType: String? = "",
    @SerializedName("SeqType")
    val seqType: String? = "",
    @SerializedName("SeqWorkCenterId")
    val seqWorkCenterId: SeqWorkCenterId? = null,
    @SerializedName("SeqWorkCenterId_Id")
    val seqWorkCenterIdId: Int? = 0,
    @SerializedName("SplitFromOper")
    val splitFromOper: Int? = 0,
    @SerializedName("SplitQty")
    val splitQty: Int? = 0,
    @SerializedName("SplitToOper")
    val splitToOper: Int? = 0,
    @SerializedName("SrcEntityId")
    val srcEntityId: Int? = 0,
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
    val flowLineId: Int? = null,
    @SerializedName("Id")
    val id: Int? = null,
    @SerializedName("RuleId")
    val ruleId: String? = null,
    @SerializedName("SBillId")
    val sBillId: String? = null,
    @SerializedName("SId")
    val sId: String? = null,
    @SerializedName("STableId")
    val sTableId: Int? = null,
    @SerializedName("STableName")
    val sTableName: String? = null
)

data class MOUnitId(
    @SerializedName("Id")
    val id: Int? = 0,
    @SerializedName("msterID")
    val msterID: Int? = 0,
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
    val id: Int? = null,
    @SerializedName("Name")
    val name: String? = null,
    @SerializedName("UserAccount")
    val userAccount: String? = null
)

data class OwnerId(
    @SerializedName("Id")
    val id: Int? = 0,
    @SerializedName("msterID")
    val msterID: Int? = 0,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)

data class ProDepartmentId(
    @SerializedName("Id")
    val id: Int? = 0,
    @SerializedName("msterID")
    val msterID: Int? = 0,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)

data class ProOrgId(
    @SerializedName("Id")
    val id: Int? = 0,
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
    val id: Int? = 0,
    @SerializedName("MaterialAuxPty")
    val materialAuxPty: List<MaterialAuxPty>? = null,
    @SerializedName("MaterialBase")
    val materialBase: List<MaterialBase>? = null,
    @SerializedName("MaterialStock")
    val materialStock: List<MaterialStock>? = null,
    @SerializedName("msterID")
    val msterID: Int? = 0,
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
    val useOrgIdId: Int? = 0
)

data class RouteId(
    @SerializedName("FFormId")
    val fFormId: String? = "",
    @SerializedName("Id")
    val id: Int? = 0,
    @SerializedName("IsWastageInStock")
    val isWastageInStock: Boolean? = false,
    @SerializedName("msterID")
    val msterID: Int? = 0,
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
    val id: Int? = 0,
    @SerializedName("msterID")
    val msterID: Int? = 0,
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
    val id: Int? = 0,
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
    val id: Int? = null
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
    val deptIDId: Int? = 0,
    @SerializedName("EffectDate")
    val effectDate: String? = "",
    @SerializedName("ExpireDate")
    val expireDate: String? = "",
    @SerializedName("FFormId")
    val fFormId: String? = "",
    @SerializedName("Id")
    val id: Int? = 0,
    @SerializedName("IsDiscreteOperDispDetail")
    val isDiscreteOperDispDetail: Boolean? = false,
    @SerializedName("msterID")
    val msterID: Int? = 0,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = "",
    @SerializedName("OptCtrlCodeID")
    val optCtrlCodeID: OptCtrlCodeId? = null,
    @SerializedName("OptCtrlCodeID_Id")
    val optCtrlCodeIDId: Int? = 0,
    @SerializedName("ProcessID_Id")
    val processIDId: Int? = 0,
    @SerializedName("UseOrgId")
    val useOrgId: UseOrgId? = null,
    @SerializedName("UseOrgId_Id")
    val useOrgIdId: Int? = 0,
    @SerializedName("WorkCenterCapacity")
    val workCenterCapacity: List<WorkCenterCapacity>? = null,
    @SerializedName("WorkCenterScheduling")
    val workCenterScheduling: List<WorkCenterScheduling>? = null
)

data class SubEntity(
    @SerializedName("Activity1BaseQty")
    val activity1BaseQty: Int? = 0,
    @SerializedName("Activity1FormulaId")
    val activity1FormulaId: ActivityFormulaId? = null,
    @SerializedName("Activity1FormulaId_Id")
    val activity1FormulaIdId: Int? = 0,
    @SerializedName("Activity1Id")
    val activity1Id: ActivityId? = null,
    @SerializedName("Activity1Id_Id")
    val activity1IdId: Int? = 0,
    @SerializedName("Activity1Qty")
    val activity1Qty: Int? = 0,
    @SerializedName("Activity1RepFormulaId")
    val activity1RepFormulaId: ActivityRepFormulaId? = null,
    @SerializedName("Activity1RepFormulaId_Id")
    val activity1RepFormulaIdId: Int? = 0,
    @SerializedName("Activity1ReportQty")
    val activity1ReportQty: Int? = 0,
    @SerializedName("Activity1UnitId")
    val activity1UnitId: ActivityUnitId? = null,
    @SerializedName("Activity1UnitId_Id")
    val activity1UnitIdId: Int? = 0,
    @SerializedName("Activity2BaseQty")
    val activity2BaseQty: Int? = 0,
    @SerializedName("Activity2FormulaId")
    val activity2FormulaId: ActivityFormulaId? = null,
    @SerializedName("Activity2FormulaId_Id")
    val activity2FormulaIdId: Int? = 0,
    @SerializedName("Activity2Id")
    val activity2Id: ActivityId? = null,
    @SerializedName("Activity2Id_Id")
    val activity2IdId: Int? = 0,
    @SerializedName("Activity2Qty")
    val activity2Qty: Int? = 0,
    @SerializedName("Activity2RepFormulaId")
    val activity2RepFormulaId: ActivityRepFormulaId? = null,
    @SerializedName("Activity2RepFormulaId_Id")
    val activity2RepFormulaIdId: Int? = 0,
    @SerializedName("Activity2ReportQty")
    val activity2ReportQty: Int? = 0,
    @SerializedName("Activity2UnitId")
    val activity2UnitId: ActivityUnitId? = null,
    @SerializedName("Activity2UnitId_Id")
    val activity2UnitIdId: Int? = 0,
    @SerializedName("Activity3BaseQty")
    val activity3BaseQty: Int? = 0,
    @SerializedName("Activity3FormulaId")
    val activity3FormulaId: ActivityFormulaId? = null,
    @SerializedName("Activity3FormulaId_Id")
    val activity3FormulaIdId: Int? = 0,
    @SerializedName("Activity3Id")
    val activity3Id: ActivityId? = null,
    @SerializedName("Activity3Id_Id")
    val activity3IdId: Int? = 0,
    @SerializedName("Activity3Qty")
    val activity3Qty: Int? = 0,
    @SerializedName("Activity3RepFormulaId")
    val activity3RepFormulaId: ActivityRepFormulaId? = null,
    @SerializedName("Activity3RepFormulaId_Id")
    val activity3RepFormulaIdId: Int? = 0,
    @SerializedName("Activity3ReportQty")
    val activity3ReportQty: Int? = 0,
    @SerializedName("Activity3UnitId")
    val activity3UnitId: ActivityUnitId? = null,
    @SerializedName("Activity3UnitId_Id")
    val activity3UnitIdId: Int? = 0,
    @SerializedName("Activity4BaseQty")
    val activity4BaseQty: Int? = 0,
    @SerializedName("Activity4FormulaId_Id")
    val activity4FormulaIdId: Int? = 0,
    @SerializedName("Activity4Id_Id")
    val activity4IdId: Int? = 0,
    @SerializedName("Activity4Qty")
    val activity4Qty: Int? = 0,
    @SerializedName("Activity4RepFormulaId_Id")
    val activity4RepFormulaIdId: Int? = 0,
    @SerializedName("Activity4ReportQty")
    val activity4ReportQty: Int? = 0,
    @SerializedName("Activity4UnitId_Id")
    val activity4UnitIdId: Int? = 0,
    @SerializedName("Activity5BaseQty")
    val activity5BaseQty: Int? = 0,
    @SerializedName("Activity5FormulaId_Id")
    val activity5FormulaIdId: Int? = 0,
    @SerializedName("Activity5Id_Id")
    val activity5IdId: Int? = 0,
    @SerializedName("Activity5Qty")
    val activity5Qty: Int? = 0,
    @SerializedName("Activity5RepFormulaId_Id")
    val activity5RepFormulaIdId: Int? = 0,
    @SerializedName("Activity5ReportQty")
    val activity5ReportQty: Int? = 0,
    @SerializedName("Activity5UnitId_Id")
    val activity5UnitIdId: Int? = 0,
    @SerializedName("Activity6BaseQty")
    val activity6BaseQty: Int? = 0,
    @SerializedName("Activity6FormulaId_Id")
    val activity6FormulaIdId: Int? = 0,
    @SerializedName("Activity6Id_Id")
    val activity6IdId: Int? = 0,
    @SerializedName("Activity6Qty")
    val activity6Qty: Int? = 0,
    @SerializedName("Activity6RepFormulaId_Id")
    val activity6RepFormulaIdId: Int? = 0,
    @SerializedName("Activity6ReportQty")
    val activity6ReportQty: Int? = 0,
    @SerializedName("Activity6UnitId_Id")
    val activity6UnitIdId: Int? = 0,
    @SerializedName("AdviceSplitQty")
    val adviceSplitQty: Int? = 0,
    @SerializedName("BarCode")
    val barCode: String? = "",
    @SerializedName("BaseBatch")
    val baseBatch: Int? = 0,
    @SerializedName("BaseCheckDiffQty")
    val baseCheckDiffQty: Int? = 0,
    @SerializedName("BaseExcessCtrlQty")
    val baseExcessCtrlQty: Int? = 0,
    @SerializedName("BaseResStockQty")
    val baseResStockQty: Int? = 0,
    @SerializedName("BaseWastageQty")
    val baseWastageQty: Int? = 0,
    @SerializedName("BetweenFinishTime")
    val betweenFinishTime: String? = "",
    @SerializedName("BetweenStartTime")
    val betweenStartTime: String? = "",
    @SerializedName("BetweenUnit")
    val betweenUnit: String? = "",
    @SerializedName("BetweenWorkTime")
    val betweenWorkTime: Int? = 0,
    @SerializedName("ConvertType")
    val convertType: String? = "",
    @SerializedName("ConveyDate")
    val conveyDate: String? = "",
    @SerializedName("DefectReworkMode")
    val defectReworkMode: String? = "",
    @SerializedName("DepartmentId")
    val departmentId: DepartmentId? = null,
    @SerializedName("DepartmentId_Id")
    val departmentIdId: Int? = 0,
    @SerializedName("EmpId")
    val empId: List<Any>? = null,
    @SerializedName("EnableLocationNo")
    val enableLocationNo: Boolean? = false,
    @SerializedName("EquipmentId_Id")
    val equipmentIdId: Int? = 0,
    @SerializedName("FinishLowerLimit")
    val finishLowerLimit: Int? = 0,
    @SerializedName("FirstInspectControl")
    val firstInspectControl: String? = "",
    @SerializedName("IPQCOperNumber")
    val iPQCOperNumber: Int? = 0,
    @SerializedName("Id")
    val id: Int? = 0,
    @SerializedName("InspectCheckSchemaEntryId_Id")
    val inspectCheckSchemaEntryIdId: Int? = 0,
    @SerializedName("InspectStatus")
    val inspectStatus: String? = "",
    @SerializedName("IsCheckProcessInspect")
    val isCheckProcessInspect: Boolean? = false,
    @SerializedName("IsCheckProcessRecord")
    val isCheckProcessRecord: Boolean? = false,
    @SerializedName("IsDiscreteOperDispDetail")
    val isDiscreteOperDispDetail: Boolean? = false,
    @SerializedName("IsFirstOper")
    val isFirstOper: Boolean? = false,
    @SerializedName("IsFirstOperPhase")
    val isFirstOperPhase: Boolean? = false,
    @SerializedName("IsFirstPieceInspect")
    val isFirstPieceInspect: Boolean? = false,
    @SerializedName("IsIteration")
    val isIteration: Boolean? = false,
    @SerializedName("IsLinkageSchedule")
    val isLinkageSchedule: Boolean? = false,
    @SerializedName("IsManualFinished")
    val isManualFinished: Boolean? = false,
    @SerializedName("IsManualReport")
    val isManualReport: Boolean? = false,
    @SerializedName("IsOutSrc")
    val isOutSrc: Boolean? = false,
    @SerializedName("IsProcessRecordStation")
    val isProcessRecordStation: Boolean? = false,
    @SerializedName("IsQualityInspectStation")
    val isQualityInspectStation: Boolean? = false,
    @SerializedName("IsRptCheckProcessInspect")
    val isRptCheckProcessInspect: Boolean? = false,
    @SerializedName("IsRptCheckProcessRecord")
    val isRptCheckProcessRecord: Boolean? = false,
    @SerializedName("IsSameTime")
    val isSameTime: Boolean? = false,
    @SerializedName("IsSplitSchedule")
    val isSplitSchedule: Boolean? = false,
    @SerializedName("IsStoreInPoint")
    val isStoreInPoint: Boolean? = false,
    @SerializedName("IsWorkTime")
    val isWorkTime: Boolean? = false,
    @SerializedName("IterationMinBatch")
    val iterationMinBatch: Int? = 0,
    @SerializedName("IterationMinTime")
    val iterationMinTime: Int? = 0,
    @SerializedName("IterationMinTimeUnit")
    val iterationMinTimeUnit: String? = "",
    @SerializedName("KeyOper")
    val keyOper: String? = "",
    @SerializedName("LeadTime")
    val leadTime: Int? = 0,
    @SerializedName("LockEquipment")
    val lockEquipment: Boolean? = false,
    @SerializedName("MOBaseUnitId")
    val mOBaseUnitId: MOBaseUnitId? = null,
    @SerializedName("MOBaseUnitId_Id")
    val mOBaseUnitIdId: Int? = 0,
    @SerializedName("ManualAddNew")
    val manualAddNew: Boolean? = false,
    @SerializedName("MatScrapBaseQty")
    val matScrapBaseQty: Int? = 0,
    @SerializedName("MatScrapHeadQty")
    val matScrapHeadQty: Int? = 0,
    @SerializedName("MatScrapPrice")
    val matScrapPrice: Int? = 0,
    @SerializedName("MatScrapQty")
    val matScrapQty: Int? = 0,
    @SerializedName("MatScrapTaxPrice")
    val matScrapTaxPrice: Int? = 0,
    @SerializedName("MinMoveTime")
    val minMoveTime: Int? = 0,
    @SerializedName("MinMoveTimeUnit")
    val minMoveTimeUnit: String? = "",
    @SerializedName("MinQueueTime")
    val minQueueTime: Int? = 0,
    @SerializedName("MinQueueTimeUnit")
    val minQueueTimeUnit: String? = "",
    @SerializedName("MinWaitTime")
    val minWaitTime: Int? = 0,
    @SerializedName("MinWaitTimeUnit")
    val minWaitTimeUnit: String? = "",
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("OffsetTime")
    val offsetTime: Int? = 0,
    @SerializedName("OperAlterEntrySeq")
    val operAlterEntrySeq: Int? = 0,
    @SerializedName("OperAlterNumber")
    val operAlterNumber: String? = "",
    @SerializedName("OperCancel")
    val operCancel: String? = "",
    @SerializedName("OperCheckDiffQty")
    val operCheckDiffQty: Int? = 0,
    @SerializedName("OperDescription")
    val operDescription: List<OperDescription>? = null,
    @SerializedName("OperExcessCtrlQty")
    val operExcessCtrlQty: Int? = 0,
    @SerializedName("OperFirstFinishTime")
    val operFirstFinishTime: String? = "",
    @SerializedName("OperFirstStartTime")
    val operFirstStartTime: String? = "",
    @SerializedName("OperHeadBaseQty")
    val operHeadBaseQty: Int? = 0,
    @SerializedName("OperHeadQty")
    val operHeadQty: Int? = 0,
    @SerializedName("OperLastFinishTime")
    val operLastFinishTime: String? = "",
    @SerializedName("OperLastStartTime")
    val operLastStartTime: String? = "",
    @SerializedName("OperMOUnitId")
    val operMOUnitId: OperMOUnitId? = null,
    @SerializedName("OperMOUnitId_Id")
    val operMOUnitIdId: Int? = 0,
    @SerializedName("OperNumber")
    val operNumber: String? = "",
    @SerializedName("OperPhase")
    val operPhase: Int? = 0,
    @SerializedName("OperPickStauts")
    val operPickStauts: String? = "",
    @SerializedName("OperPlanFinishTime")
    val operPlanFinishTime: String? = "",
    @SerializedName("OperPlanStartTime")
    val operPlanStartTime: String? = "",
    @SerializedName("OperQty")
    val operQty: Int? = 0,
    @SerializedName("OperResStockQty")
    val operResStockQty: Int? = 0,
    @SerializedName("OperSrcDetailId")
    val operSrcDetailId: Int? = 0,
    @SerializedName("OperSrcType")
    val operSrcType: String? = "",
    @SerializedName("OperStatus")
    val operStatus: String? = "",
    @SerializedName("OperUnitId")
    val operUnitId: OperUnitId? = null,
    @SerializedName("OperUnitId_Id")
    val operUnitIdId: Int? = 0,
    @SerializedName("OptCtrlCodeId")
    val optCtrlCodeId: OptCtrlCodeId? = null,
    @SerializedName("OptCtrlCodeId_Id")
    val optCtrlCodeIdId: Int? = 0,
    @SerializedName("OutSrcCurrency_Id")
    val outSrcCurrencyId: Int? = 0,
    @SerializedName("OutSrcLeadTime")
    val outSrcLeadTime: Int? = 0,
    @SerializedName("OutSrcPrice")
    val outSrcPrice: Int? = 0,
    @SerializedName("OutSrcTaxPrice")
    val outSrcTaxPrice: Int? = 0,
    @SerializedName("PatrolStatus")
    val patrolStatus: String? = "",
    @SerializedName("PickingQty")
    val pickingQty: Int? = 0,
    @SerializedName("PrdCheckDiffQty")
    val prdCheckDiffQty: Int? = 0,
    @SerializedName("PrdExcessCtrlQty")
    val prdExcessCtrlQty: Int? = 0,
    @SerializedName("PrdResStockQty")
    val prdResStockQty: Int? = 0,
    @SerializedName("PrdWastageQty")
    val prdWastageQty: Int? = 0,
    @SerializedName("PrepareFinishTime")
    val prepareFinishTime: String? = "",
    @SerializedName("PrepareStartTime")
    val prepareStartTime: String? = "",
    @SerializedName("PrepareUnit")
    val prepareUnit: String? = "",
    @SerializedName("PrepareWorkTime")
    val prepareWorkTime: Int? = 0,
    @SerializedName("PriceList_Id")
    val priceListId: Int? = 0,
    @SerializedName("ProcessCheckSchemaEntryId_Id")
    val processCheckSchemaEntryIdId: Int? = 0,
    @SerializedName("ProcessFinishTime")
    val processFinishTime: String? = "",
    @SerializedName("ProcessId")
    val processId: ProcessId? = null,
    @SerializedName("ProcessId_Id")
    val processIdId: Int? = 0,
    @SerializedName("ProcessOrgId")
    val processOrgId: ProcessOrgId? = null,
    @SerializedName("ProcessOrgId_Id")
    val processOrgIdId: Int? = 0,
    @SerializedName("ProcessRemainWorkTime")
    val processRemainWorkTime: Int? = 0,
    @SerializedName("ProcessStartTime")
    val processStartTime: String? = "",
    @SerializedName("ProcessUnit")
    val processUnit: String? = "",
    @SerializedName("ProcessWorkTime")
    val processWorkTime: Int? = 0,
    @SerializedName("PurchaseGroupId_Id")
    val purchaseGroupIdId: Int? = 0,
    @SerializedName("PurchaseOrgId")
    val purchaseOrgId: PurchaseOrgId? = null,
    @SerializedName("PurchaseOrgId_Id")
    val purchaseOrgIdId: Int? = 0,
    @SerializedName("QCSchemeId_Id")
    val qCSchemeIdId: Int? = 0,
    @SerializedName("QualifiedBaseQty")
    val qualifiedBaseQty: Int? = 0,
    @SerializedName("QualifiedHeadQty")
    val qualifiedHeadQty: Int? = 0,
    @SerializedName("QualifiedQty")
    val qualifiedQty: Int? = 0,
    @SerializedName("RateOperQty")
    val rateOperQty: Int? = 0,
    @SerializedName("RateProQty")
    val rateProQty: Int? = 0,
    @SerializedName("RateValQty")
    val rateValQty: Int? = 0,
    @SerializedName("ReFinishBaseQty")
    val reFinishBaseQty: Int? = 0,
    @SerializedName("ReFinishHeadQty")
    val reFinishHeadQty: Int? = 0,
    @SerializedName("ReFinishQty")
    val reFinishQty: Int? = 0,
    @SerializedName("ReSelBaseQty")
    val reSelBaseQty: Int? = 0,
    @SerializedName("ReSelHeadQty")
    val reSelHeadQty: Int? = 0,
    @SerializedName("ReSelQty")
    val reSelQty: Int? = 0,
    @SerializedName("ReTransOutBaseQty")
    val reTransOutBaseQty: Int? = 0,
    @SerializedName("ReTransOutHeadQty")
    val reTransOutHeadQty: Int? = 0,
    @SerializedName("ReTransOutQty")
    val reTransOutQty: Int? = 0,
    @SerializedName("ReWorkBaseQty")
    val reWorkBaseQty: Int? = 0,
    @SerializedName("ReWorkHeadQty")
    val reWorkHeadQty: Int? = 0,
    @SerializedName("ReWorkQty")
    val reWorkQty: Int? = 0,
    @SerializedName("RealPrepareFinishTime")
    val realPrepareFinishTime: String? = "",
    @SerializedName("RealPrepareStartTime")
    val realPrepareStartTime: String? = "",
    @SerializedName("RealProcessFinishTime")
    val realProcessFinishTime: String? = "",
    @SerializedName("RealProcessStartTime")
    val realProcessStartTime: String? = "",
    @SerializedName("RealRemoveFinishTime")
    val realRemoveFinishTime: String? = "",
    @SerializedName("RealRemoveStartTime")
    val realRemoveStartTime: String? = "",
    @SerializedName("RealSplitQty")
    val realSplitQty: Int? = 0,
    @SerializedName("RejectionRate")
    val rejectionRate: Int? = 0,
    @SerializedName("RemoveFinishTime")
    val removeFinishTime: String? = "",
    @SerializedName("RemoveRemainWorkTime")
    val removeRemainWorkTime: Int? = 0,
    @SerializedName("RemoveStartTime")
    val removeStartTime: String? = "",
    @SerializedName("RemoveUnit")
    val removeUnit: String? = "",
    @SerializedName("RemoveWorkTime")
    val removeWorkTime: Int? = 0,
    @SerializedName("ReportBaseQty")
    val reportBaseQty: Int? = 0,
    @SerializedName("ReportHeadQty")
    val reportHeadQty: Int? = 0,
    @SerializedName("ReportQty")
    val reportQty: Int? = 0,
    @SerializedName("ResourceId_Id")
    val resourceIdId: Int? = 0,
    @SerializedName("ScanFeatureCode")
    val scanFeatureCode: String? = "",
    @SerializedName("ScheduleTime")
    val scheduleTime: String? = "",
    @SerializedName("ScrapBaseQty")
    val scrapBaseQty: Int? = 0,
    @SerializedName("ScrapHeadQty")
    val scrapHeadQty: Int? = 0,
    @SerializedName("ScrapPrice")
    val scrapPrice: Int? = 0,
    @SerializedName("ScrapQty")
    val scrapQty: Int? = 0,
    @SerializedName("ScrapTaxPrice")
    val scrapTaxPrice: Int? = 0,
    @SerializedName("SelMoType")
    val selMoType: String? = "",
    @SerializedName("Seq")
    val seq: Int? = 0,
    @SerializedName("ShiftGroupId_Id")
    val shiftGroupIdId: Int? = 0,
    @SerializedName("ShiftSliceId_Id")
    val shiftSliceIdId: Int? = 0,
    @SerializedName("SplitMinWorkTime")
    val splitMinWorkTime: Int? = 0,
    @SerializedName("SplitMinWorkTimeUnit")
    val splitMinWorkTimeUnit: String? = "",
    @SerializedName("SrcSubEntityId")
    val srcSubEntityId: Int? = 0,
    @SerializedName("StdMoveTime")
    val stdMoveTime: Int? = 0,
    @SerializedName("StdMoveTimeUnit")
    val stdMoveTimeUnit: String? = "",
    @SerializedName("StdQueueTime")
    val stdQueueTime: Int? = 0,
    @SerializedName("StdQueueTimeUnit")
    val stdQueueTimeUnit: String? = "",
    @SerializedName("StdWaitTime")
    val stdWaitTime: Int? = 0,
    @SerializedName("StdWaitTimeUnit")
    val stdWaitTimeUnit: String? = "",
    @SerializedName("Supplier_Id")
    val supplierId: Int? = 0,
    @SerializedName("TaxRate")
    val taxRate: Int? = 0,
    @SerializedName("TransInBaseQty")
    val transInBaseQty: Int? = 0,
    @SerializedName("TransInHeadQty")
    val transInHeadQty: Int? = 0,
    @SerializedName("TransInQty")
    val transInQty: Int? = 0,
    @SerializedName("TransOutBaseQty")
    val transOutBaseQty: Int? = 0,
    @SerializedName("TransOutHeadQty")
    val transOutHeadQty: Int? = 0,
    @SerializedName("TransOutQty")
    val transOutQty: Int? = 0,
    @SerializedName("TransSelBaseQty")
    val transSelBaseQty: Int? = 0,
    @SerializedName("TransSelHeadQty")
    val transSelHeadQty: Int? = 0,
    @SerializedName("TransSelQty")
    val transSelQty: Int? = 0,
    @SerializedName("UnitTransHeadQty")
    val unitTransHeadQty: Int? = 0,
    @SerializedName("UnitTransOperQty")
    val unitTransOperQty: Int? = 0,
    @SerializedName("UnqualifiedBaseQty")
    val unqualifiedBaseQty: Int? = 0,
    @SerializedName("UnqualifiedHeadQty")
    val unqualifiedHeadQty: Int? = 0,
    @SerializedName("UnqualifiedQty")
    val unqualifiedQty: Int? = 0,
    @SerializedName("ValuationQty")
    val valuationQty: Int? = 0,
    @SerializedName("ValuationUnitId_Id")
    val valuationUnitIdId: Int? = 0,
    @SerializedName("WIPQty")
    val wIPQty: Int? = 0,
    @SerializedName("WastageQty")
    val wastageQty: Int? = 0,
    @SerializedName("WorkCenterId")
    val workCenterId: WorkCenterId? = null,
    @SerializedName("WorkCenterId_Id")
    val workCenterIdId: Int? = 0,
    @SerializedName("WorkTimeColect")
    val workTimeColect: String? = ""
)

data class DeptID(
    @SerializedName("Id")
    val id: Int? = 0,
    @SerializedName("msterID")
    val msterID: Int? = 0,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)


data class UseOrgId(
    @SerializedName("Id")
    val id: Int? = 0,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)

data class WorkCenterCapacity(
    @SerializedName("Id")
    val id: Int? = 0,
    @SerializedName("JoinScheduling")
    val joinScheduling: Boolean? = false,
    @SerializedName("RESOURCEID")
    val rESOURCEID: RESOURCEID? = null,
    @SerializedName("RESOURCEID_Id")
    val rESOURCEIDId: Int? = 0,
    @SerializedName("Seq")
    val seq: Int? = 0
)

data class WorkCenterScheduling(
    @SerializedName("Id")
    val id: Int? = 0,
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
    val processTimeFormulaId: Int? = 0,
    @SerializedName("Seq")
    val seq: Int? = 0,
    @SerializedName("SetTimeFormula")
    val setTimeFormula: SetTimeFormula? = null,
    @SerializedName("SetTimeFormula_Id")
    val setTimeFormulaId: Int? = 0,
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
    val tearDownTimeFormulaId: Int? = 0
)

data class RESOURCEID(
    @SerializedName("Id")
    val id: Int? = 0,
    @SerializedName("msterID")
    val msterID: Int? = 0,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)

data class ProcessTimeFormula(
    @SerializedName("Id")
    val id: Int? = 0,
    @SerializedName("msterID")
    val msterID: Int? = 0,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)

data class SetTimeFormula(
    @SerializedName("Id")
    val id: Int? = 0,
    @SerializedName("msterID")
    val msterID: Int? = 0,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)

data class TearDownTimeFormula(
    @SerializedName("Id")
    val id: Int? = 0,
    @SerializedName("msterID")
    val msterID: Int? = 0,
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
    val id: Int? = 0,
    @SerializedName("msterID")
    val msterID: Int? = 0,
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
    val fUnitIDId: Int? = 0,
    @SerializedName("Id")
    val id: Int? = 0,
    @SerializedName("msterID")
    val msterID: Int? = 0,
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
    val id: Int? = 0,
    @SerializedName("msterID")
    val msterID: Int? = 0,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)

data class ActivityUnitId(
    @SerializedName("Id")
    val id: Int? = 0,
    @SerializedName("msterID")
    val msterID: Int? = 0,
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
    val id: Int? = 0,
    @SerializedName("msterID")
    val msterID: Int? = 0,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)

data class MOBaseUnitId(
    @SerializedName("Id")
    val id: Int? = 0,
    @SerializedName("msterID")
    val msterID: Int? = 0,
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
    val id: Int? = 0,
    @SerializedName("msterID")
    val msterID: Int? = 0,
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
    val id: Int? = 0,
    @SerializedName("msterID")
    val msterID: Int? = 0,
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
    val id: Int? = 0,
    @SerializedName("IsScheduling")
    val isScheduling: Boolean? = false,
    @SerializedName("msterID")
    val msterID: Int? = 0,
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
    val id: Int? = 0,
    @SerializedName("msterID")
    val msterID: Int? = 0,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)

data class ProcessOrgId(
    @SerializedName("Id")
    val id: Int? = 0,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)

data class PurchaseOrgId(
    @SerializedName("Id")
    val id: Int? = 0,
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
    val deptIDId: Int? = 0,
    @SerializedName("EffectDate")
    val effectDate: String? = "",
    @SerializedName("ExpireDate")
    val expireDate: String? = "",
    @SerializedName("FFormId")
    val fFormId: String? = "",
    @SerializedName("Id")
    val id: Int? = 0,
    @SerializedName("IsDiscreteOperDispDetail")
    val isDiscreteOperDispDetail: Boolean? = false,
    @SerializedName("msterID")
    val msterID: Int? = 0,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = "",
    @SerializedName("OptCtrlCodeID")
    val optCtrlCodeID: OptCtrlCodeId? = null,
    @SerializedName("OptCtrlCodeID_Id")
    val optCtrlCodeIDId: Int? = 0,
    @SerializedName("ProcessID_Id")
    val processIDId: Int? = 0,
    @SerializedName("UseOrgId")
    val useOrgId: UseOrgId? = null,
    @SerializedName("UseOrgId_Id")
    val useOrgIdId: Int? = 0,
    @SerializedName("WorkCenterCapacity")
    val workCenterCapacity: List<WorkCenterCapacity>? = null,
    @SerializedName("WorkCenterScheduling")
    val workCenterScheduling: List<WorkCenterScheduling>? = null
)

data class FUnitID(
    @SerializedName("Id")
    val id: Int? = 0,
    @SerializedName("msterID")
    val msterID: Int? = 0,
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
    val auxPropertyIdId: Int? = 0,
    @SerializedName("Id")
    val id: Int? = 0,
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
    val baseUnitIdId: Int? = 0,
    @SerializedName("Id")
    val id: Int? = 0
)

data class MaterialStock(
    @SerializedName("Id")
    val id: Int? = 0,
    @SerializedName("IsExpParToFlot")
    val isExpParToFlot: Boolean? = false,
    @SerializedName("StoreUnitID")
    val storeUnitID: StoreUnitID? = null,
    @SerializedName("StoreUnitID_Id")
    val storeUnitIDId: Int? = 0
)

data class MultiLanguageText(
    @SerializedName("LocaleId")
    val localeId: Int? = null,
    @SerializedName("Name")
    val name: String? = null,
    @SerializedName("PkId")
    val pkId: Int? = null,
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
    val id: Int? = 0,
    @SerializedName("msterID")
    val msterID: Int? = 0,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)


data class StoreUnitID(
    @SerializedName("Id")
    val id: Int? = 0,
    @SerializedName("msterID")
    val msterID: Int? = 0,
    @SerializedName("MultiLanguageText")
    val multiLanguageText: List<MultiLanguageText>? = null,
    @SerializedName("Name")
    val name: List<Name>? = null,
    @SerializedName("Number")
    val number: String? = ""
)

data class RouteOperSeq(
    @SerializedName("Id")
    val id: Int? = null,
    @SerializedName("RouteOperDetail")
    val routeOperDetail: List<RouteOperDetail?>? = null,
    @SerializedName("Seq")
    val seq: Int? = null,
    @SerializedName("SeqNumber")
    val seqNumber: String? = null
)

data class RouteOperDetail(
    @SerializedName("Id")
    val id: Int? = null,
    @SerializedName("OperNumber")
    val operNumber: String? = null,
    @SerializedName("ReportCeilRatio")
    val reportCeilRatio: Int? = null,
    @SerializedName("ReportFloorRatio")
    val reportFloorRatio: Int? = null,
    @SerializedName("Seq")
    val seq: Int? = null
)