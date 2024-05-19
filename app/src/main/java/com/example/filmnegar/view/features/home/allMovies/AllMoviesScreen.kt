package com.example.filmnegar.view.features.home.allMovies

import MyAppBar
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.filmnegar.utils.MyScreens
import com.example.filmnegar.view.features.home.HomeViewModel
import com.example.filmnegar.view.features.home.widgets.MovieItem

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AllMoviesScreen(
    navController : NavHostController,
    viewModel : HomeViewModel = hiltViewModel()
) {

    val numbers = (0..20).toList()

    Scaffold(
        topBar = {
            MyAppBar(navController = navController, haveBackButton = true)
        }
    ) { value ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(value)
        ) {

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier.padding(top = 8.dp, bottom = 80.dp, end = 4.dp, start = 4.dp)
            ) {
                items(numbers.size) {
                    MovieItem(
                        onMovieClicked = {
                            navController.navigate(MyScreens.MovieScreen.rout)
                        }
                    )

                }
            }

        }

    }
}