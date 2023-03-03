package com.example.myapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MarvelRetroFitService {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://gateway.marvel.com/v1/public/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(MarvelApi::class.java)
}