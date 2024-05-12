package com.example.filmnegar.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class MovieResult(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Movie>,

    )


@Entity(tableName = "movie_table")
data class Movie(
    @PrimaryKey
    val id: Int,

    @SerializedName("original_name")
    val originalName: String,
    @SerializedName("persian_name")
    val persianName: String,
    val type: String,
    val director: String,
    val writer: String,
    @SerializedName("story_line")
    val storyline: String,
    @SerializedName("views_count")
    val viewsCount: Int?,
    val tag: String?,
    @SerializedName("imdb_rate")
    val imdbRate: String,
    val year: Int,
    val banner: String?,
    val tizer: String?,
    @SerializedName("box_office")
    val boxOffice: String,
    val prices: String,
    @SerializedName("users_rate")
    val usersRate: Int?,
    val genre: Int
)




