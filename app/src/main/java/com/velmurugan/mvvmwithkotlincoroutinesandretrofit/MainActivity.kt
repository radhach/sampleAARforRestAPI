package com.velmurugan.mvvmwithkotlincoroutinesandretrofit

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.velmurugan.mvvmwithkotlincoroutinesandretrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val retrofitService = RetrofitService.getInstance()
        val mainRepository = MainRepository(retrofitService)


        viewModel = ViewModelProvider(
            this,
            MyViewModelFactory(mainRepository)
        ).get(MainViewModel::class.java)


        viewModel.profileData.observe(this) {
            System.out.println(">>>>>>>>>>Radha>>>>profileData" + it)
        }
        viewModel.sendMobileNumberResponse.observe(this) {
            System.out.println(">>>>>>>>>>Radha>>>>sendMobileNumberResponse" + it)
        }

        viewModel._errorMessage.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        viewModel.loading.observe(this, Observer {
            if (it) {
                binding.progressDialog.visibility = View.VISIBLE
            } else {
                binding.progressDialog.visibility = View.GONE
            }
        })

        // viewModel.getAllMovies()

        viewModel.getAllProfileDetails()

        viewModel.sendMobileNumber(
            "+911111111111",
            "12231421",
            "test",
            "idddd",
            "4651345167"
        )
    }
}