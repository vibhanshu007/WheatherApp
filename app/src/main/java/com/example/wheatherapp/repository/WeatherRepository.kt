package com.example.wheatherapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.wheatherapp.network.RetrofitUtil
import com.example.wheatherapp.utils.ConstantUtils
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepository {

    fun getWeatherData(id: String, appid: String): LiveData<String> {

        val dataResponse = MutableLiveData<String>()

        RetrofitUtil.GetApiService.getApiService()
            ?.getWeather(ConstantUtils.ID, ConstantUtils.APP_ID)
            ?.enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    dataResponse.value = t.message
                }

                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if (response.isSuccessful) {
                        dataResponse.value = response.body()?.string()
                    } else {
                        dataResponse.value = response.errorBody()?.string()
                    }
                }

            })
        return dataResponse
    }
}