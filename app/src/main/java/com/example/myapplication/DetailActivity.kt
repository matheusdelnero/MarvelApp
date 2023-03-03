package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.myapplication.databinding.ActivityDetailBinding
import com.example.myapplication.ui.home.HomeViewModel

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val charID = intent.getIntExtra(CHAR_ID_EXTRA, -1)
        val char = charFromID(charID)
        //ou val char = iterateLiveData(charID)
        if (char != null)
        {
            Glide.with(this)
                .load(char.thumbnail.path)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.detailsImageView)




            binding.detailsTextView1.text = char.name
            binding.detailsTextView2.text = char.description
            binding.favoriteButton.setOnClickListener {
                favoriteList.add(char)
                Toast.makeText(this,"Personagem adicionado aos Favoritos.",Toast.LENGTH_SHORT).show()
                binding.favoriteButton.visibility = View.GONE

            }



            //binding.favoriteButton.setOnCheckedChangeListener { checkbox, isChecked ->
            //    if (isChecked) {
            //        favoriteList.add(char)
            //        Toast.makeText(this,"Personagem adicionado aos Favoritos.",Toast.LENGTH_SHORT).show()
            //    } else {
            //        Toast.makeText(this,"Personagem removido dos Favoritos.",Toast.LENGTH_SHORT).show()
            //        favoriteList.remove(char)
            //    }
            //}

        }

    }

    val viewmodel = HomeViewModel(MainRepository(RetroFitService.getInstance()))
    val liveList = viewmodel.liveList

    private fun charFromID(charID: Int): Character? {
        for (char in charList) {
            if (char.id == charID)
                return char
        }
        return null
    }

    fun iterateLiveData(charID: Int): Character? {
        val characters = liveList.value
        characters?.forEach { character ->
            if (character.id == charID)
                return character
        }
        return null
        }
    }