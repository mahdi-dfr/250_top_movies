package com.example.filmnegar.view.features.home.widgets

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.filmnegar.model.data.Movie
import com.example.filmnegar.utils.imageFakeUrl
import com.example.filmnegar.view.theme.myFontFamily

@Composable
fun MovieItem(
    movie: Movie,
    onMovieClicked: () -> Unit
) {
    Log.i("TAG", "MovieItemmmm: " + movie)
    Card(
        modifier = Modifier
            .width(130.dp)
            .height(230.dp)
            .clickable { onMovieClicked.invoke() }
            .padding(horizontal = 4.dp, vertical = 8.dp),
        shape = RoundedCornerShape(15.dp)
    ) {
        Box {
            AsyncImage(
                model = imageFakeUrl,
                contentDescription = "",
                contentScale = ContentScale.Crop,
            )

            Box {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black
                                ),
                                startY = 200f
                            )
                        )
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        Column {
                            Text(
                                text = movie.originalName + " " + movie.year,
                                fontFamily = myFontFamily,
                                fontWeight = FontWeight.Bold,
                                fontSize = 17.sp,
                                color = Color.White
                            )

                        }
                    }
                }
            }

        }


    }
}