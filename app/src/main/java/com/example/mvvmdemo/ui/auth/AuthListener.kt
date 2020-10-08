package com.example.mvvmdemo.ui.auth

interface AuthListener {

    fun onStarted()
    fun onSuccess()
    fun failure(message:String)
}