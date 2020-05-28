package com.ftp.ui.cart.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ftp.R
import com.ftp.databinding.ItemCartProductBinding
import com.ftp.ui.grocery.models.Product
import com.ftp.utils.inflateDataBindingView

class CartProductViewHolder(private val binding: ItemCartProductBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(product: Product){
        binding.product = product
    }

    companion object {
        fun create(parent: ViewGroup): CartProductViewHolder = CartProductViewHolder(
            parent.inflateDataBindingView(
                R.layout.item_cart_product
            )
        )
    }

}
