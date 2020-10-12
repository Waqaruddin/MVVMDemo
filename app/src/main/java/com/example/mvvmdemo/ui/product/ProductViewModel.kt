package com.example.mvvmdemo.ui.product

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvmdemo.data.repositories.UserRepository

class ProductViewModel:ViewModel(){

    var productName:String? = null

    var productListener:ProductListener? = null

    fun onGetProductClicked(view: View){

        var productResponse = UserRepository().getProducts()
        productListener?.onSuccess(productResponse)
    }
}