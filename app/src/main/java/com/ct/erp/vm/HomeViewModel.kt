package com.ct.erp.vm

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.ct.erp.common.Constants
import com.ct.erp.common.LoginManager
import com.ct.erp.base.BaseModel
import com.ct.erp.base.BaseViewModel
import com.ct.erp.dto.HomeApiData
import com.ct.erp.dto.ServiceResult
import com.ct.erp.vo.HomeMenuViewData
import com.ct.erp.vo.HomeTitleViewData
import com.ct.erp.vo.HomeViewData
import dagger.hilt.android.lifecycle.HiltViewModel
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
            val apiResult = mock()//serviceApi.getHomeMenu()
            if (isSuccess(result = apiResult)) {
                homeMenu.value = convertHomeApiData2ViewData(apiResult.data)
            }
        }
    }


    private fun mock() = ServiceResult<List<HomeApiData>>(
        data = listOf(
            HomeApiData(
                title = "标题一", children = listOf(
                    HomeApiData(title = "分类1", icon = "https://cdn.pixabay.com/photo/2017/03/12/11/30/alishan-2136879_640.jpg", id = "111", parentId = "11"),
                    HomeApiData(title = "分类2", icon = "https://cdn.pixabay.com/photo/2017/03/12/11/30/alishan-2136879_640.jpg", id = "222", parentId = "22"),
                    HomeApiData(title = "分类3", icon = "https://cdn.pixabay.com/photo/2017/03/12/11/30/alishan-2136879_640.jpg", id = "333", parentId = "22"),
                    HomeApiData(title = "分类4", icon = "https://cdn.pixabay.com/photo/2017/03/12/11/30/alishan-2136879_640.jpg", id = "444", parentId = "44"),
                    HomeApiData(title = "分类5", icon = "https://cdn.pixabay.com/photo/2017/03/12/11/30/alishan-2136879_640.jpg", id = "555", parentId = "55"),
                    HomeApiData(title = "分类6", icon = "https://cdn.pixabay.com/photo/2017/03/12/11/30/alishan-2136879_640.jpg", id = "666", parentId = "66")
                )
            ),
            HomeApiData(
                title = "标题二", children = listOf(
                    HomeApiData(title = "分类1", icon = "https://cdn.pixabay.com/photo/2017/03/12/11/30/alishan-2136879_640.jpg", id = "111", parentId = "11"),
                    HomeApiData(title = "分类2", icon = "https://cdn.pixabay.com/photo/2017/03/12/11/30/alishan-2136879_640.jpg", id = "222", parentId = "22"),
                    HomeApiData(title = "分类3", icon = "https://cdn.pixabay.com/photo/2017/03/12/11/30/alishan-2136879_640.jpg", id = "333", parentId = "22"),
                    HomeApiData(title = "分类4", icon = "https://cdn.pixabay.com/photo/2017/03/12/11/30/alishan-2136879_640.jpg", id = "444", parentId = "44"),
                    HomeApiData(title = "分类5", icon = "https://cdn.pixabay.com/photo/2017/03/12/11/30/alishan-2136879_640.jpg", id = "555", parentId = "55"),
                    HomeApiData(title = "分类6", icon = "https://cdn.pixabay.com/photo/2017/03/12/11/30/alishan-2136879_640.jpg", id = "666", parentId = "66")
                )
            )
        ),
        code = if (LoginManager.getInstance().isLogin()) "200" else Constants.HTTP_ERROR_TOKEN,
        errorMsg = ""
    )

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