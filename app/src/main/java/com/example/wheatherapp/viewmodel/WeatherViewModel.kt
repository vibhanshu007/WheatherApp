package com.example.wheatherapp.viewmodel

import com.example.wheatherapp.base.BaseListener
import com.example.wheatherapp.base.BaseViewModel
import com.example.wheatherapp.repository.WeatherRepository
import com.example.wheatherapp.utils.ConstantUtils
import com.example.wheatherapp.utils.CoroutineUtil

class WeatherViewModel : BaseViewModel() {

    var baseListener: BaseListener? = null

    fun getWeather() {

        CoroutineUtil.main {
            val weatherResponse =
                WeatherRepository().getWeatherData(ConstantUtils.ID, ConstantUtils.APP_ID)
            if (weatherResponse != null) {
                if (weatherResponse.isSuccessful) {
                    baseListener?.onSuccess(weatherResponse)
                }else{
                    baseListener?.onFailure("Error Code : ${weatherResponse.code()}")
                }
            }
        }
    }
}


