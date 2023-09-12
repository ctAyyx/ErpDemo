package com.ct.erp.dto

import com.google.gson.annotations.SerializedName

data class ServiceResult<T>(
    @SerializedName("data") val data: T?,
    @SerializedName("code") val code: String,
    @SerializedName("msg") val errorMsg: String?
) {
    fun isSuccess(noResult: Boolean = false): Boolean {
        return "200" == code && (!noResult && data != null)
    }

    fun next(block: (data: T?) -> Unit) {
        if (isSuccess()) {
            block.invoke(data)
        }
    }
}

