package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {
    @GET("characters")
    fun getCharacters(
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("ts") ts: Long
    ): Call<MarvelResponse>
}