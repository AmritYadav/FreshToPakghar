package com.ftp.ui.grocery.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    val desc: String,

    @SerializedName("thumb")
    val imgUrl: String,

    val mrps: Int,

    @SerializedName("unit_price")
    val unitPrice: Int,

    @SerializedName("unit_size")
    val unitSize: String,

    @SerializedName("units_on_oder")
    val unitsOnOrder: Int,

    val discountedPrice: Int
) : Parcelable
