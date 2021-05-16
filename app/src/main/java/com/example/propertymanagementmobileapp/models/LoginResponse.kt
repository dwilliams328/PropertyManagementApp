package com.example.propertymanagementmobileapp.models

data class LoginResponse(
    val token: String,
    val user: LoginUser
)

data class LoginUser(
    val __v: Int,
    val _id: String,
    val createdAt: String,
    val email: String,
    val name: String,
    val password: String,
    val type: String
)