package com.ct.erp.common

enum class UserLoginState {
    LOGIN_SUCCESS, LOGOUT_SUCCESS
}

/**
 * 用户登录状态事件
 */
data class UserStateEvent(
    val loginState: UserLoginState,
    val isLogoutByUser: Boolean
)