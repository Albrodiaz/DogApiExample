package com.example.apidogexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.apidogexample.ui.theme.ApiDogExampleTheme
import com.example.apidogexample.view.dogscreen.DogsViewModel
import com.example.apidogexample.view.mainscreen.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dogViewModel: DogsViewModel by viewModels()

        setContent {
            ApiDogExampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    dogViewModel.searchByName("chihuahua")
                    MainScreen(dogsViewModel = dogViewModel)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ApiDogExampleTheme {

    }
}