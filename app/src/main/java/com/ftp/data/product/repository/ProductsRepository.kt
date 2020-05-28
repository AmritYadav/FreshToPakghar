package com.ftp.data.product.repository

import com.ftp.data.common.Result
import com.ftp.ui.grocery.adapters.ProductResult

class ProductsRepository(private val remoteDataSource: ProductsRemoteDataSource) {


    suspend fun productList() = when (val response = remoteDataSource.getProduct()) {
        is Result.Success -> ProductResult(
            products = response.data
        )
        is Result.Error -> ProductResult(
            error = response.exception.message
        )
    }
}
