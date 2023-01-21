package com.example.apidogexample.view.dogscreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier

@Composable
fun DogScreen(dogsViewModel: DogsViewModel) {
    val dogs: List<String> by dogsViewModel.dogList.observeAsState(emptyList())
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(dogs) { dog ->
            DogImage(dog = dog)
        }
    }
}