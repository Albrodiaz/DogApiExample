package com.example.apidogexample.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DogClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/breed/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: DogService = retrofit.create(DogService::class.java)

}