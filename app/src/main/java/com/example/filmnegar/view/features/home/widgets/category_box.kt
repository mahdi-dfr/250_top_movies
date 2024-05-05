package com.example.filmnegar.view.features.home.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.filmnegar.model.data.Movie
import com.example.filmnegar.utils.MyScreens
import com.example.filmnegar.view.features.home.movie.MovieViewModel

@Composable
fun CategoryBox(
     boxTitle: String,
     movies: List<Movie>,
     navigator: NavHostController,
     viewModel: MovieViewModel = hiltViewModel()
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
                Row (Modifier.clickable {
                    navigator.navigate(route = MyScreens.AllMoviesScreen.rout)
                }){
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
                items(20) {
                    MovieItem(
                        onMovieClicked = {
                            viewModel.getMovieById(1)
//                            navigator.navigate(MyScreens.MovieScreen.rout)
                        }
                    )
                }

            }

        }
    }
}