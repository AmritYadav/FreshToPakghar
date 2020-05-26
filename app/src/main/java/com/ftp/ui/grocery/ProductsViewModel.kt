package com.ftp.ui.grocery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ftp.data.common.NetworkState
import com.ftp.data.product.repository.ProductsRepository
import com.ftp.ui.grocery.models.Product
import kotlinx.coroutines.*

class ProductsViewModel(private val productsRepository: ProductsRepository) : ViewModel() {

    private val completableJob = SupervisorJob()
    private val coroutineScope = CoroutineScope(Dispatchers.IO + completableJob)

    private var _networkState = MutableLiveData<NetworkState>()

    private val products: MutableLiveData<List<Product>> by lazy {
        MutableLiveData<List<Product>>().also {
            loadProducts()
        }
    }

    fun getProducts(): LiveData<List<Product>> {
        return products
    }

    private fun loadProducts() {
        coroutineScope.launch {
            withContext(Dispatchers.Main) {
                _networkState.value = NetworkState.LOADING
            }

            val result = productsRepository.productList()

            withContext(Dispatchers.Main) {
                if (result.products != null) {
                    _networkState.value = NetworkState.LOADED
                    products.value = result.products
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
