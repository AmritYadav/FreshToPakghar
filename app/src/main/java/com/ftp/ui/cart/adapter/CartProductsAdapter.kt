package com.ftp.ui.cart.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.ftp.ui.grocery.adapters.ProductsCallback
import com.ftp.ui.grocery.models.Product

class CartProductsAdapter : ListAdapter<Product, CartProductViewHolder>(ProductsCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CartProductViewHolder.create(parent)


    override fun onBindViewHolder(holder: CartProductViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
