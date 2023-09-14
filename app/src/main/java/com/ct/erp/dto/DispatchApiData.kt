package com.ct.erp.dto

import com.google.gson.annotations.SerializedName

data class DispatchDetailListApiData(
    @SerializedName("FBarCode")
    val fBarCode: String? = null,
    @SerializedName("FBaseFinishSelQty")
    val fBaseFinishSelQty: Int? = null,
    @SerializedName("FBaseUnitID.FName")
    val fBaseUnitIDFName: String? = null,
    @SerializedName("FBaseUnitID.FNumber")
    val fBaseUnitIDFNumber: String? = null,
    @SerializedName("FBaseWorkQty")
    val fBaseWorkQty: Int? = null,
    @SerializedName("FBeginTime")
    val fBeginTime: String? = null,
    @SerializedName("FBillNo")
    val fBillNo: String? = null,
    @SerializedName("FCreateDate")
    val fCreateDate: String? = null,
    @SerializedName("FCreateMode")
    val fCreateMode: String? = null,
    @SerializedName("FCreatorId")
    val fCreatorId: String? = null,
    @SerializedName("FCreatorId.FName")
    val fCreatorIdFName: String? = null,
    @SerializedName("FDispatchTime")
    val fDispatchTime: String? = null,
    @SerializedName("FDispatchedQty")
    val fDispatchedQty: Int? = null,
    @SerializedName("FEmpId.FName")
    val fEmpIdFName: String? = null,
    @SerializedName("FEmpId.FStaffNumber")
    val fEmpIdFStaffNumber: String? = null,
    @SerializedName("FEmpText")
    val fEmpText: String? = null,
    @SerializedName("FEndTime")
    val fEndTime: String? = null,
    @SerializedName("FEquipmentId.FName")
    val fEquipmentIdFName: Any? = null,
    @SerializedName("FEquipmentId.FNumber")
    val fEquipmentIdFNumber: Any? = null,
    @SerializedName("FFinishSelHeadQty")
    val fFinishSelHeadQty: Int? = null,
    @SerializedName("FFinishSelQty")
    val fFinishSelQty: Int? = null,
    @SerializedName("FGroupId")
    val fGroupId: Int? = null,
    @SerializedName("FMOEntryId")
    val fMOEntryId: Int? = null,
    @SerializedName("FMaterialId.FName")
    val fMaterialIdFName: String? = null,
    @SerializedName("FMaterialId.FNumber")
    val fMaterialIdFNumber: String? = null,
    @SerializedName("FMoBillNo")
    val fMoBillNo: String? = null,
    @SerializedName("FMoSeq")
    val fMoSeq: Int? = null,
    @SerializedName("FMouldId")
    val fMouldId: Int? = null,
    @SerializedName("FMouldProdMixId")
    val fMouldProdMixId: Int? = null,
    @SerializedName("FOperId")
    val fOperId: Int? = null,
    @SerializedName("FOperNumber")
    val fOperNumber: String? = null,
    @SerializedName("FOperUnitID.FName")
    val fOperUnitIDFName: String? = null,
    @SerializedName("FOperUnitID.FNumber")
    val fOperUnitIDFNumber: String? = null,
    @SerializedName("FOptPlanNo")
    val fOptPlanNo: String? = null,
    @SerializedName("FPlanBeginTime")
    val fPlanBeginTime: String? = null,
    @SerializedName("FPlanEndTime")
    val fPlanEndTime: String? = null,
    @SerializedName("FPlanningQty")
    val fPlanningQty: Int? = null,
    @SerializedName("FProcessId.FName")
    val fProcessIdFName: String? = null,
    @SerializedName("FProcessId.FNumber")
    val fProcessIdFNumber: String? = null,
    @SerializedName("FReSelBaseQty")
    val fReSelBaseQty: Int? = null,
    @SerializedName("FReSelHeadQty")
    val fReSelHeadQty: Int? = null,
    @SerializedName("FReSelQty")
    val fReSelQty: Int? = null,
    @SerializedName("FReWorkBaseQty")
    val fReWorkBaseQty: Int? = null,
    @SerializedName("FReWorkHeadQty")
    val fReWorkHeadQty: Int? = null,
    @SerializedName("FReWorkQty")
    val fReWorkQty: Int? = null,
    @SerializedName("FResourceId.FName")
    val fResourceIdFName: String? = null,
    @SerializedName("FResourceId.FNumber")
    val fResourceIdFNumber: String? = null,
    @SerializedName("FSeqNumber")
    val fSeqNumber: String? = null,
    @SerializedName("FShiftGroupId.FName")
    val fShiftGroupIdFName: String? = null,
    @SerializedName("FShiftGroupId.FNumber")
    val fShiftGroupIdFNumber: String? = null,
    @SerializedName("FShiftSliceId")
    val fShiftSliceId: Int? = null,
    @SerializedName("FStatus")
    val fStatus: String? = null,
    @SerializedName("FUnitID.FName")
    val fUnitIDFName: String? = null,
    @SerializedName("FUnitID.FNumber")
    val fUnitIDFNumber: String? = null,
    @SerializedName("FUnitTransHeadQty")
    val fUnitTransHeadQty: Int? = null,
    @SerializedName("FUnitTransOperQty")
    val fUnitTransOperQty: Int? = null,
    @SerializedName("FWorkCenterId")
    val fWorkCenterId: Int? = null,
    @SerializedName("FWorkHeadQty")
    val fWorkHeadQty: Int? = null,
    @SerializedName("FWorkQty")
    val fWorkQty: Int? = null
)