package com.example.myapplication

import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.CardCharacterFavoritesBinding

class CardViewHolderDetails(private val cardCharacterFavoritesBinding: CardCharacterFavoritesBinding): RecyclerView.ViewHolder(cardCharacterFavoritesBinding.root) {




    fun bindChar(char: Character){
        cardCharacterFavoritesBinding.cardImageView.setImageResource(char.thumbnail)
        cardCharacterFavoritesBinding.cardTextView.text = char.name


    }
}