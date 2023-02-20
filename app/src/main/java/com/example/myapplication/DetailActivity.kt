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
        setContentView(R.layout.activity_detail)

        val charID = intent.getIntExtra(CHAR_ID_EXTRA, -1)
        val char = charFomID(charID)
        if (char != null)
        {
            binding.detailsImageView.setImageResource(char.imageUrl)
            binding.detailsTextView1.text = char.name
            binding.detailsTextView2.text = char.description
            binding.favoriteButton.setOnClickListener{favoriteList.add(char)}
        }




    }

    private fun charFomID(charID: Int): Character? {
        for (char in charList) {
            if (char.id == charID)
                return char
        }
        return null
    }
}