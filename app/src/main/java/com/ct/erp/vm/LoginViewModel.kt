package com.ct.erp.vm

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.ct.erp.common.LoginManager
import com.ct.erp.base.BaseModel
import com.ct.erp.base.BaseViewModel
import com.ct.erp.common.CommonPref
import com.ct.erp.common.Constants
import com.ct.erp.common.ErpException
import com.ct.erp.dto.ServiceResult
import com.ct.erp.dto.LoginApiData
import com.ct.erp.vo.UserViewData
import com.ct.utils.LogUtils
import com.ct.utils.Sm2Utils
import com.google.gson.JsonObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * 针对简单逻辑处理 不创建Repository 不使用dto - vo
 */
@HiltViewModel
class LoginViewModel @Inject constructor(application: Application, model: BaseModel?) :
    BaseViewModel(application, model) {

    @Inject
    lateinit var comPref: CommonPref
    val loginStatus by lazy { MutableLiveData<UserViewData>() }

    fun login(userName: String, userPwd: String) {
        launch {
            flow {
                val jsonObject = JsonObject()
                jsonObject.addProperty("account", userName)
                jsonObject.addProperty("password", encoderPwd(userPwd))
                val response = mock()//serviceApi.login(jsonObject)
                if (isSuccess(response)) {
                    LoginManager.getInstance().login(response.data)
                    emit(response.data)
                } else throw ErpException(0, "登录失败,请重试!")
            }.map {
                val response = mockUser(userName) //  serviceApi.getUserInfo()
                if (isSuccess(response)) convertUserApiData2ViewData(response.data, it)
                else throw ErpException(0, "获取用户信息失败!")
            }.collectLatest {
                loginStatus.value = it
                comPref.userDataJson = it
            }
        }
    }

    private fun encoderPwd(userPwd: String): String {
        return Sm2Utils.encodeM2(Constants.SM_PUBLIC_KEY, userPwd)
    }

    private fun mock() = ServiceResult<String>(
        code = "200", data = "111111111", errorMsg = ""
    )

    private fun mockUser(userName: String) = ServiceResult<LoginApiData>(
        code = "200", data = LoginApiData(
            name = "测试用户", nickname = userName, avatar = "xxx", id = "999"
        ), errorMsg = ""
    )

    private fun convertUserApiData2ViewData(apiData: LoginApiData?, userToken: String?): UserViewData {
        return UserViewData(
            userToken = userToken ?: "",
            userName = apiData?.nickname ?: "",
            userIcon = apiData?.avatar ?: "",
            isAdmin = true,
            userId = apiData?.id ?: "",
            xkUserId = apiData?.xkUserId,
            xkUserName = apiData?.xkUserName
        )
    }


    fun logout() {
        launch {
            val response = mock()//serviceApi.logout()
            if (isSuccess(response)) {
                LoginManager.getInstance().logout(true)
                loginStatus.value = null
                comPref.clearUserInfo()
            }
        }
    }


}