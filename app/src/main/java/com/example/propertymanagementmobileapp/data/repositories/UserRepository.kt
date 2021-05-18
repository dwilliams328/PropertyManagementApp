package com.example.propertymanagementmobileapp.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.propertymanagementmobileapp.data.network.MyApi
import com.example.propertymanagementmobileapp.models.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {

    fun userLogin(email: String, password: String) : LiveData<String> {

        val loginResponse = MutableLiveData<String>()

        MyApi().loginUser(email,password).enqueue(object: Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if(response.isSuccessful){
                    loginResponse.value = response.body()?.toString()
                    Log.d("abc","Login Success")
                }
                else{
                    loginResponse.value = response.errorBody()?.toString()
                    Log.d("abc","Login Error")
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                loginResponse.value = t.message
            }
        })

        return loginResponse

    }

}