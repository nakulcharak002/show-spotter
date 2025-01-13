package com.example.showspotter.tmdbMVVM

import android.util.Log
import com.example.moviesapp.Retrofit.RetrofitBuilder
import com.example.showspotter.tmdbapidataclass.MoviesData
import com.example.showspotter.tmdbapidataclass.MoviesResult
import com.example.showspotter.tmdbapidataclass.SeriesData

class Repository {
    private val apiServices = RetrofitBuilder.getApi

    suspend fun getPopularMovies(): MoviesData? {
        return try {
            val movies = apiServices.getPopularMovies(
                accept = "application/json",
                authorization = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhZTQwZjMzODI0NTc2ZTFhZTRjNTljNDMyOWNiYTllYyIsIm5iZiI6MTczNjQ1NTgxMi4yMDUsInN1YiI6IjY3ODAzNjg0NDRkNjQ5ZmZhZTdiNTg3NiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.AURYa6P9bFNnHl5CtkMPqYU5tL84XtzkPg7D3XoEyww"
            )
            Log.d("Repository", "Movies fetched successfully: movies")
            movies
        } catch (e: Exception) {
            Log.e("Repository", "Error fetching popular movies", e)
            null // Return null or handle it differently based on your use case
        }
    }

    suspend fun getPopularSeries(): SeriesData? {
        return try {
            val movies = apiServices.getPopularSeries(
                accept = "application/json",
                authorization = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhZTQwZjMzODI0NTc2ZTFhZTRjNTljNDMyOWNiYTllYyIsIm5iZiI6MTczNjQ1NTgxMi4yMDUsInN1YiI6IjY3ODAzNjg0NDRkNjQ5ZmZhZTdiNTg3NiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.AURYa6P9bFNnHl5CtkMPqYU5tL84XtzkPg7D3XoEyww"
            )
            Log.d("Repository", "Movies fetched successfully:movies")
            movies
        } catch (e: Exception) {
            Log.e("Repository", "Error fetching popular series", e)
            null // Return null or handle it differently based on your use case
        }
    }

    suspend fun getMovieDetailById(id:Int): MoviesResult? {
        return try {
            val movies = apiServices.getMovieDetailById(
                movieId = id,
                accept = "application/json",
                authorization = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhZTQwZjMzODI0NTc2ZTFhZTRjNTljNDMyOWNiYTllYyIsIm5iZiI6MTczNjQ1NTgxMi4yMDUsInN1YiI6IjY3ODAzNjg0NDRkNjQ5ZmZhZTdiNTg3NiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.AURYa6P9bFNnHl5CtkMPqYU5tL84XtzkPg7D3XoEyww"
            )
            Log.d("Repository", "Movies fetched successfully:  movies")
            movies
        } catch (e: Exception) {
            Log.e("Repository", "Error fetching Movie", e)
            null // Return null or handle it differently based on your use case
        }
    }

}