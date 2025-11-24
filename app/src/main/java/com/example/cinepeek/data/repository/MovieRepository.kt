package com.example.cinepeek.data.repository

import com.example.cinepeek.data.model.Movie
import com.example.cinepeek.data.network.RetrofitInstance

class MovieRepository {
    suspend fun getMovies(): List<Movie> {
        return try {
            val response = RetrofitInstance.api.getMovies()
            response.results
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}
