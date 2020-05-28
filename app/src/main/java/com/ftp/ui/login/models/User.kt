package com.ftp.ui.login.models

import com.google.gson.annotations.SerializedName

data class User(

    @SerializedName("id")
    val userId: Int,

    @SerializedName("first_name")
    val firstName: String,

    @SerializedName("last_name")
    val lastName: String,

    @SerializedName("mobile")
    val mobileNo: Int,

    @SerializedName("is_active")
    val isActive: Int,

    @SerializedName("email")
    val email: String


) {

    fun getUserName() = "$firstName $lastName"
}
