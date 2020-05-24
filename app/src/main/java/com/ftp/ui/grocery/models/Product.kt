package com.ftp.ui.grocery.models

import androidx.annotation.DrawableRes

data class Product(
    val id: Int,
    val name: String,
    val desc: String,
    @DrawableRes val imgUrl: Int,
    val mrp: Int,
    val discountedPrice: Int
)