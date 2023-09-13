package com.ct.erp.vm

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.ct.erp.common.LoginManager
import com.ct.erp.base.BaseModel
import com.ct.erp.base.BaseViewModel
import com.ct.erp.common.ErpException
import com.ct.erp.dto.ServiceResult
import com.ct.erp.dto.LoginApiData
import com.ct.erp.vo.UserViewData
import com.ct.utils.LogUtils
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

    val loginStatus by lazy { MutableLiveData<UserViewData>() }

    fun login(userName: String, userPwd: String) {
        launch {
            flow {
                val response = mock()//serviceApi.login(userName, userPwd)
                if (isSuccess(response)) {
                    LoginManager.getInstance().login(response.data)
                    emit(response.data)
                } else throw ErpException(0, "登录失败,请重试!")
            }.map {
                val response = mockUser() //  serviceApi.getUserInfo()
                if (isSuccess(response)) convertUserApiData2ViewData(response.data, it)
                else throw ErpException(0, "获取用户信息失败!")
            }.collectLatest {
                loginStatus.value = it
            }
        }
    }

    private fun mock() = ServiceResult<String>(
        code = "200", data = "111111111", errorMsg = ""
    )

    private fun mockUser() = ServiceResult<LoginApiData>(
        code = "200", data = LoginApiData(
            name = "测试用户", nickname = "测试用户", avatar = "xxx", id = "999"
        ), errorMsg = ""
    )

    private fun convertUserApiData2ViewData(apiData: LoginApiData?, userToken: String?): UserViewData {
        return UserViewData(
            userToken = userToken ?: "",
            userName = apiData?.nickname ?: "",
            userIcon = apiData?.avatar ?: "",
            isAdmin = true,
            userId = apiData?.id ?: ""
        )
    }


    fun logout() {
        launch {
            LoginManager.getInstance().logout(true)
            loginStatus.value = null
        }
    }


}