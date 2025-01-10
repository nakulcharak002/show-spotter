package com.example.moviesapp.Retrofit


import com.example.showspotter.apidataclass.PopularMovies
import com.google.android.gms.common.api.internal.ApiKey
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiServices {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Header("accept") accept: String,
        @Header("Authorization") authorization: String
    ): PopularMovies
}