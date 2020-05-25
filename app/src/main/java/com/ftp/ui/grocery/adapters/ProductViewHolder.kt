package com.ftp.ui.grocery.adapters

import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ftp.R
import com.ftp.databinding.ItemProductBinding
import com.ftp.ui.grocery.models.Product
import com.ftp.utils.inflateDataBindingView
import com.ftp.utils.loadImage

class ProductViewHolder(private val binding: ItemProductBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(product: Product, callback: (product: Product) -> Unit) {
        binding.product = product
        binding.productImage.loadImage(product.imgUrl, itemView as CardView) {}
        binding.addToCart.setOnClickListener { callback.invoke(product) }
    }

    companion object {
        fun create(parent: ViewGroup): ProductViewHolder = ProductViewHolder(
            parent.inflateDataBindingView(
                R.layout.item_product
            )
        )
    }
}