package com.ct.erp.common

class ErpException(private val errorCode: Int, msg: String) : RuntimeException(msg) {
}