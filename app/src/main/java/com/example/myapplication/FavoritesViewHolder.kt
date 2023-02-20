package com.example.myapplication

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.CardCharacterHomeBinding

class FavoritesViewHolder(private val cardCharacterHomeBinding: CardCharacterHomeBinding) : RecyclerView.ViewHolder(cardCharacterHomeBinding.root) {


fun bindChar(char: Character){
    cardCharacterHomeBinding.cardImageView.setImageResource(char.imageUrl)
    cardCharacterHomeBinding.cardTextView.text = char.name

}}