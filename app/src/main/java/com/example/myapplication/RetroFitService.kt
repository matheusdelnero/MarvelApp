package com.example.myapplication

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetroFitService {

    @GET("v1/public/characters")
    fun getAllChars(): Call<List<Character>>

    companion object {
        private val  retroFitService: RetroFitService by lazy {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://gateway.marvel.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(RetroFitService::class.java)
        }

        fun getInstance(): RetroFitService{
            return retroFitService
        }
    }


}