package com.ftp.ui.dashboard.adapter

import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import com.ftp.R
import com.ftp.databinding.ItemCategoryBinding
import com.ftp.ui.dashboard.models.Category
import com.ftp.utils.inflateDataBindingView

class CategoryViewHolder(private val binding: ItemCategoryBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(category: Category, callback: (categoryId: Int) -> Unit) {
        binding.category = category
        ContextCompat.getDrawable(itemView.context, category.imageUrl)?.toBitmap()?.let {
            val palette = Palette.from(it).generate()
            palette.lightMutedSwatch?.rgb?.let { rgb ->
                (itemView as CardView).setCardBackgroundColor(rgb)
            }
        }
        itemView.setOnClickListener { callback.invoke(category.id) }
    }

    companion object {
        fun create(parent: ViewGroup): CategoryViewHolder = CategoryViewHolder(
            parent.inflateDataBindingView(R.layout.item_category)
        )
    }
}