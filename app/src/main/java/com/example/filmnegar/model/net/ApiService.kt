package com.example.filmnegar.model.net

import com.example.filmnegar.model.data.Banner
import com.example.filmnegar.model.data.Genre
import com.example.filmnegar.model.data.Movie
import retrofit2.http.GET

interface ApiService {

    @GET("movie/")
    suspend fun getAllMovies(): List<Movie>

    @GET("movie/{id}")
    suspend fun getMovie(id: Int) : Movie

    @GET("banner/")
    suspend fun getBanners() : List<Banner>

    @GET("genre/")
    suspend fun getGenre(): List<Genre>


}
