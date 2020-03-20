package com.example.wheatherapp.viewmodel

import com.example.wheatherapp.base.BaseListener
import com.example.wheatherapp.base.BaseViewModel
import com.example.wheatherapp.repository.WeatherRepository
import com.example.wheatherapp.utils.ApiException
import com.example.wheatherapp.utils.ConstantUtils
import com.example.wheatherapp.utils.CoroutineUtil
import com.example.wheatherapp.utils.NoInternetException

class WeatherViewModel : BaseViewModel() {

    var baseListener: BaseListener? = null

    fun getWeather() {

        CoroutineUtil.main {
            try {
                val weatherResponse =
                    WeatherRepository().getWeatherData(ConstantUtils.ID, ConstantUtils.APP_ID)
                weatherResponse.let {
                    baseListener?.onSuccess(it)
                    //weatherResponse.saveUser(it)
                    return@main
                }
                baseListener?.onFailure("Something Went Wrong.")
            } catch (e: ApiException) {
                baseListener?.onFailure(e.message!!)
            } catch (e: NoInternetException) {
                baseListener?.onFailure(e.message!!)
            }
        }

    }
}


