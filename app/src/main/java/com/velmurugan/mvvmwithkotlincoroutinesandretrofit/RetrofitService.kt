package com.velmurugan.mvvmwithkotlincoroutinesandretrofit

import androidx.lifecycle.LiveData
import com.velmurugan.mvvmwithkotlincoroutinesandretrofit.profile.ProfileDataGetResponse
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitService {

    @GET("user")
    suspend fun getProfileDetails(): Response<ProfileDataGetResponse>

    @POST(RESTServiceFilePath.REGISTER)
    suspend fun sendMobileNumber(@Body hashMap: HashMap<String, Any>): Response<SendMobileNumberResponse>

    companion object {
        var retrofitService: RetrofitService? = null

        val token =
            "eyJraWQiOiJrbHdKTktaVjI5RXB3bFRZK1Z6cmJWWFdBNWpGV0ZXQktVeXFZMWNIM3NJPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiIwNWVmMzE0Yy00NWVjLTQ2ZTQtYTRkYy0zY2Y0ZjZmMzFhM2MiLCJpc3MiOiJodHRwczpcL1wvY29nbml0by1pZHAuYXAtc291dGgtMS5hbWF6b25hd3MuY29tXC9hcC1zb3V0aC0xX3JGU3FoZ0pobyIsImNsaWVudF9pZCI6IjQ3djNjNG43NDZsdm8xcTl2bWlwOGs2N29kIiwib3JpZ2luX2p0aSI6Ijc0MjQxNDE0LTg4OTctNDUxOC1iNWRkLTRjMzhhZTRkMWVmZSIsImV2ZW50X2lkIjoiOTVmMGI5NzMtMGE3MS00MDEwLThjN2ItMmMyYjllMDFiNzFmIiwidG9rZW5fdXNlIjoiYWNjZXNzIiwic2NvcGUiOiJhd3MuY29nbml0by5zaWduaW4udXNlci5hZG1pbiIsImF1dGhfdGltZSI6MTY4NTUzNTM4NiwiZXhwIjoxNjg1NTM4OTg2LCJpYXQiOjE2ODU1MzUzODYsImp0aSI6IjFmZjU5YmMzLWY0Y2QtNDgzMC04NjVmLWQyZjFlYTc2OTEyZSIsInVzZXJuYW1lIjoiMDVlZjMxNGMtNDVlYy00NmU0LWE0ZGMtM2NmNGY2ZjMxYTNjIn0.ICa8gA1eH7HZcyhBoyFs56ASnJ07Eios5ZvsqzmAFGA4dBE4vDhCXwyIN8kLAONI0Az4o_aiVfmTafmM4jKv6uXnUQShiR52L2E0fbqzz8nxr8YT_yHNkJZzUfU31_4XmmGzGPtGGmwEv2AUyMMqt7Qsw8mxR2lxCBZ56HJfM9_M_fDJvVpvOeIXICGyD-yKQeeLuLoEkDWXnji9yOmDxvsHOPBCAt_ee46OlJka8yECgnCLpapCnhavDh1ZVGXVk31XiYc9Rxn_RD47xp_-ezmHZXBj1Q7WZqc3tiC3-lQpucMdXfuJZgX72nHA8NNbIlLXv3PPoScPCwtLScLKZA"

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer $token")
                    .build()
                chain.proceed(request)
            }
            .build()

        fun getInstance(): RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://olda7w6gnk.execute-api.ap-south-1.amazonaws.com/dev-api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }

    }
}