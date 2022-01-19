package com.example.swipable

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class Network {

    companion object{
        val BaseUrl = "https://gist.githubusercontent.com/"
        fun getRetrofitInstance(): Retrofit{
            return Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}