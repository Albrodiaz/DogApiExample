package com.example.apidogexample.view.mainscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.apidogexample.ui.theme.Shapes
import com.example.apidogexample.view.dogscreen.DogsViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchText(dogsViewModel: DogsViewModel) {
    val searchText: String by dogsViewModel.searchText.observeAsState("")
    val keyboardController = LocalSoftwareKeyboardController.current
    OutlinedTextField(
        value = searchText,
        onValueChange = { dogsViewModel.setSearchText(it) },
        shape = Shapes.small,
        modifier = Modifier
            .padding(3.dp)
            .background(Color.LightGray),
        placeholder = { Text(text = "Buscar por raza") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            backgroundColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            trailingIconColor = Color.DarkGray
        ),
        trailingIcon = {
            IconButton(onClick = {
                dogsViewModel.searchByName()
                keyboardController?.hide()
            }) {
                Icon(imageVector = Icons.Outlined.Search, contentDescription = "Search dog")
            }
        },
    )
}