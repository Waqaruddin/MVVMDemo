package com.example.mvvmdemo.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmdemo.data.network.MyApi
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
}