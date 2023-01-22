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

    private val _searchText = MutableLiveData("")
    val searchText: LiveData<String> get() = _searchText

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun setSearchText(text: String) {
        _searchText.value = text
    }

    fun searchByName() {
        viewModelScope.launch {
            val query = _searchText.value?.lowercase()
            _isLoading.value = true
            val call = DogClient.service.getDogsByBreed("$query/images")
            val dogs = call.body()
            if (call.isSuccessful) {
                _dogList.value = dogs?.images
            }
            _isLoading.value = false
        }
    }
}