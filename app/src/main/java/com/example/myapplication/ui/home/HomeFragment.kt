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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.security.MessageDigest

class HomeFragment : Fragment(), CharacterClickListener {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    //Quando Clicar em Um CardView Deve Abrir o Intent dos Detalhes
    override fun onClick(character: Character) {
        val intent = Intent(context,DetailActivity::class.java)
        startActivity(intent)
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
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = binding.ola
        val meuContexto = this.context
        val home = this
        val marvelRetroFitService = MarvelRetroFitService()

//Implementação API MARVEL

        fun String.md5(): String {
            val bytes = MessageDigest.getInstance("MD5").digest(this.toByteArray())
            return bytes.joinToString("") { "%02x".format(it) }
        }

        val ts = System.currentTimeMillis() / 1000
        val apiKey = "4175da63a56bfb94ea924a591a50c0e1"
        val privateKey = "938fdde7049dbff0a97bee8332937787036be2a8"
        val hash = (ts.toString() + privateKey + apiKey).md5()

        val call = marvelRetroFitService.service.getCharacters(apiKey, hash, ts)
        call.enqueue(object : Callback<MarvelResponse> {
            override fun onResponse(call: Call<MarvelResponse>, response: Response<MarvelResponse>) {
                if (response.isSuccessful) {
                    charList = response.body()?.data?.results as MutableList<Character>
                    if (charList != null) {
                        for (character in charList) {
                            val name = character.name
                            val description = character.description
                            val imageUrl = character.thumbnail.path + "." + character.thumbnail.extension
                            //faça o que precisar com as informações dos personagens
                            //val characters = response.body()?.data?.results
                            //viewModel.liveList.value = characters

                        }
                    }
                }
            }

            override fun onFailure(call: Call<MarvelResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })



        val livedata = viewModel.liveList

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



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}