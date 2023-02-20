package com.example.myapplication

var charList = mutableListOf<Character>()

var favoriteList = mutableListOf<Character>()

val CHAR_ID_EXTRA = "charExtra"

data class Character (
        val id: Int,
        val name: String,
        val description: String,
        val imageUrl: Int
)
