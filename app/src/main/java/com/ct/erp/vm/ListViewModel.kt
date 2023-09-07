package com.ct.erp.vm

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.ct.erp.base.BaseViewModel
import com.ct.erp.dto.TestItemViewData
import com.king.frame.mvvmframe.base.BaseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(application: Application, model: BaseModel?) :
    BaseViewModel(application, model) {

    val mulResult by lazy { MutableLiveData<List<TestItemViewData>>() }

    fun getMulTypeList() {
        launch {
            delay(2000)
            val result = mutableListOf<TestItemViewData>()
            for (i in 0..20) {
                if (i % 3 == 0) {
                    TestItemViewData.TestOneViewData(id = "one:$i", "One Data $i").apply {
                        result.add(this)
                    }
                } else {
                    TestItemViewData.TestTwoViewData(id = "two:$i", "Two Data $i", imageUrl = "").apply {
                        result.add(this)
                    }
                }
            }
            mulResult.value = result
        }
    }
}