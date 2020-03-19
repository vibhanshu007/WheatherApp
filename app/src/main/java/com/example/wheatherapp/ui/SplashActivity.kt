package com.example.wheatherapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.wheatherapp.R
import com.example.wheatherapp.base.BaseListener
import com.example.wheatherapp.databinding.ActivitySplashBinding
import com.example.wheatherapp.model.DataResponse
import com.example.wheatherapp.utils.hide
import com.example.wheatherapp.utils.log
import com.example.wheatherapp.utils.show
import com.example.wheatherapp.utils.toast
import com.example.wheatherapp.viewmodel.WeatherViewModel
import kotlinx.android.synthetic.main.activity_splash.*
import retrofit2.Response


class SplashActivity : AppCompatActivity(), BaseListener {

    private val tag: String = SplashActivity::class.java.simpleName
    private lateinit var activitySplashBinding: ActivitySplashBinding
    private var weatherViewModel: WeatherViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySplashBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        weatherViewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)
        activitySplashBinding.weatherViewModel = weatherViewModel
        weatherViewModel!!.baseListener = this
        weatherViewModel!!.getWeather()
    }

    override fun onStarted() {
        progressBar.show()
        log(tag, "started")
    }

    override fun onFailure(message: String) {
        progressBar.hide()
        toast(message)
        log(tag, message)
    }

    override fun onSuccess(weatherResponse: Response<DataResponse>?) {
        toast(weatherResponse?.message())
        log(tag, "success")
    }

}
