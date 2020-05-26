package com.ftp.ui.grocery.adapters

import com.ftp.ui.grocery.models.Product

data class ProductResult(
    val products: List<Product>? = null,
    val error: String? = null
)
