package com.example.propertymanagementmobileapp.network

import com.example.propertymanagementmobileapp.app.Config
import com.example.propertymanagementmobileapp.app.Endpoints
import com.example.propertymanagementmobileapp.models.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MyApi {

    @GET("users")
    fun getUsers(): Call<UsersResponse>

    @POST("auth/register")
    fun registerUser(@Body info: RegisterBody): Call<RegisterResponse>

    @POST("auth/login")
    fun loginUser(@Body info: SignInBody): Call<LoginResponse>


    companion object{
        operator fun invoke(): MyApi{
            return Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}