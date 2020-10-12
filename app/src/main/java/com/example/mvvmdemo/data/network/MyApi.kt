package com.example.mvvmdemo.data.network

import com.example.mvvmdemo.app.Config
import com.example.mvvmdemo.data.model.ProductResponse
import com.example.mvvmdemo.data.model.User
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

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

    @FormUrlEncoded
    @POST("auth/register")
    fun register(
        @Field("name") name:String,
        @Field("email") email:String,
        @Field("password") password:String,
        @Field("type") type:String
    ):Call<ResponseBody>

    @GET("products")
    fun getProducts(): Single<ProductResponse>


    companion object {
        operator fun invoke():MyApi{
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://grocery-second-app.herokuapp.com/api/")
                .build()
                .create(MyApi::class.java)
        }
    }
}