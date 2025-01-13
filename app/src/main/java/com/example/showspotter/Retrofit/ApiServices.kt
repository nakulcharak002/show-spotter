package com.example.moviesapp.Retrofit


import com.example.showspotter.tmdbapidataclass.MoviesData
import com.example.showspotter.tmdbapidataclass.MoviesResult
import com.example.showspotter.tmdbapidataclass.SeriesData
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ApiServices {

//    Size
//    Posters: w92, w154, w185, w342, w500, w780, original
//    Backdrops: w300, w780, w1280, original
//    image end point
//    https://image.tmdb.org/t/p/{size}/{file_path}

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Header("accept") accept: String,
        @Header("Authorization") authorization: String
    ): MoviesData

    @GET("tv/popular")
    suspend fun getPopularSeries(
        @Header("accept") accept: String,
        @Header("Authorization") authorization: String
    ) :SeriesData

    @GET("movie/{movie_id}")
    suspend fun getMovieDetailById(
        @Path("movie_id") movieId: Int,
        @Header("accept") accept: String,
        @Header("Authorization") authorization: String
    ) : MoviesResult



}