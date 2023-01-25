package com.example.apidogexample.view.mainscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.apidogexample.ui.theme.Shapes
import com.example.apidogexample.ui.theme.TextSearch
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

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomSearchTextField(dogsViewModel: DogsViewModel) {
    val searchText: String by dogsViewModel.searchText.observeAsState("Buscar por raza")
    val searchButtonEnabled: Boolean by dogsViewModel.connected.observeAsState(false)
    val keyboardController = LocalSoftwareKeyboardController.current

    BasicTextField(
        value = searchText,
        modifier = Modifier
            .fillMaxWidth(.65f)
            .height(45.dp)
            .padding(horizontal = 16.dp)
            .onFocusChanged {
                if (!it.isFocused) {
                    dogsViewModel.setSearchText("Buscar por raza")
                } else {
                    dogsViewModel.setSearchText("")
                }
            },
        onValueChange = { dogsViewModel.setSearchText(it) },
        singleLine = true,
        maxLines = 1,
        cursorBrush = SolidColor(Color.Black),
        visualTransformation = VisualTransformation.None,
        decorationBox = { innerTextField ->
            Row(
                Modifier
                    .fillMaxSize()
                    .padding(vertical = 6.dp)
                    .background(TextSearch, RoundedCornerShape(16.dp)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    innerTextField()
                    IconButton(
                        onClick = {
                            dogsViewModel.searchByName()
                            keyboardController?.hide()
                        },
                        enabled = searchButtonEnabled
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Search,
                            contentDescription = "Search dog",
                            tint = Color.Black,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    )
}