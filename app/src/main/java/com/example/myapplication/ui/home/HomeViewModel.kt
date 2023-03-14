package com.example.myapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.security.MessageDigest

class HomeViewModel constructor(private val repository: MainRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    var liveList = MutableLiveData<List<Character>>()
    val errorMessage = MutableLiveData<String>()
    val marvelRetroFitService = MarvelRetroFitService()




    suspend fun getHeroes(){
        fun String.md5(): String {
            val bytes = MessageDigest.getInstance("MD5").digest(this.toByteArray())
            return bytes.joinToString("") { "%02x".format(it) }
        }

        val ts = System.currentTimeMillis() / 1000
        val apiKey = "4175da63a56bfb94ea924a591a50c0e1"
        val privateKey = "938fdde7049dbff0a97bee8332937787036be2a8"
        val hash = (ts.toString() + privateKey + apiKey).md5()


        val call = repository.getAllChars().getCharacters(apiKey, hash, ts)
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
        })}

    //fun getAllChars(){
    //    val request = repository.getAllChars()
    //    request.enqueue(object : Callback<List<Character>>{
     //       override fun onResponse(call: Call<List<Character>>, response: Response<List<Character>>) {
      //          liveList.postValue(response.body())
      //      }

       //     override fun onFailure(call: Call<List<Character>>, t: Throwable) {
       //         errorMessage.postValue(t.message)
       //     }

     //   })
//
  //  }

}