package com.example.fitness_app.core

import com.example.fitness_app.data.API.APIService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://fitnessapp.somee.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api:APIService by lazy {
        retrofit.create(APIService::class.java)
    }
}