package com.example.filmnegar.utils

import com.example.filmnegar.model.data.Movie

const val BASE_URL = "http://192.168.10.232:8000/api/movie/"

const val DATA_SUCCESS = "success"
const val DATA_FAILED = "failed"

val actorsList = listOf(
    "بازیگر1",
    "بازیگر2",
    "بازیگر3",
    "بازیگر4",
    "بازیگر5",
)

val writerList = listOf(
    "نویسنده 1",
    "نویسنده 2",
    "نویسنده 2",
)

val EMPTY_MOVIE = Movie(
    id = 0,
    originalName = "0",
    persianName = "",
    type = "",
    director = "",
    writer = "",
    storyline = "",
    viewsCount = 0,
    tag = "",
    imdbRate = "",
    year = 0,
    banner = "",
    poster = "",
    tizer = "",
    boxOffice = "",
    prices = "",
    usersRate = 0,
    genre = 0,
)

const val imageFakeUrl =
    "https://cdn.vox-cdn.com/thumbor/0w5aZu5XweQgRK_Ljoyq9Her8N8=/0x0:1200x800/1200x800/filters:focal(502x21:694x213)/cdn.vox-cdn.com/uploads/chorus_image/image/73167146/Dune2_LegendaryEntertainment_Getty_Ringer.0.jpg"