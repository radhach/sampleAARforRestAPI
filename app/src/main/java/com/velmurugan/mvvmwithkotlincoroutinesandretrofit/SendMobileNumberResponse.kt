package com.velmurugan.mvvmwithkotlincoroutinesandretrofit

import com.google.gson.annotations.SerializedName

/**
 * model class for send mobile number response
 */


data class SendMobileNumberResponse(
    @SerializedName("data") val data: SendMobileNumberData,
    @SerializedName("error") val errors: ErrorResponse
)


data class SendMobileNumberData(
    @SerializedName("message") val message: String
)
