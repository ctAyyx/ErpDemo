package com.ct.erp.dto

data class ServiceResult<T>(
    val data: T?,
    val code: String,
    val errorMsg: String?
) {
    fun isSuccess(): Boolean {
        return "0" == code
    }

    fun next(block: (data: T?) -> Unit) {
        if (isSuccess()) {
            block.invoke(data)
        }
    }
}

