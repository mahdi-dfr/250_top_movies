package com.example.filmnegar.view.features.home

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

    val movies = mutableStateOf(listOf<Movie>())

    init {
        getAllMovies()
    }

    private fun getAllMovies(){

        viewModelScope.launch {
            val serviceResponse = repository.getAllMovies()
            if(serviceResponse.status == "success"){
                movies.value = serviceResponse.result!!
            }
        }

    }

}