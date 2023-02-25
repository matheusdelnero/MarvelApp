package com.example.myapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.Character
import com.example.myapplication.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel constructor(private val repository: MainRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    val liveList = MutableLiveData<List<Character>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllChars(){
        val request = repository.getAllChars()
        request.enqueue(object : Callback<List<Character>>{
            override fun onResponse(call: Call<List<Character>>, response: Response<List<Character>>) {
                liveList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Character>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })

    }

}