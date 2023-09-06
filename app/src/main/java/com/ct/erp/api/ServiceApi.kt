package com.ct.erp.api

import com.ct.erp.dto.OilPrice
import com.ct.erp.dto.ServiceResult
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

@JvmSuppressWildcards
interface ServiceApi {

    @POST("")
    suspend fun login(userName: String, userPwd: String): ServiceResult<Boolean>

    @GET("gnyj/query")
    suspend fun getOilPriceInfo(@Query("key") key: String): ServiceResult<List<OilPrice>>

}