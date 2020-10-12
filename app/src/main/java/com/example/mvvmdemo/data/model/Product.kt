package com.example.mvvmdemo.data.model

data class Product(
    var id:String,
    var productName:String
)

data class ProductResponse(
   var data:List<Product>
)