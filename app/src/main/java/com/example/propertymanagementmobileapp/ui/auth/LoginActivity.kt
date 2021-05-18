package com.example.propertymanagementmobileapp.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.propertymanagementmobileapp.R
import com.example.propertymanagementmobileapp.databinding.ActivityLoginBinding
import com.example.propertymanagementmobileapp.models.LoginResponse
import com.example.propertymanagementmobileapp.models.SignInBody
import com.example.propertymanagementmobileapp.data.network.MyApi
import com.example.propertymanagementmobileapp.ui.activities.HomeActivity
import com.example.propertymanagementmobileapp.util.toast
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity(), AuthListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)

        binding.viewmodel = viewModel

        viewModel.authListener = this

        //init()

    }

    private fun init() {

    }

    override fun onStarted() {
        toast("Login Started")
    }

    override fun onSuccess(loginResponse: LiveData<String>) {
        loginResponse.observe(this, Observer {
            toast(it)
            startActivity(Intent(this@LoginActivity,HomeActivity::class.java))
        })

    }

    override fun onFailure(message: String) {
        toast(message)
    }
}