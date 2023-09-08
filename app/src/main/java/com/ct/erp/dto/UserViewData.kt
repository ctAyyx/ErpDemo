package com.ct.erp.dto

/**
 * 用户数据类
 *
 */
data class UserViewData(
    val userName: String?, val userToken: String?, val userId: String?, val isAdmin: Boolean?
) {
    fun isAlive(): Boolean {
        return userName != null && userToken != null && userId != null
    }
}