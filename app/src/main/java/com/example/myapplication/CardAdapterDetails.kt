package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.CardCharacterFavoritesBinding
import com.example.myapplication.databinding.CardCharacterHomeBinding

class CardAdapterDetails(private val characters: List<Character>): RecyclerView.Adapter<CardViewHolderDetails>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolderDetails {
        val from = LayoutInflater.from(parent.context)
        val binding = CardCharacterFavoritesBinding.inflate(from,parent,false)
        return CardViewHolderDetails(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolderDetails, position: Int) {
        holder.bindChar(characters[position])
    }

    override fun getItemCount() = characters.size




}