package com.example.myapplication.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.*
import com.example.myapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), CharacterClickListener {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onClick(character: Character) {
        val intent = Intent(context,DetailActivity::class.java)
        intent.putExtra(CHAR_ID_EXTRA,character.id)
        startActivity(intent)
    }

    //Função Popular Lista
    private fun populateCharacters() {
        val char1 = Character(
            1,
            "Homem de Ferro",
            "player numero 1 de vava",
            R.drawable.char2
        )
        charList.add(char1)

        val char2 = Character(
            2,
            "Capitão America",
            "player numero 1 de vava",
            R.drawable.char3,

            )
        charList.add(char2)

        val char3 = Character(

            3,
            "Thor",
            "player numero 1 de vava",
            R.drawable.char3
        )
        charList.add(char3)

        val char4 = Character(
            4,
            "Aspas Final Boss",
            "player numero 1 de vava",
            R.drawable.char3
        )
        charList.add(char4)

        val char5 = Character(
            5,
            "Aspas Final Boss",
            "player numero 1 de vava",
            R.drawable.char3,
        )
        charList.add(char2)
        charList.add(char2)
        charList.add(char2)
        charList.add(char2)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val recyclerView: RecyclerView = binding.ola

        val meuContexto = this.context

        val home = this

        populateCharacters()

        recyclerView.apply {
            layoutManager = GridLayoutManager(meuContexto,2)
            adapter = CardAdapter(charList,home )
        }




        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}