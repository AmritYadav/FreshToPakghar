package com.ftp.data.common

import com.google.gson.annotations.SerializedName

data class CommonApiResponse<T>(
    @SerializedName("status")
    val statusCode: Int,
    val response: T?,
    @SerializedName("error")
    val errorBody: String?
) : FtpApi {
    override fun isSuccess(): Boolean = statusCode == 200
    override fun tokenExpired(): Boolean = statusCode == 404
    override fun errorMessage(): String? = errorBody
}

interface FtpApi {
    fun isSuccess(): Boolean
    fun tokenExpired(): Boolean
    fun errorMessage(): String?
}