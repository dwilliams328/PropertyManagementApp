package com.example.propertymanagementmobileapp.data.network.responses

import com.example.propertymanagementmobileapp.models.UsersResponse

data class AuthResponse(
    val isSuccessful : Boolean?,
    val message: String?,
    val userResponse: UsersResponse?
)