package com.ftp.ui.dashboard.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.ftp.ui.dashboard.models.Category

class CategoryAdapter(
    private val callback: (categoryId: Int) -> Unit
) :
    ListAdapter<Category, CategoryViewHolder>(CategoryCallback()) {

    class CategoryCallback : DiffUtil.ItemCallback<Category>() {
        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder =
        CategoryViewHolder.create(parent)

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position), callback)
    }


}
