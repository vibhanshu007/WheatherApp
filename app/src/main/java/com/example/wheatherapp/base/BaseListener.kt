package com.example.wheatherapp.base

import androidx.lifecycle.LiveData

interface BaseListener {
    fun onStarted()
    fun onSuccess(weatherResponse: LiveData<String>)
    fun onFailure(message: String)
}