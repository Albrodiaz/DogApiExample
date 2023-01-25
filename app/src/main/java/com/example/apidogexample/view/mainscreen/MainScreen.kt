package com.example.apidogexample.view.mainscreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.apidogexample.view.dogscreen.DogScreen
import com.example.apidogexample.view.dogscreen.DogsViewModel

@Composable
fun MainScreen(dogsViewModel: DogsViewModel) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBar(dogsViewModel) },
        content = { DogScreen(dogsViewModel) }
    )
}

@Composable
fun TopBar(dogsViewModel: DogsViewModel) {
    TopAppBar(title = { Text(text = "Dogs") }, actions = {
        CustomSearchTextField(dogsViewModel = dogsViewModel)
    }, elevation = 12.dp)
}
