package com.example.wheatherapp.repository

import com.example.wheatherapp.model.DataResponse
import com.example.wheatherapp.network.RetrofitUtil
import com.example.wheatherapp.utils.ConstantUtils
import retrofit2.Response

class WeatherRepository {

    suspend fun getWeatherData(id: String, appid: String): Response<DataResponse>? {

        return RetrofitUtil.GetApiService.getApiService()
            ?.getWeather(ConstantUtils.ID, ConstantUtils.APP_ID)

    }
}