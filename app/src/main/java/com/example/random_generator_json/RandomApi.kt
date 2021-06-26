package com.example.random_generator_json

import retrofit2.Response
import retrofit2.http.GET

interface RandomApi {
    @GET("/csrng/csrng.php")
    suspend fun getRandomNumber(): Response<List<RandomNumberItem>>

}