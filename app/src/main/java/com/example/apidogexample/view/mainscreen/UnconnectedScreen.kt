package com.example.apidogexample.view.mainscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.apidogexample.R

@Composable
fun UnconnectedScreen() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(id = R.drawable.unconnected_img),
            contentDescription = "Unconnected icon",
            modifier = Modifier.size(72.dp)
        )
        Spacer(modifier = Modifier.size(12.dp))
        Text(text = "Sin Conexión", fontSize = 24.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun UnconnectedPrev() {
    UnconnectedScreen()
}