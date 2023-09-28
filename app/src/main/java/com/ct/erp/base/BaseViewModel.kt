package com.ct.erp.base

import android.app.Application
import androidx.annotation.StringRes
import androidx.lifecycle.viewModelScope
import com.ct.erp.ErpApp
import com.ct.env.R
import com.ct.erp.common.Constants
import com.ct.erp.common.LoginManager
import com.ct.erp.api.ServiceApi
import com.ct.erp.common.ErpException
import com.ct.erp.dto.ServiceResult
import com.ct.utils.LogUtils
import com.ct.utils.SystemUtils
import com.king.frame.mvvmframe.base.BaseModel
import com.king.frame.mvvmframe.base.DataViewModel
import com.king.frame.mvvmframe.base.livedata.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.net.ConnectException
import java.net.SocketTimeoutException
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor(application: Application, model: BaseModel?) :
    DataViewModel(application, model) {

    fun getApp() = application as ErpApp

    fun getString(@StringRes resId: Int) = getApp().getString(resId)

    val serviceApi: ServiceApi by lazy { getRetrofitService(ServiceApi::class.java) }

    open val liveDataTag by lazy { SingleLiveEvent<Int>() }

    open fun isSuccess(result: ServiceResult<*>?, showError: Boolean = true, noResult: Boolean = false): Boolean {
        if (result?.isSuccess(noResult = noResult) == true) {
            return true
        }
        if (result?.code == Constants.HTTP_ERROR_TOKEN) {
            LoginManager.getInstance().logout()
        }

        if (showError) {
            sendMessage(result?.errorMsg ?: getString(R.string.result_failure))
        }
        return false
    }


    fun launch(showLoading: Boolean = true, tag: Int? = null, block: suspend () -> Unit) =
        launch(showLoading, tag, block) {
            LogUtils.e("请求失败:$it")
            if (SystemUtils.isNetWorkActive(getApp())) {
                when (it) {
                    is SocketTimeoutException -> sendMessage(getString(R.string.result_connect_timeout_error))
                    is ConnectException -> sendMessage(getString(R.string.result_connect_failed_error))
                    is ErpException -> sendMessage(it.message)
                    else -> sendMessage(getString(R.string.result_error))
                }
            } else {
                sendMessage(getString(R.string.result_network_unavailable_error))
            }
        }

    fun launch(showLoading: Boolean, tag: Int? = null, block: suspend () -> Unit, error: suspend (Throwable) -> Unit) =
        viewModelScope.launch {
            try {
                if (showLoading) {
                    showLoading()
                }
                delay(2000)
                block()
            } catch (e: Throwable) {
                error(e)
            }
            hideLoading()
            tag?.let {
                liveDataTag.value = it
            }

        }

}