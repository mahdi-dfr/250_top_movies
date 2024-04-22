package com.example.filmnegar.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.filmnegar.model.data.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateData(data: List<Movie>)

    @Query("SELECT * FROM movie_table")
    suspend fun getAllMoviesFromLocal(): List<Movie>

    @Query("SELECT * FROM movie_table WHERE id = :movieId")
    suspend fun getMovie(movieId : Int): Movie
}