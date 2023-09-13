package com.ct.erp.api

import com.ct.erp.dto.HomeApiData
import com.ct.erp.dto.ServiceResult
import com.ct.erp.dto.LoginApiData
import retrofit2.http.GET
import retrofit2.http.POST

@JvmSuppressWildcards
interface ServiceApi {

    @POST("auth/b/doLogin")
    suspend fun login(userName: String, userPwd: String): ServiceResult<String>

    @GET("auth/b/getLoginUser")
    suspend fun getUserInfo(): ServiceResult<LoginApiData>


    @GET("sys/userCenter/loginMobileMenu")
    suspend fun getHomeMenu(): ServiceResult<List<HomeApiData>>

}