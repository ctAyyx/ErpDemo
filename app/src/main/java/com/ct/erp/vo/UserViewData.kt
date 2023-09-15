package com.ct.erp.vo

data class UserViewData(
    val userToken: String,
    val userName: String,
    val userIcon: String,
    val isAdmin: Boolean,
    val userId: String,
    val xkUserName: String? = null,
    val xkUserId: String? = null
)