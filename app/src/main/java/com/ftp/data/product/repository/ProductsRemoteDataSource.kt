package com.ftp.data.product.repository

import com.ftp.data.common.BaseRemoteDataSource
import com.ftp.data.common.Result
import com.ftp.data.product.api.ProductApi
import com.ftp.ui.grocery.models.Product
import java.io.IOException


class ProductsRemoteDataSource(private val productApi: ProductApi) : BaseRemoteDataSource() {

    suspend fun getProduct(): Result<List<Product>> = safeApiCall(
        errorMessage = "Error loading products",
        call = { requestProducts() }
    )

    private suspend fun requestProducts(): Result<List<Product>> {
        val response = productApi.products()
        if (response.isSuccessful)
            response.body()?.let {
                return if (it.isSuccess() && it.response != null) Result.Success(it.response)
                else Result.Error(IOException(it.errorMessage()))
            }
        return Result.Error(IOException(response.errorBody()?.charStream().toString()))
    }

}
