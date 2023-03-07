package com.example.myapplication

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.CardCharacterHomeBinding
import com.example.myapplication.ui.home.HomeFragment

class CardViewHolder(private val cardCharacterHomeBinding: CardCharacterHomeBinding,private val clickListener: CharacterClickListener): RecyclerView.ViewHolder(cardCharacterHomeBinding.root) {



    val homeFragment = HomeFragment()

    fun bindChar(char: Character){
        //Glide.with(homeFragment)
        //    .load(char.thumbnail.path + "." + char.thumbnail.extension)
        //    .into(cardCharacterHomeBinding.cardImageView)
        //cardCharacterHomeBinding.cardImageView.setImageResource(char.thumbnail.path)
        cardCharacterHomeBinding.cardTextView.text = char.name

        cardCharacterHomeBinding.card.setOnClickListener{
            clickListener.onClick(char)
        }
    }
}