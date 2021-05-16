package com.example.propertymanagementmobileapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.propertymanagementmobileapp.R
import com.example.propertymanagementmobileapp.models.LoginResponse
import com.example.propertymanagementmobileapp.models.SignInBody
import com.example.propertymanagementmobileapp.models.UsersResponse
import com.example.propertymanagementmobileapp.network.MyApi
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()

    }

    private fun init() {
        button_login.setOnClickListener {
            var email = edit_text_email.text.toString()
            var password = edit_text_password.text.toString()

            var signInBody = SignInBody(email = email, password = password)

            var api = MyApi()
            api.loginUser(signInBody).enqueue(object : Callback<LoginResponse>{
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    Log.d("abc", response.message())

                    if (response.code() == 200){
                        startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                    }
                    else{
                        Toast.makeText(applicationContext,"Login Failed", Toast.LENGTH_SHORT).show()
                    }

                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(applicationContext,t.message, Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}