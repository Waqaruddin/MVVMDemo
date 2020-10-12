package com.example.mvvmdemo.ui.product

import androidx.lifecycle.LiveData
import com.example.mvvmdemo.data.model.Product

interface ProductListener {

    fun onStarted()
    fun onSuccess(response:LiveData<List<Product>>)
    fun onFailure(message:String)
}