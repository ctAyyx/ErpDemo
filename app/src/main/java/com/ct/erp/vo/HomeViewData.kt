package com.ct.erp.vo

import com.ct.erp.base.adapter.BaseViewHolderData

enum class HomeViewHolderType {
    TYPE_TITLE, TYPE_MENU
}

sealed class HomeViewData(holderType: HomeViewHolderType) : BaseViewHolderData<HomeViewHolderType>() {
    override val viewHolderType: HomeViewHolderType = holderType
}

data class HomeTitleViewData(
    val category: String? = "",
    val code: String? = "",
    val color: String? = "",
    val deleteFlag: String? = "",
    val icon: String? = "",
    val id: String? = "",
    val name: String? = "",
    val parentId: String? = "",
    val path: String? = "",
    val sortCode: Int? = 0,
    val title: String? = "",
    val weight: Int? = 0
) : HomeViewData(HomeViewHolderType.TYPE_TITLE) {
    override fun getDataSourceKey(): String {
        return "home/title/$id"
    }

}

data class HomeMenuViewData(
    val category: String? = "",
    val color: String? = "",
    val deleteFlag: String? = "",
    val icon: String? = "",
    val id: String? = "",
    val menuType: String? = "",
    val module: String? = "",
    val name: String? = "",
    val parentId: String? = "",
    val path: String? = "",
    val regType: String? = "",
    val sortCode: Int? = 0,
    val status: String? = "",
    val title: String? = "",
    val weight: Int? = 0
) : HomeViewData(HomeViewHolderType.TYPE_MENU) {
    override fun getDataSourceKey(): String {
        return "home/menu/$parentId:$id"
    }
}


