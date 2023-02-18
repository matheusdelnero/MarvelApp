package com.example.myapplication

import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.CardCharacterHomeBinding

class CardViewHolder(private val cardCharacterHomeBinding: CardCharacterHomeBinding,private val clickListener: CharacterClickListener): RecyclerView.ViewHolder(cardCharacterHomeBinding.root) {




    fun bindChar(char: Character){
        cardCharacterHomeBinding.cardImageView.setImageResource(char.imageUrl)
        cardCharacterHomeBinding.cardTextView.text = char.name

        cardCharacterHomeBinding.card.setOnClickListener{
            clickListener.onClick(char)
        }
    }
}