package com.example.mvvmdemo.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvmdemo.data.repositories.UserRepository

class AuthViewModel:ViewModel(){

    var email:String? = null
    var password:String? = null
    var name:String? = null
    var type:String? = null

    var authListener:AuthListener? = null

    fun onLoginButtonClick(view:View){

        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            authListener?.failure("failure")

            return
        }
        //success
        val loginResponse = UserRepository().login(email!!, password!!)
        authListener?.onSuccess(loginResponse)
    }

    fun onRegisterButtonClick(view:View){
        val registerResponse = UserRepository().register(email!!, password!!, name!!,type!!)
        authListener?.onSuccess(registerResponse)
    }
}