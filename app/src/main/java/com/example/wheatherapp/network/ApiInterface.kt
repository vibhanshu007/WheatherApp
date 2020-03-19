package com.example.wheatherapp.network

import android.provider.ContactsContract
import com.example.wheatherapp.model.DataResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiInterface {

    @GET("weather")
    suspend fun getWeather(
        @Query("id") id: String,
        @Query("appid") appid: String?
    ): Response<DataResponse>

}