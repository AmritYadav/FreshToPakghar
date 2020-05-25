package com.ftp.ui.grocery.models

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    val id: Int,
    val name: String,
    val desc: String,
    @DrawableRes val imgUrl: Int,
    val mrp: Int,
    val discountedPrice: Int
) : Parcelable