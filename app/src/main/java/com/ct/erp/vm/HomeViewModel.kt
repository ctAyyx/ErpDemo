package com.ct.erp.vm

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.ct.erp.base.BaseModel
import com.ct.erp.base.BaseViewModel
import com.ct.erp.dto.OilPrice
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(application: Application, model: BaseModel?) :
    BaseViewModel(application, model) {

    val priceInfo by lazy { MutableLiveData<List<OilPrice>>() }

    fun getOilPriceInfo(key: String) {
        launch {
            delay(2000)
            val result = serviceApi.getOilPriceInfo(key)
            if (isSuccess(result)) {
                priceInfo.value = result.data
            }
        }
    }

}