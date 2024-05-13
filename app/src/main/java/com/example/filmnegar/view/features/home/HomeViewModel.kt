package com.example.filmnegar.view.features.home

import android.annotation.SuppressLint
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filmnegar.model.data.Banner
import com.example.filmnegar.model.data.Movie
import com.example.filmnegar.model.repoaitory.RepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
@SuppressLint("MutableCollectionMutableState")
class HomeViewModel @Inject constructor(
    private val repository: RepositoryImpl
) : ViewModel() {

    private val _allMoviesData = mutableStateOf(listOf<Movie>())
    val allMoviesData: State<List<Movie>> get() = _allMoviesData


    private val _film = mutableStateOf(listOf<Movie>())
    val film: State<List<Movie>> get() = _film

    private val _series = mutableStateOf(listOf<Movie>())
    val series: State<List<Movie>> get() = _series

    private val _action = mutableStateOf(listOf<Movie>())
    val action: State<List<Movie>> get() = _action

    private val _animation = mutableStateOf(listOf<Movie>())
    val animation: State<List<Movie>> get() = _animation

    private val _adventure = mutableStateOf(listOf<Movie>())
    val adventure: State<List<Movie>> get() = _adventure

    private val _drama = mutableStateOf(listOf<Movie>())
    val drama: State<List<Movie>> get() = _drama

    private val _banner = mutableStateOf(listOf<Banner>())
    val banner: State<List<Banner>> get() = _banner


    init {
        getAllMovies()
        getActionMovies()
        getAnimationMovies()
        getDramaMovies()
        getAdventureMovies()
    }

    private fun getAllMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            val serviceResponse = repository.getAllMovies(null)
            if (serviceResponse.status == "success") {
                _allMoviesData.value = serviceResponse.result!!
            }
        }
    }

    fun getActionMovies() {
        viewModelScope.launch {
            val serviceResponse = repository.getAllMovies("0")
            if (serviceResponse.status == "success") {
                _action.value = serviceResponse.result!!
            }
        }
    }

    fun getAnimationMovies() {
        viewModelScope.launch {
            val serviceResponse = repository.getAllMovies("1")
            if (serviceResponse.status == "success") {
                _animation.value = serviceResponse.result!!
            }
        }
    }

    fun getDramaMovies() {
        viewModelScope.launch {
            val serviceResponse = repository.getAllMovies("2")
            if (serviceResponse.status == "success") {
                _drama.value = serviceResponse.result!!
            }
        }
    }

    fun getAdventureMovies() {
        viewModelScope.launch {
            val serviceResponse = repository.getAllMovies("3")
            if (serviceResponse.status == "success") {
                _adventure.value = serviceResponse.result!!
            }
        }
    }


    private fun getBanner() {
        viewModelScope.launch(Dispatchers.IO) {
            val serviceResponse = repository.getBanners()
            if (serviceResponse.status == "success") {
                _banner.value = serviceResponse.result!!
            }
        }
    }

}