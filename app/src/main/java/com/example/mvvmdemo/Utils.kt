package com.example.mvvmdemo

import android.content.Context
import android.util.Log
import android.widget.Toast

fun Context.toast(message:String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}


fun Context.d(message:String){
    Log.d("abc", message)
}