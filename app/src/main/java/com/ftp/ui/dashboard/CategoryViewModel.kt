package com.ftp.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ftp.data.common.NetworkState
import com.ftp.data.dashboard.repository.CategoryRepository
import com.ftp.ui.dashboard.models.Category
import kotlinx.coroutines.*

class CategoryViewModel(private val categoryRepository: CategoryRepository) : ViewModel() {

    private val completableJob = SupervisorJob()
    private val coroutineScope = CoroutineScope(Dispatchers.IO + completableJob)

    private var _networkState = MutableLiveData<NetworkState>()
    val networkState: LiveData<NetworkState> = _networkState

    private var _categories = MutableLiveData<List<Category>>()
    val categoryList: LiveData<List<Category>> = _categories

    fun loadDashboardCategories() {
        coroutineScope.launch {
            withContext(Dispatchers.Main) {
                _networkState.value = NetworkState.LOADING
            }
            val result = categoryRepository.categoryList()
            withContext(Dispatchers.Main) {
                if (result.categories != null) {
                    _networkState.value = NetworkState.LOADED
                    _categories.value = result.categories
                } else {
                    _networkState.value = NetworkState.error(result.error)
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        completableJob.cancel()
    }
}