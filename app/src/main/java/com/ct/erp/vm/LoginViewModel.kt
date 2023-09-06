package com.ct.erp.vm

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.ct.erp.base.BaseModel
import com.ct.erp.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

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
        }
    }




}