package com.example.mvvmdemo.ui.product

import androidx.lifecycle.LiveData

interface ProductListener {

    fun onStarted()
    fun onSuccess(response:List<String>)
    fun onFailure(message:String)
}