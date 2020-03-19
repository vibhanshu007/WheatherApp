package com.example.wheatherapp.viewmodel

import com.example.wheatherapp.base.BaseListener
import com.example.wheatherapp.base.BaseViewModel
import com.example.wheatherapp.repository.WeatherRepository
import com.example.wheatherapp.utils.ConstantUtils

class WeatherViewModel : BaseViewModel() {

    var baseListener: BaseListener? = null

    fun getWeather() {
        val weatherResponse =
            WeatherRepository().getWeatherData(ConstantUtils.ID, ConstantUtils.APP_ID)
        baseListener?.onSuccess(weatherResponse)
    }
}


