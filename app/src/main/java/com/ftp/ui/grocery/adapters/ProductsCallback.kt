package com.ftp.ui.grocery.adapters

import androidx.recyclerview.widget.DiffUtil
import com.ftp.ui.grocery.models.Product

class ProductsCallback : DiffUtil.ItemCallback<Product>() {
    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }
}
