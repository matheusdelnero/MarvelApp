package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val charID = intent.getIntExtra(CHAR_ID_EXTRA, -1)
        val char = charFromID(charID)
        if (char != null)
        {
            binding.detailsImageView.setImageResource(char.imageUrl)
            binding.detailsTextView1.text = char.name
            binding.detailsTextView2.text = char.description
            binding.favoriteButton.setOnCheckedChangeListener { checkbox, isChecked ->
                if (isChecked) {
                    favoriteList.add(char)
                    Toast.makeText(this,"Personagem adicionado aos Favoritos.",Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this,"Personagem removido dos Favoritos.",Toast.LENGTH_SHORT).show()
                    favoriteList.remove(char)
                }
            }

        }

    }


    private fun charFromID(charID: Int): Character? {
        for (char in charList) {
            if (char.id == charID)
                return char
        }
        return null
    }
}