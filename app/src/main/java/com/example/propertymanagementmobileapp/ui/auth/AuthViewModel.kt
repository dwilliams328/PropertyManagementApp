package com.example.propertymanagementmobileapp.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.propertymanagementmobileapp.data.repositories.UserRepository

class AuthViewModel: ViewModel(){
    var email: String? = null
    var password: String? = null
    var name: String? = null
    var type: String? = null
    var landlordEmail: String? = null

    var authListener: AuthListener? = null

    fun onLoginButtonClick(view: View){
//        authListener?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            //fail
            authListener?.onFailure("Invalid email or password")
            return
        }

        //success
        val loginResponse = UserRepository().userLogin(email!!,password!!)
        authListener?.onSuccess(loginResponse)
    }

    fun onRegisterButtonClick(view: View){

        if(landlordEmail.isNullOrEmpty() || email.isNullOrEmpty()|| password.isNullOrEmpty() || name.isNullOrEmpty() || type.isNullOrEmpty()){
            //fail
            authListener?.onFailure("Invalid Credentials")
            return
        }

        //success
        val registerResponse = UserRepository().userRegister(name!!, type!!, email!!,password!!,landlordEmail!!)
        authListener?.onSuccess(registerResponse)
    }
}