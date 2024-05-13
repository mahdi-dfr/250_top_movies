package com.example.filmnegar.model.net

import com.example.filmnegar.model.data.BannerResult
import com.example.filmnegar.model.data.Genre
import com.example.filmnegar.model.data.Movie
import com.example.filmnegar.model.data.MovieResult
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/")
    suspend fun getAllMovies(
        @Query("genre") genre: String?
    ): MovieResult

    @GET("movie/{id}")
    suspend fun getMovie(id: Int): Movie

    @GET("banner/")
    suspend fun getBanners(): BannerResult

    @GET("genre/")
    suspend fun getGenre(): List<Genre>


}
