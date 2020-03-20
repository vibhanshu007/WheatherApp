package com.example.wheatherapp.repository

import com.example.wheatherapp.model.DataResponse
import com.example.wheatherapp.network.ApiUtil
import com.example.wheatherapp.network.RetrofitUtil
import com.example.wheatherapp.utils.ConstantUtils
import retrofit2.Response

class WeatherRepository : ApiUtil(){

    suspend fun getWeatherData(id: String, appid: String): DataResponse {

        return apiRequest{RetrofitUtil.GetApiService.getApiService().getWeather(ConstantUtils.ID, ConstantUtils.APP_ID)}

    }
}