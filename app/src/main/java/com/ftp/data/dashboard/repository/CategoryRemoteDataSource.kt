package com.ftp.data.dashboard.repository

import com.ftp.data.common.Result
import com.ftp.data.dashboard.api.CategoryApi
import com.ftp.data.dashboard.models.CategoryApiResponse
import com.ftp.utils.safeApiCall
import java.io.IOException

class CategoryRemoteDataSource(private val categoryApi: CategoryApi) {

    suspend fun categories(): Result<List<CategoryApiResponse>> = safeApiCall(
        call = { requestCategories() },
        errorMessage = "Error loading categories"
    )

    private suspend fun requestCategories(): Result<List<CategoryApiResponse>> {
        val response = categoryApi.categories()
        if (response.isSuccessful)
            response.body()?.let {
                return if (it.isSuccess() && it.response != null) Result.Success(it.response)
                else Result.Error(IOException(it.errorMessage()))
            }
        return Result.Error(IOException(response.errorBody()?.charStream().toString()))
    }

}