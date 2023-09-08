package com.ct.erp

import com.ct.erp.dto.UserViewData
import com.ct.utils.SingletonHolder

class LoginManager {
    companion object : SingletonHolder<LoginManager>(::LoginManager)


    private var _userName: String? = null
    private var _token: String? = null
    private var _userId: String? = null
    private var _isAdmin: Boolean = false


    /**
     * @param user 用户信息
     * @param isFromLocal 用户信息是否来自本地缓存
     */
    fun login(user: UserViewData, isFromLocal: Boolean = false) {
        _userName = user.userName
        _token = user.userToken
        _userId = user.userId
        _isAdmin = user.isAdmin ?: false
        if (!isFromLocal) {
            //TODO 用户登录成功 通知界面
        }
    }

    fun logout() {
        _userName = null
        _token = null
        _userId = null
        _isAdmin = false

        //TODO 用户退出登录 通知界面
    }

    fun isLogin(): Boolean {
        return _token != null
    }
}