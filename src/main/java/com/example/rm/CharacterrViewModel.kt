package com.example.rm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class CharacterViewModel : ViewModel() {
    private val apiService = RetrofitClient.createService()
    val characterData = MutableLiveData<CharacterResponse>()

    fun APIquery() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiService.getResponse()
                withContext(Dispatchers.Main) {
                    characterData.postValue(response)
                }
            } catch (ex : Exception) { }
        }
    }
}