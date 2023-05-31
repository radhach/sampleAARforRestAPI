package com.velmurugan.mvvmwithkotlincoroutinesandretrofit

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("message") val msg: String,
    @SerializedName("code") val code: Int
) : java.io.Serializable
