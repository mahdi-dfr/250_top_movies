package com.example.filmnegar.view.features.home.movie

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Colors

import androidx.compose.material3.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.Coil
import coil.compose.AsyncImage
import com.example.filmnegar.utils.MyScreens

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MovieScreen() {
    val scrollState = rememberScrollState()
    val likeIcon = remember { mutableStateOf(false) }

    Column(
        Modifier
            .verticalScroll(scrollState)
            .fillMaxWidth()
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                model = "https://cdn.vox-cdn.com/thumbor/0w5aZu5XweQgRK_Ljoyq9Her8N8=/0x0:1200x800/1200x800/filters:focal(502x21:694x213)/cdn.vox-cdn.com/uploads/chorus_image/image/73167146/Dune2_LegendaryEntertainment_Getty_Ringer.0.jpg",
                contentDescription = null,
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            IconButton(onClick = {
                likeIcon.value = !likeIcon.value
            }) {
                if (likeIcon.value) {
                    Icon(Icons.Filled.Favorite, tint = Color.Red, contentDescription = "")
                } else {
                    Icon(Icons.Default.FavoriteBorder, tint = Color.White, contentDescription = "")
                }
            }

            Column {
                Text(
                    text = "Film Name",
                    color = Color.White,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Right,
                    modifier = Modifier
                        .align(Alignment.End)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "نام فیلم",
                    color = Color.White,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Right,
                    modifier = Modifier
                        .align(Alignment.End)
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
            color = Color.White,
            textAlign = TextAlign.Right,
            modifier = Modifier.padding(
                horizontal = 20.dp
            )
        )


    }
}