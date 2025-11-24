package com.example.cinepeek.data.network

import com.example.cinepeek.data.model.MoviesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// 1️⃣ Retrofit API interface
interface MovieApiService {
    @GET("f5e7ed61-7c10-4f7b-aa11-2de1ca33bac3") // your Mocki.io endpoint
    suspend fun getMovies(): MoviesResponse
}

// 2️⃣ Retrofit instance
object RetrofitInstance {
    private const val BASE_URL = "https://mocki.io/v1/"

    val api: MovieApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApiService::class.java)
    }
}
