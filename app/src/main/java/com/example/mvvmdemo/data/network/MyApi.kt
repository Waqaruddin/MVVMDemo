package com.example.mvvmdemo.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyApi {

    @FormUrlEncoded
    @POST("auth/login")
    fun login(){
        @Field("email") email:String

    }

    companion object {
        operator fun invoke():MyApi{
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Config)
                .build()
                .create(MyApi::class.java)
        }
    }
}