package com.example.random_generator_json

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api: RandomApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://csrng.net")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RandomApi::class.java)
    }
}