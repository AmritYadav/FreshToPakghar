package com.ftp.data.dashboard.models

import com.ftp.R
import com.ftp.ui.dashboard.models.Category
import com.google.gson.annotations.SerializedName

data class CategoryApiResponse(
    val id: Int,
    val name: String,
    @SerializedName("parent_id") val parentId: Int,
    val description: String,
    val thumb: String,
    @SerializedName("is_active") val isActive: Int,
    @SerializedName("pref_type") val prefType: Int,
    @SerializedName("created_at") val createdOn: String,
    @SerializedName("updated_at") val updatedOn: String
)

fun CategoryApiResponse.toCategory() = Category(
    id,
    R.drawable.ic_poultry,
    name
)