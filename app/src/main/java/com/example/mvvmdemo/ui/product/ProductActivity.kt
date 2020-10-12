package com.example.mvvmdemo.ui.product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmdemo.R
import com.example.mvvmdemo.data.repositories.UserRepository

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        UserRepository().getProducts()
    }
}