package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.CardCharacterHomeBinding

class FavoriteAdapter(private val charList: List<Character>): RecyclerView.Adapter<FavoritesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = CardCharacterHomeBinding.inflate(from,parent,false)
        return FavoritesViewHolder(binding)
    }

    override fun getItemCount() = favoriteList.size

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        holder.itemView.apply {
            holder.bindChar(favoriteList[position])
            }
        }
    }


