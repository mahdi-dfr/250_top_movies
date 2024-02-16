package com.example.filmnegar.model.repoaitory

import com.example.filmnegar.model.data.Movie
import com.example.filmnegar.model.net.ApiService
import com.example.filmnegar.utils.DATA_SUCCESS
import com.example.filmnegar.utils.ServiceResponse
import java.io.IOException

class RepositoryImpl(
    private val apiService: ApiService
) : MovieRepository {

    override suspend fun getAllMovies(): ServiceResponse<List<Movie>> {
        return try {
            val data = apiService.getAllMovies()
            ServiceResponse (
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