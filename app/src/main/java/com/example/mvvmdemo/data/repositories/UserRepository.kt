package com.example.mvvmdemo.data.repositories

import com.example.mvvmdemo.data.network.MyApi

class UserRepository {

    fun login(email:String, password:String){
        MyApi().login(email, password)
            .enqueue()
    }
}