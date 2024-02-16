package com.example.filmnegar.model.net

import com.example.filmnegar.model.data.Movie
import com.example.filmnegar.utils.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface ApiService {

    @GET("movie")
    suspend fun getAllMovies(): List<Movie>
}
