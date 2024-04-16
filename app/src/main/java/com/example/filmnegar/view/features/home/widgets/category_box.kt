package com.example.filmnegar.view.features.home.widgets

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.filmnegar.model.data.Movie

@Composable
fun CategoryBox(
     boxTitle: String,
     movies: List<Movie>
) {
    Box(
        modifier = Modifier
            //.border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(15.dp))
            .padding(vertical = 24.dp)

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Row (Modifier.clickable { }){
                    Icon(imageVector  = Icons.Filled.KeyboardArrowLeft, tint=Color.White, contentDescription = "")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "مشاهده همه",
                        fontSize = 18.sp,
                        color = Color.White
                    )
                }

                Text(
                    text = boxTitle,
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                )

            }

            Spacer(modifier = Modifier.height(20.dp))

            LazyRow(
                modifier = Modifier.padding(top = 16.dp),
                contentPadding = PaddingValues(end = 16.dp)
            ) {
                items(movies.size) {
                    Card(
                        modifier = Modifier
                            .width(170.dp)
                            .height(220.dp)
                            .padding(start = 16.dp)
                            .clickable {  },
                        shape = RoundedCornerShape(15.dp),
                    ) {
                        AsyncImage(
                            model = movies[it].baner,
                            contentDescription = null,
                        )


                    }
                }

            }

        }
    }
}