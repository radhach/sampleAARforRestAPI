package com.velmurugan.mvvmwithkotlincoroutinesandretrofit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.velmurugan.mvvmwithkotlincoroutinesandretrofit.profile.ProfileDataGetResponse
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel constructor(private val mainRepository: MainRepository) : ViewModel() {

     val _errorMessage = MutableLiveData<String>()


    val profileData = MutableLiveData<ProfileDataGetResponse>()

    val sendMobileNumberResponse = MutableLiveData<SendMobileNumberResponse>()
    var job: Job? = null


    val loading = MutableLiveData<Boolean>()


    fun getAllProfileDetails() {
        Log.d("Thread Outside", Thread.currentThread().name)

        viewModelScope.launch {
            Log.d("Thread Inside", Thread.currentThread().name)
            when (val response = mainRepository.getProfileData()) {
                is NetworkState.Success -> {
                    System.out.println("Radha>>>>>>>Success")
                    profileData.postValue(response.data)
                }
                is NetworkState.Error -> {
                    System.out.println("Radha>>>>>>>Error"+response)
                    _errorMessage.postValue(response.response.message())

                }
            }
        }
    }



    fun sendMobileNumber(mobileNumber: String,
                             deviceId: String,
                             display: String,
                             advertisingId: String,
                             firebaseId : String) {
        Log.d("Thread Outside", Thread.currentThread().name)

        viewModelScope.launch {
            Log.d("Thread Inside", Thread.currentThread().name)
            when (val response = mainRepository.sendMobileNumber( mobileNumber,
                deviceId,
                display,
                advertisingId,
                firebaseId)) {
                is NetworkState.Success -> {
                    System.out.println("Radha>>>>>>>Success")
                    sendMobileNumberResponse.postValue(response.data)
                }
                is NetworkState.Error -> {
                    System.out.println("Radha>>>>>>>Error"+response)
                    _errorMessage.postValue(response.response.message())

                }
            }
        }
    }

    private fun onError(message: String) {
        _errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}