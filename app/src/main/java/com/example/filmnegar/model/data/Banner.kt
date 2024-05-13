package com.example.filmnegar.model.data

class BannerResult(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Banner>,
)

data class Banner(
    val image: String?,
    val movie: Movie?
)