package com.example.apidogexample.domain

import com.google.gson.annotations.SerializedName

data class DogResponse(
    var status: String,
    @SerializedName("message")
    var images: List<String>
)