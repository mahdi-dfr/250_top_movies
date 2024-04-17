package com.example.filmnegar.view.features.home.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.filmnegar.view.theme.myFontFamily

@Composable
fun ImageCard(
    url: String,
    title: String,
    imdb: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
    ) {
        Box {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                model = url,
                contentDescription = null,
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
            ) {

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ) {

                    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = title,
                            fontSize = 24.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = imdb,
                                fontSize = 14.sp,
                                color = Color.White,
                                textAlign = TextAlign.Center,
                                fontFamily = myFontFamily,)

                            Spacer(modifier = Modifier.width(4.dp))

                            Text(text = "IMDB",
                                fontSize = 14.sp,
                                color = Color.White,
                                textAlign = TextAlign.Center,
                                fontFamily = myFontFamily,)

                            Spacer(modifier = Modifier.width(4.dp))

                            Icon(Icons.Filled.Star, tint = Color.Yellow, contentDescription = "", modifier = Modifier.size(20.dp))
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                    }

                }

            }
        }
    }
}