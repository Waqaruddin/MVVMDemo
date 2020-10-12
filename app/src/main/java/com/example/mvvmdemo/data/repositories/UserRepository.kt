package com.example.mvvmdemo.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmdemo.data.model.Product
import com.example.mvvmdemo.data.model.ProductResponse
import com.example.mvvmdemo.data.network.MyApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {

    fun login(email: String, password: String):LiveData<String> {

        val loginResponse = MutableLiveData<String>()
        MyApi().login(email, password)
            .enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if (response.isSuccessful) {

                        loginResponse.value = "Login Success"

                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    loginResponse.value = t.message
                }

            })
        return loginResponse
    }
    fun register(email:String, password:String, name:String, type:String):LiveData<String>{

        val registerResponse = MutableLiveData<String>()
        MyApi().register(name , email , password , type)
            .enqueue(object:Callback<ResponseBody>{
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if(response.isSuccessful){
                        registerResponse.value = "Registered Successfully"
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    registerResponse.value = t.message
                }

            })
        return registerResponse
    }

    fun getProducts():LiveData<List<Product>>{

        var productResponse = MutableLiveData<List<Product>>()
        MyApi().getProducts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object:DisposableSingleObserver<ProductResponse>(){
                override fun onSuccess(t: ProductResponse) {
                    Log.d("abc", t.data[0].productName)
                    productResponse.value = t.data
                }

                override fun onError(e: Throwable) {
                    Log.d("abc", e.message!!)
                }

            })
        return productResponse
    }
}