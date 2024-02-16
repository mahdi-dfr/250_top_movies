package com.example.filmnegar.model.repoaitory

import com.example.filmnegar.model.data.Movie
import com.example.filmnegar.utils.ServiceResponse

interface MovieRepository {

    suspend fun getAllMovies() : ServiceResponse<List<Movie>>

}