package com.ftp.ui.grocery.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.ftp.ui.grocery.models.Product

class ProductAdapter(private val callback: (product: Product) -> Unit) :
    ListAdapter<Product, ProductViewHolder>(ProductsCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
        ProductViewHolder.create(parent)

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position), callback)
    }

}
