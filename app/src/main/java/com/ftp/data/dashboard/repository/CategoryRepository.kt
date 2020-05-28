package com.ftp.data.dashboard.repository

import com.ftp.data.common.Result
import com.ftp.ui.dashboard.models.CategoryResult

class CategoryRepository(private val remoteDataSource: CategoryRemoteDataSource) {

    suspend fun categoryList() = when (val response = remoteDataSource.getCategory()) {
        is Result.Success -> CategoryResult(
            categories = response.data
        )
        is Result.Error -> CategoryResult(
            error = response.exception.message
        )
    }

}
