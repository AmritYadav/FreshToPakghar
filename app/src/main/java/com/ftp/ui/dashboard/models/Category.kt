package com.ftp.ui.dashboard.models

import androidx.annotation.DrawableRes
import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("id")
    val id: Int,

    @SerializedName("thumb")
    val imageUrl: String,

    @SerializedName("parent_id")
    val parentId: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("is_active")
    val isActive: Int = 1,

    @SerializedName("pref_type")
    val prefType: Int = 1
)
