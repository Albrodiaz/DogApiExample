package com.example.apidogexample.view.mainscreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.apidogexample.view.dogscreen.DogScreen
import com.example.apidogexample.view.dogscreen.DogsViewModel

@Composable
fun MainScreen(dogsViewModel: DogsViewModel) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBar() },
        content = { DogScreen(dogsViewModel = dogsViewModel) }
    )
}

@Composable
fun TopBar() {
    TopAppBar(title = { Text(text = "Dogs") })
}