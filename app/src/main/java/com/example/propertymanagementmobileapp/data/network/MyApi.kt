package com.example.propertymanagementmobileapp.data.network

import com.example.propertymanagementmobileapp.app.Config
import com.example.propertymanagementmobileapp.models.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface MyApi {

    @GET("users")
    fun getUsers(): Call<UsersResponse>

    @POST("auth/register")
    fun registerUser(@Field("name") name: String,
                     @Field("type") type: String,
                     @Field("email") email: String,
                     @Field("password") password: String): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("auth/login")
    fun loginUser(@Field("email") email: String,
                  @Field("password") password: String): Call<LoginResponse>


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