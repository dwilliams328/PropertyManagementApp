package com.example.propertymanagementmobileapp.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.propertymanagementmobileapp.R
import com.example.propertymanagementmobileapp.models.RegisterBody
import com.example.propertymanagementmobileapp.models.RegisterResponse
import com.example.propertymanagementmobileapp.data.network.MyApi
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.edit_text_email
import kotlinx.android.synthetic.main.activity_login.edit_text_password
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        init()

    }

    private fun init() {
        button_register.setOnClickListener {
            var type = edit_text_type.text.toString()
            var name = edit_text_name.text.toString()
            var email = edit_text_email.text.toString()
            var password = edit_text_password.text.toString()

            var registerBody = RegisterBody(type = type, name = name, email = email, password = password)

            var api = MyApi()
            api.registerUser(registerBody).enqueue(object : Callback<RegisterResponse> {
                override fun onResponse(
                    call: Call<RegisterResponse>,
                    response: Response<RegisterResponse>
                ) {
                    Log.d("abc", response.message())

                    if (response.code() == 200){
                        Toast.makeText(applicationContext,"Successfully Registered", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                    }
                    else{
                        Toast.makeText(applicationContext,"Error Registering User", Toast.LENGTH_SHORT).show()
                    }

                }

                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    Toast.makeText(applicationContext,t.message, Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}