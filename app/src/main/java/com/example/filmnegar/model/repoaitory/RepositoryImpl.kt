package com.example.filmnegar.model.repoaitory

import android.util.Log
import com.example.filmnegar.model.data.Banner
import com.example.filmnegar.model.data.Movie
import com.example.filmnegar.model.db.MovieDao
import com.example.filmnegar.model.net.ApiService
import com.example.filmnegar.utils.ServiceResponse
import java.io.IOException

class RepositoryImpl(
    private val apiService: ApiService,
    private val database: MovieDao
) : MovieRepository {

    override suspend fun getAllMovies(genre: String?): ServiceResponse<List<Movie>> {
        return try {
            val data = apiService.getAllMovies(genre)
            Log.i("TAG", "getAllMllllovies: "+data)
            ServiceResponse(
                status = "success",
                message = null,
                result = data.results
            )

        } catch (e: IOException) {
            ServiceResponse(
                status = "failed",
                message = e.message,
                result = null
            )
        }
    }

    override suspend fun getMovie(id: Int): ServiceResponse<Movie> {
        return try {
            val data = apiService.getMovie(id)
            ServiceResponse(
                status = "success",
                message = null,
                result = data
            )
        } catch (e: IOException) {
            ServiceResponse(
                status = "failed",
                message = e.message,
                result = null
            )
        }
    }

    override suspend fun getBanners(): ServiceResponse<List<Banner>> {
        return try {
            val data = apiService.getBanners()
            ServiceResponse(
                status = "success",
                message = null,
                result = data
            )
        } catch (e: IOException) {
            ServiceResponse(
                status = "failed",
                message = e.message,
                result = null
            )
        }
    }
}