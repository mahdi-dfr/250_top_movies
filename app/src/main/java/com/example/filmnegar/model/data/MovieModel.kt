package com.example.filmnegar.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "movie_table")
data class Movie(
    @PrimaryKey
    val id: Int,

//    val actors: List<Int>,
    val baner: String,
    val box_office: String,
    val director: String,
    val type: String,
//    val genre: List<Int>,
    val imdb_rate: String,
    val original_name: String,
    val persian_name: String,
    val prices: String,
    val story_line: String,
    val tag: String,
    val tizer: String,
    val users_rate: String,
    val views_count: String,
    val writer: String,
    val year: String
)


