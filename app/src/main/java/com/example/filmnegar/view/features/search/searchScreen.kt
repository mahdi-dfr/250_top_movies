package com.example.filmnegar.view.features.search

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.filmnegar.view.theme.Shapes

@Composable
fun SearchScreen() {
    var searchText by rememberSaveable {
        mutableStateOf("")

    }
    Box() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center

            ) {
            OutlinedTextField(
                textStyle = TextStyle(color = Color.White),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                label = { Text("جستجو") },
                value = searchText,
                singleLine = true,
                onValueChange = {searchText = it},
                placeholder = { Text("جستجو") },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 12.dp),
                shape = Shapes.medium,
                leadingIcon = { Icon(imageVector = Icons.Filled.Search, null) }
            )

            Spacer(modifier = Modifier.width(8.dp))

            Icon(imageVector = Icons.Filled.Menu, contentDescription = "", )

        }

    }

}