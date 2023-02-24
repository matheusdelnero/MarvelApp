package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.CardCharacterHomeBinding

class CardAdapter(private val characters: List<Character>,private val clickListener: CharacterClickListener):
    RecyclerView.Adapter<CardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = CardCharacterHomeBinding.inflate(from,parent,false)
        return CardViewHolder(binding,clickListener)
    }

    override fun getItemCount() = characters.size

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bindChar(characters[position])
    }

    private var heroes = mutableListOf<Character>()
    fun setCharList(chars: List<Character>) {
        this.heroes = chars.toMutableList()
        notifyDataSetChanged()

    }


}