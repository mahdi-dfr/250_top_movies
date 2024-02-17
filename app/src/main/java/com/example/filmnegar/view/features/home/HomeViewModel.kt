package com.example.filmnegar.view.features.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmnegar.model.data.Movie
import com.example.filmnegar.model.repoaitory.RepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository : RepositoryImpl
) : ViewModel() {

    private val _allMoviesData = mutableStateOf(listOf<Movie>())
    val allMoviesData : State<List<Movie>> get() = _allMoviesData

    private val _film = mutableStateOf(mutableListOf<Movie>())
    val film : State<List<Movie>> get() = _film

    private val _series = mutableStateOf(mutableListOf<Movie>())
    val series : State<List<Movie>> get() = _series

    private val _action = mutableStateOf(mutableListOf<Movie>())
    val action : State<List<Movie>> get() = _action

    private val _animation = mutableStateOf(mutableListOf<Movie>())
    val animation : State<List<Movie>> get() = _animation

    private val _drama = mutableStateOf(mutableListOf<Movie>())
    val drama : State<List<Movie>> get() = _drama


    init {
        getAllMovies()
    }

    private fun getAllMovies(){
        viewModelScope.launch {
            val serviceResponse = repository.getAllMovies()
            if(serviceResponse.status == "success"){
                _allMoviesData.value = serviceResponse.result!!
                filterMovies()
            }
        }
    }

    private fun filterMovies(){
        for(movie in _allMoviesData.value){
            when(movie.type){
                "0" -> _film.value.add(movie)
                "1" -> _series.value.add(movie)
            }

            movie.genre.forEach{ genre ->
                when(genre){
                    1 -> _action.value.add(movie)
                    2 -> _animation.value.add(movie)
                    3 -> _drama.value.add(movie)
                }
            }

        }
    }


}