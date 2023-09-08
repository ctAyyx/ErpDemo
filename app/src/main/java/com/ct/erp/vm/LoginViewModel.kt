package com.ct.erp.vm

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.ct.erp.LoginManager
import com.ct.erp.base.BaseModel
import com.ct.erp.base.BaseViewModel
import com.ct.erp.dto.UserViewData
import com.ct.utils.image.ImageManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

/**
 * 针对简单逻辑处理 不创建Repository 不使用dto - vo
 */
@HiltViewModel
class LoginViewModel @Inject constructor(application: Application, model: BaseModel?) :
    BaseViewModel(application, model) {

    val loginStatus by lazy { MutableLiveData<Boolean>() }

    fun login(userName: String, userPwd: String) {
        launch {
            delay(1000)

            val result = serviceApi.login(userName, userPwd)
            if (isSuccess(result)) {
                loginStatus.value = true
            }
            LoginManager.getInstance().login(UserViewData("admin", "1111111111111", "123456", isAdmin = true))
        }
    }

    fun logout() {
        launch {
            LoginManager.getInstance().logout()
        }
    }


}