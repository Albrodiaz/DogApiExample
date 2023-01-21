package com.example.apidogexample.repository

import com.example.apidogexample.domain.DogResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface DogService {

    @GET
    suspend fun getDogsByBreed(@Url url: String): Response<DogResponse>
}