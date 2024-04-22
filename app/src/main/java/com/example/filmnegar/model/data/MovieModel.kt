package com.example.filmnegar.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "movie_table")
data class Movie(
    @PrimaryKey
    val id: Int,

    val banner: String,
    val boxOffice: String,
    val director: String,
    val type: String,
    val imdbRate: String,
    val originalName: String,
    val persianName: String,
    val prices: String,
    val storyLine: String,
    val tag: String,
    val tizer: String,
    val usersRate: String,
    val viewsCount: String,
    val writer: String,
    val year: String
)


