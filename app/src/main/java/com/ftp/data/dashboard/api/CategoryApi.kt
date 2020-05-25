package com.ftp.data.dashboard.api

import com.ftp.data.common.CommonApiResponse
import com.ftp.data.dashboard.models.CategoryApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface CategoryApi {

    @GET("/api/categories")
    suspend fun categories(): Response<CommonApiResponse<List<CategoryApiResponse>>>

}