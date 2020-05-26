package com.ftp.data.product.api

import com.ftp.data.common.CommonApiResponse
import com.ftp.ui.grocery.models.Product
import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {

    @GET("/api/products")
    suspend fun products(): Response<CommonApiResponse<List<Product>>>
}
