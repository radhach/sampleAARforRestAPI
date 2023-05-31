package com.velmurugan.mvvmwithkotlincoroutinesandretrofit

import com.velmurugan.mvvmwithkotlincoroutinesandretrofit.profile.ProfileDataGetResponse

class MainRepository constructor(private val retrofitService: RetrofitService) {

    suspend fun getProfileData() : NetworkState<ProfileDataGetResponse> {
        val response = retrofitService.getProfileDetails()
        return if (response.isSuccessful) {
            val responseBody = response.body()
            if (responseBody != null) {
                NetworkState.Success(responseBody)
            } else {
                NetworkState.Error(response)
            }
        } else {
            NetworkState.Error(response)
        }
    }


    suspend fun sendMobileNumber( mobileNumber: String,
                                  deviceId: String,
                                  display: String,
                                  advertisingId: String,
                                  firebaseId : String) : NetworkState<SendMobileNumberResponse> {
        val response = retrofitService.sendMobileNumber( RestUtils.sendMobileNumber(
            mobileNumber,
            deviceId,
            display,
            advertisingId,
            firebaseId
        ))
        return if (response.isSuccessful) {
            val responseBody = response.body()
            if (responseBody != null) {
                NetworkState.Success(responseBody)
            } else {
                NetworkState.Error(response)
            }
        } else {
            NetworkState.Error(response)
        }
    }

}