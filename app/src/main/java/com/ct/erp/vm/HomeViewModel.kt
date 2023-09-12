package com.ct.erp.vm

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.ct.erp.base.BaseModel
import com.ct.erp.base.BaseViewModel
import com.ct.erp.dto.HomeApiData
import com.ct.erp.vo.HomeMenuViewData
import com.ct.erp.vo.HomeTitleViewData
import com.ct.erp.vo.HomeViewData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

/**
 *
 */
@HiltViewModel
class HomeViewModel @Inject constructor(application: Application, model: BaseModel?) :
    BaseViewModel(application, model) {


    val homeMenu by lazy { MutableLiveData<List<HomeViewData>>() }

    fun getHomeMenu() {
        launch {
            val apiResult = serviceApi.getHomeMenu()
            if (apiResult.isSuccess()) {
                homeMenu.value = convertHomeApiData2ViewData(apiResult.data)
            }
        }
    }


    private fun convertHomeApiData2ViewData(apiData: List<HomeApiData>?): List<HomeViewData> {
        val result = mutableListOf<HomeViewData>()
        apiData?.forEach { node ->
            val menus = node.children
            if (!menus.isNullOrEmpty()) {
                HomeTitleViewData(
                    id = node.id, title = node.title, category = node.category, icon = node.icon, code = node.color
                ).apply {
                    result.add(this)
                }
                menus.forEach { menu ->

                    HomeMenuViewData(
                        id = menu.id,
                        parentId = menu.parentId,
                        title = menu.title,
                        icon = menu.icon,
                        category = menu.category,
                        module = menu.module,
                        color = menu.color,
                        weight = menu.weight
                    ).apply {
                        result.add(this)
                    }


                }
            }


        }


        return result

    }

}