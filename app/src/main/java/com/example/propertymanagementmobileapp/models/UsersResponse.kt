package com.example.propertymanagementmobileapp.models

data class UsersResponse(
    val count: Int,
    val data: ArrayList<User>,
    val error: Boolean
)

data class User(
    val __v: Int,
    val _id: String,
    val createdAt: String,
    val email: String,
    val name: String,
    val password: String,
    val type: String
)