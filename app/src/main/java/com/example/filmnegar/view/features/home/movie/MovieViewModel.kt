package com.example.filmnegar.view.features.home.movie

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmnegar.model.data.Movie
import com.example.filmnegar.model.repoaitory.RepositoryImpl
import com.example.filmnegar.utils.EMPTY_MOVIE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val repository: RepositoryImpl
): ViewModel(){

    private val _movie = mutableStateOf<Movie>(EMPTY_MOVIE)
    val movie: State<Movie> get() = _movie

    fun getMovieById(id: Int){
        viewModelScope.launch {
            val serviceResponse = repository.getMovie(id)
            if(serviceResponse.status == "success"){
                _movie.value = serviceResponse.result!!
            }
        }
    }

}