package com.example.myapplication.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.*
import com.example.myapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), CharacterClickListener {

    private var _binding: FragmentHomeBinding? = null
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
        charList.add(char5)

    }

    lateinit var viewModel : HomeViewModel
    private val retrofitService = RetroFitService.getInstance()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        viewModel = ViewModelProvider(this,HomeViewModelFactory(MainRepository(retrofitService))).get()
        HomeViewModel::class.java


        populateCharacters()

        return root
    }

    override fun onStart() {
        super.onStart()
        val recyclerView: RecyclerView = binding.ola
        val meuContexto = this.context
        val home = this


        //Aplicando Adapter e Layout do RecyclerView
        recyclerView.apply {
            layoutManager = GridLayoutManager(meuContexto,2)
            adapter = CardAdapter(charList,home )
        }


        //Observando LiveDatas
        viewModel.liveList.observe(this, Observer { chars ->
            Log.i("ola","tchau")
            val adapter = CardAdapter(charList,home )
            adapter.setCharList(chars)

        })
        viewModel.errorMessage.observe(this, Observer { message ->
            Toast.makeText(meuContexto,message,Toast.LENGTH_SHORT).show()
        })
    }

    override fun onResume() {
        super.onResume()
        //viewModel.getAllChars()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}