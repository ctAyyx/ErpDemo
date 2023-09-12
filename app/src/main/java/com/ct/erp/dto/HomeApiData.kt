package com.ct.erp.dto


data class HomeApiData(
    val category: String? = "",
    val children: List<HomeApiData>?,
    val code: String? = "",
    val color: String? = "",
    val deleteFlag: String? = "",
    val icon: String? = "",
    val id: String? = "",
    val meta: MetaX? = null,
    val name: String? = "",
    val parentId: String? = "",
    val path: String? = "",
    val sortCode: Int? = 0,
    val title: String? = "",
    val weight: Int? = 0,


    val menuType: String? = "",
    val module: String? = "",
    val regType: String? = "",
    val status: String? = "",
)




data class MetaX(
    val icon: String? = null, val title: String? = null, val type: String? = null
)

