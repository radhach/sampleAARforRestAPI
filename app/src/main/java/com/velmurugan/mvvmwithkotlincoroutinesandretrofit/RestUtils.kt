package com.velmurugan.mvvmwithkotlincoroutinesandretrofit

import android.os.Build


class RestUtils {
    companion object {

        fun sendMobileNumber(
            mobileNumber: String,
            deviceIMEI: String,
            display: String,
            advertisingId: String,
            firebaseId: String
        ): HashMap<String, Any> {
            val hashMap = HashMap<String, Any>()
            hashMap[RESTServiceFilePath.PHONE_NUMBER] = mobileNumber
            hashMap[RESTServiceFilePath.APPLICATION_ID] = "com.mobile.cbdc"
            hashMap[RESTServiceFilePath.MANUFACTURER_NAME] = Build.MANUFACTURER
            hashMap[RESTServiceFilePath.ANDROID_ID] = deviceIMEI
            hashMap[RESTServiceFilePath.MODEL_NO] = Build.MODEL
            hashMap[RESTServiceFilePath.ADVERTISING_ID] = advertisingId
            hashMap[RESTServiceFilePath.DISPLAY] = display
            hashMap[RESTServiceFilePath.BOARD] = Build.BOARD
            hashMap[RESTServiceFilePath.HOST] = Build.HOST
            hashMap[RESTServiceFilePath.FIREBASE_ID] = firebaseId
            return hashMap
        }

        fun sendRefreshToken(refreshToken: String): HashMap<String, Any> {
            var hashMap = HashMap<String, Any>()
            hashMap[RESTServiceFilePath.REFRESH_TOKEN] = refreshToken
            return hashMap
        }

        fun verifyOtp(mobileNumber: String, otp: String, publicKey: String): HashMap<String, Any> {
            var hashMap = HashMap<String, Any>()
            hashMap[RESTServiceFilePath.PHONE_NUMBER] = mobileNumber
            hashMap[RESTServiceFilePath.OTP] = otp
            hashMap[RESTServiceFilePath.PUBLIC_KEY] = publicKey
            return hashMap
        }

        fun sendProfileInfo(
            name: String,
            email: String,
            profilePicture: String
        ): HashMap<String, Any> {
            var hashMap = HashMap<String, Any>()
            hashMap[RESTServiceFilePath.NAME] = name
            hashMap[RESTServiceFilePath.EMAIL] = email
            hashMap[RESTServiceFilePath.PROFILE_PICTURE] = profilePicture
            return hashMap
        }

        fun getWalletAddressInfo(
            address: String,
            phoneNumber: String
        ): HashMap<String, Any> {
            var hashMap = HashMap<String, Any>()
            hashMap[RESTServiceFilePath.ADDRESS_KEY] = address
            hashMap[RESTServiceFilePath.PHONE_NUMBER_KEY] = phoneNumber
            return hashMap
        }

        fun sendWalletPin(walletPin: String): HashMap<String, Any> {
            var hashMap = HashMap<String, Any>()

            hashMap[RESTServiceFilePath.PIN_KEY] = walletPin
            return hashMap
        }

        fun sendWalletType(walletType: String): HashMap<String, Any> {
            var hashMap = HashMap<String, Any>()
            hashMap[RESTServiceFilePath.USER_WALLET_TYPE] = walletType
            return hashMap
        }

        fun confirmPin(pin: String,deviceThumbprint:String): HashMap<String, Any> {
            var hashMap = HashMap<String, Any>()
            hashMap[RESTServiceFilePath.PIN_KEY] = pin
            hashMap[RESTServiceFilePath.DEVICE_THUMBPRINT_KEY] = deviceThumbprint
            return hashMap
        }
    }
}