package com.velmurugan.mvvmwithkotlincoroutinesandretrofit.profile

import com.google.gson.annotations.SerializedName
import com.velmurugan.mvvmwithkotlincoroutinesandretrofit.ErrorResponse

/**
 * model class for profile data get response
 */

data class ProfileDataGetResponse(
    @SerializedName("error") val errors: ErrorResponse,
    @SerializedName("data") var data: Data? = Data()
)

data class Data(
    @SerializedName("name") var name: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("profilePicture") var profilePicture: String? = null,
    @SerializedName("status") var status: String? = null
)