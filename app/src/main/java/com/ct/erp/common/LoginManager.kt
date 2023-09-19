package com.ct.erp.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ct.erp.dto.LoginApiData
import com.ct.erp.vo.UserViewData
import com.ct.utils.LiveDataBus
import com.ct.utils.LogUtils
import com.ct.utils.SingletonHolder

class LoginManager {
    companion object : SingletonHolder<LoginManager>(::LoginManager)


    private var _token: String? = null
    private var _userId: String? = null
    private val _userName = MutableLiveData<String>()
    private val _isAdmin = MutableLiveData<Boolean>(false)

    private var _xkUserName: String? = null


    val token: String
        get() = _token ?: ""


    val userName: LiveData<String>
        get() = _userName

    val isAdmin: LiveData<Boolean>
        get() = _isAdmin

    val userId: String
        get() = _userId ?: ""

    val xkUserName: String
        get() = _xkUserName ?: ""

    fun login(userToken: String?) {
        _token = userToken

    }

    /**
     * @param user 用户信息
     * @param isFromLocal 用户信息是否来自本地缓存
     */
    fun initUserInfo(user: UserViewData?, isFromLocal: Boolean = false) {
        user ?: return
        LogUtils.e("initUserInfo：$user")
        _userName.value = user.userName
        _isAdmin.value = user.isAdmin
        _userId = user.userId
        _xkUserName = user.xkUserName
        LiveDataBus.get().with(Constants.BUS_USER_LOGIN, UserStateEvent::class.java).value =
            UserStateEvent(loginState = UserLoginState.LOGIN_SUCCESS, isLogoutByUser = false)
    }

    fun logout(logoutByUser: Boolean = false) {
        LogUtils.e("用户退出登录:$logoutByUser")
        _userName.value = ""
        _token = null
        _userId = null
        _isAdmin.value = false

        LiveDataBus.get().with(Constants.BUS_USER_LOGIN, UserStateEvent::class.java).value =
            UserStateEvent(loginState = UserLoginState.LOGOUT_SUCCESS, isLogoutByUser = logoutByUser)
    }

    fun isLogin(): Boolean {
        return _token != null
    }
}