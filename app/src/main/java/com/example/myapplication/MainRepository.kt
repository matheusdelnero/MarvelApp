package com.example.myapplication

class MainRepository constructor(private val retroFitService: RetroFitService){

    fun getAllChars() = retroFitService.getAllChars()
}