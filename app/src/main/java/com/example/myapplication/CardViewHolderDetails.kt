package com.example.myapplication

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.CardCharacterFavoritesBinding

class CardViewHolderDetails(private val cardCharacterFavoritesBinding: CardCharacterFavoritesBinding): RecyclerView.ViewHolder(cardCharacterFavoritesBinding.root) {

    val details = DetailActivity()



    fun bindChar(char: Character){
        //Glide.with(details)
        //    .load(char.thumbnail.path)
        //    .into(cardCharacterFavoritesBinding.cardImageView)
        cardCharacterFavoritesBinding.cardTextView.text = char.name



    }
}