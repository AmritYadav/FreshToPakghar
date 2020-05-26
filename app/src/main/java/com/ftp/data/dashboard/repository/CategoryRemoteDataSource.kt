package com.ftp.data.dashboard.repository

import com.ftp.data.common.BaseRemoteDataSource
import com.ftp.data.common.Result
import com.ftp.data.dashboard.api.CategoryApi
import com.ftp.ui.dashboard.models.Category
import java.io.IOException

class CategoryRemoteDataSource(private val categoryApi: CategoryApi) : BaseRemoteDataSource() {

    suspend fun getCategory(): Result<List<Category>> = safeApiCall(
        call = { requestCategories() },
        errorMessage = "Error loading categories"
    )

    private suspend fun requestCategories(): Result<List<Category>> {
        val response = categoryApi.categories()
        if (response.isSuccessful)
            response.body()?.let {
                return if (it.isSuccess() && it.response != null) Result.Success(it.response)
                else Result.Error(IOException(it.errorMessage()))
            }
        return Result.Error(IOException(response.errorBody()?.charStream().toString()))
    }

}
