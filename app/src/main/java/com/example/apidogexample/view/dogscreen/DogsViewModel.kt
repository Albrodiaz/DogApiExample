package com.example.apidogexample.view.dogscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apidogexample.repository.DogClient
import kotlinx.coroutines.launch

class DogsViewModel: ViewModel() {

    private val _dogList = MutableLiveData<List<String>>(emptyList())
    val dogList: LiveData<List<String>> get() = _dogList

    private val _errorEnabled = MutableLiveData<Boolean>(false)
    val errorEnabled: LiveData<Boolean> get() = _errorEnabled

    fun searchByName(query: String) {
        viewModelScope.launch {
            val call = DogClient.service.getDogsByBreed("$query/images")
            val dogs = call.body()
            if (call.isSuccessful) {
                _dogList.value = dogs?.images
            } else {
                _errorEnabled.value = true
            }
        }
    }
}