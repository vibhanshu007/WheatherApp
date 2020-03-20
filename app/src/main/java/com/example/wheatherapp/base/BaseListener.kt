package com.example.wheatherapp.base

import com.example.wheatherapp.model.DataResponse
import retrofit2.Response

interface BaseListener {
    fun onStarted()
    fun onSuccess(dataResponse: DataResponse)
    fun onFailure(message: String)
}