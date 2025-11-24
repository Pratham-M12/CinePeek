package com.example.cinepeek.data.model

data class Movie(
    val id: Int,
    val title: String?,
    val name: String?,
    val vote_average: Double,
    val release_date: String?,
    val first_air_date: String?,
    val overview: String?,
    val poster_path: String?,
    val director: String? = null,
    val actors: String? = null
)
