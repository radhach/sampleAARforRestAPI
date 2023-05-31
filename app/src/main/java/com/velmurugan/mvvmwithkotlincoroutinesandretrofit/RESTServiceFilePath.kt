package com.velmurugan.mvvmwithkotlincoroutinesandretrofit

/**
 * [RESTServiceFilePath] class gives file path of all the rest apis.
 * */
class RESTServiceFilePath {
    companion object {
        const val SHOULD_REMOVE_TOKEN = "shouldRemoveToken"

        const val REGISTER = "register"
        const val PHONE_NUMBER = "phoneNumber"
        const val APPLICATION_ID = "applicationId"
        const val MANUFACTURER_NAME = "manufacturerName"
        const val MODEL_NO = "modelNo"
        const val DISPLAY = "display"
        const val ADVERTISING_ID = "advertisingId"
        const val ANDROID_ID = "androidId"
        const val BOARD = "board"
        const val HOST = "host"
        const val FIREBASE_ID = "firebaseId"

        const val VERIFY = "verify"
        const val OTP = "otp"
        const val USER = "user"

        const val NAME = "name"
        const val EMAIL = "email"
        const val PROFILE_PICTURE = "profilePicture"

        const val PIN_KEY = "pin"
        const val PUBLIC_KEY = "publicKey"
        const val WALLET_PIN = "wallet/updatePin"
        const val TYPE = "type"
        const val USER_WALLET_TYPE = "userWalletType"
        const val SEND_WALLET_TYPE = "wallet/saveUserWalletType" //saveType

        const val GET_WALLET_TYPES = "walletTypeList"   //get wallet List

        const val SEND_PAY_REQ = "transaction"

        const val CONFIRM_PIN = "wallet/confirmPin"
        const val REFRESH_ACCESS_TOKEN = "refreshAccessToken"
        const val REFRESH_TOKEN = "refreshToken"
        const val GET_WALLET_DETAILS = "wallet/getWalletDetails"
        const val GET_DETAILS = " wallet/getDetails"
        const val ADDRESS_KEY = "walletId"
        const val PHONE_NUMBER_KEY = "phoneNumber"

        const val OFFLINE_SYNC = "transaction/offlineSync"
        const val RECENT_TRANSACTION = "transactionList"
        const val DEVICE_THUMBPRINT_KEY= "deviceThumbprint"

        const val BANK_LIST = "bankList" //Get bank list
        const val USER_BANK_LIST = "userBankList" //Get user bank list
        const val ADD_USER_BANK = "addUserBank" //Add user bank
        const val DELETE_USER_BANK = "deleteUserBank/{id}" //Remove the user bank
        const val NOTIFICATION = "notification" // get all notifications
    }
}
