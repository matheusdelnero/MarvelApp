package com.example.myapplication

class MainRepository constructor(private val marvelRetroFitService: MarvelRetroFitService){

    fun getAllChars() = marvelRetroFitService.service
}