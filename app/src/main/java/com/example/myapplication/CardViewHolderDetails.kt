package com.example.myapplication

import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.CardCharacterFavoritesBinding
import com.example.myapplication.databinding.CardCharacterHomeBinding

class CardViewHolderDetails(private val cardCharacterFavoritesBinding: CardCharacterFavoritesBinding): RecyclerView.ViewHolder(cardCharacterFavoritesBinding.root) {




    fun bindChar(char: Character){
        cardCharacterFavoritesBinding.cardImageView.setImageResource(char.imageUrl)
        cardCharacterFavoritesBinding.cardTextView.text = char.name


    }
}