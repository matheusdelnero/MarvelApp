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
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class HomeFragment : Fragment(), CharacterClickListener {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    //Quando Clicar em Um CardView Deve Abrir o Intent dos Detalhes
    override fun onClick(character: Character) {
        val intent = Intent(context,DetailActivity::class.java)
        startActivity(intent)
    }

    lateinit var viewModel : HomeViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        viewModel = ViewModelProvider(this,HomeViewModelFactory(MainRepository(MarvelRetroFitService()))).get()
        HomeViewModel::class.java
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = binding.ola
        val meuContexto = this.context
        val home = this
        val marvelRetroFitService = MarvelRetroFitService()




runBlocking {launch {   viewModel.getHeroes() }}





        val livelist = viewModel.liveList
        //Aplicando Adapter e Layout do RecyclerView
        recyclerView.apply {
            layoutManager = GridLayoutManager(meuContexto,2)
            adapter = CardAdapter(charList,home )
        }


        //Observando LiveDatas
        viewModel.liveList.observe(viewLifecycleOwner, Observer { chars ->
            Log.i("ola","tchau")
            val adapter = CardAdapter(charList,home )
            adapter.setCharList(chars)

        })
        viewModel.errorMessage.observe(viewLifecycleOwner, Observer { message ->
            Toast.makeText(meuContexto,message,Toast.LENGTH_SHORT).show()
        })
        
    }
}