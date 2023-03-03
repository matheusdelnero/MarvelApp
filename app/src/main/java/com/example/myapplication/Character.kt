package com.example.myapplication

var charList = mutableListOf<Character>()

var favoriteList = mutableListOf<Character>()

const val CHAR_ID_EXTRA = "charExtra"



data class MarvelResponse(
        val data: Data
)

data class Data(
        val results: List<Character>
)

data class Character(
        val name: String,
        val description: String,
        val thumbnail: Thumbnail,
        val id: Int
)

data class Thumbnail(
        val path: String,
        val extension: String
)
