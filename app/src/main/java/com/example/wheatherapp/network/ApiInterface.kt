package com.example.wheatherapp.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiInterface {

    @GET("weather")
    fun getWeather(
        @Query("id") id: String,
        @Query("appid") appid: String?
    ): Call<ResponseBody>

}