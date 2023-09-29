package com.ct.erp.api

import com.ct.erp.dto.DispatchDetailListApiData
import com.ct.erp.dto.DispatchPlanApiData
import com.ct.erp.dto.HomeApiData
import com.ct.erp.dto.ServiceResult
import com.ct.erp.dto.LoginApiData
import com.google.gson.JsonObject
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.Url

@JvmSuppressWildcards
interface ServiceApi {

    @POST("auth/b/doLogin")
    suspend fun login(@Body body: JsonObject): ServiceResult<String>

    @GET("auth/b/getLoginUser")
    suspend fun getUserInfo(): ServiceResult<LoginApiData>

    @GET("auth/b/doLogout")
    suspend fun logout(): ServiceResult<Any>

    @GET("sys/userCenter/loginMobileMenu")
    suspend fun getHomeMenu(): ServiceResult<List<HomeApiData>>

    @GET("biz/k3cloud/dispatching/query")
    suspend fun getDispatchList(
        @Query("FilterString") filter: String,
        @Query("StartRow") startRow: String,
        @Query("Limit") limit: String
    ): ServiceResult<List<DispatchDetailListApiData>>

    @GET("/biz/k3cloud/process-plan/view")
    suspend fun getDispatchPlan(
        @Query("Number") number: String,
        @Query("SeqNumber") seqNumber: String,
        @Query("operNumber") operNumber: String
    ): ServiceResult<DispatchPlanApiData>

    @POST("")
    suspend fun pushDispatchPlan(@Body body:DispatchPlanApiData)

}