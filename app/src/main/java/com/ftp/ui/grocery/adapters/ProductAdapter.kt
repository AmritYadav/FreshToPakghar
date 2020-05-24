package com.ftp.ui.grocery.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ftp.ui.grocery.models.Product

class ProductAdapter(private val products: List<Product>, private val callback: (product: Product) -> Unit) :
    RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
        ProductViewHolder.create(parent)

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position], callback)
    }

}