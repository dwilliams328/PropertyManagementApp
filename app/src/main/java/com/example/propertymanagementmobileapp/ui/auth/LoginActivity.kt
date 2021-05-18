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
        setContentView(R.layout.activity_login)

        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)

        binding.viewmodel = viewModel

        viewModel.authListener = this

        //init()

    }

    private fun init() {
//        button_login.setOnClickListener {
//            var email = edit_text_email.text.toString()
//            var password = edit_text_password.text.toString()
//
//            var signInBody = SignInBody(email = email, password = password)
//
//            var api = MyApi()
//            api.loginUser(signInBody).enqueue(object : Callback<LoginResponse>{
//                override fun onResponse(
//                    call: Call<LoginResponse>,
//                    response: Response<LoginResponse>
//                ) {
//                    Log.d("abc", response.message())
//
//                    if (response.code() == 200){
//                        startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
//                    }
//                    else{
//                        Toast.makeText(applicationContext,"Login Failed", Toast.LENGTH_SHORT).show()
//                    }
//
//                }
//
//                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//                    Toast.makeText(applicationContext,t.message, Toast.LENGTH_LONG).show()
//                }
//            })
//        }
    }

    override fun onStarted() {
        toast("Login Started")
    }

    override fun onSuccess(loginResponse: LiveData<String>) {
        loginResponse.observe(this, Observer {
            toast(it)
        })
    }

    override fun onFailure(message: String) {
        toast(message)
    }
}