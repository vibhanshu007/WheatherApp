package com.example.wheatherapp.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitUtil {

    object RetrofitClient {

        private const val BASE_URL = "http://api.openweathermap.org/data/2.5/"
        private var retrofit: Retrofit? = null

        fun getClient(): Retrofit? {

            if (retrofit == null) {

                retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL).build()
            }
            return retrofit
        }
    }

    object GetApiService {
        fun getApiService(): ApiInterface? =
            RetrofitClient.getClient()!!.create(ApiInterface::class.java)
    }
}