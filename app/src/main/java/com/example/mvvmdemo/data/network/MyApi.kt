package com.example.mvvmdemo.data.network

import com.example.mvvmdemo.app.Config
import com.example.mvvmdemo.data.model.User
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyApi {

    @FormUrlEncoded
    @POST("auth/login")
    fun login(
    @Field("email") email:String,
    @Field("password") password:String
    ): Call<ResponseBody>

//    @FormUrlEncoded
//    @POST("auth/login")
//    fun login(
//        @Body user:User
//    ): Call<ResponseBody>


    companion object {
        operator fun invoke():MyApi{
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Config.BASE_URL)
                .build()
                .create(MyApi::class.java)
        }
    }
}