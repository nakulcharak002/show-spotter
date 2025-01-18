package com.example.showspotter.tmdbMVVM

import android.util.Log
import com.example.moviesapp.Retrofit.RetrofitBuilder
import com.example.showspotter.tmdbapidataclass.Movie.MovieCreditsdata
import com.example.showspotter.tmdbapidataclass.Movie.MovieDetailsData
import com.example.showspotter.tmdbapidataclass.Movie.MovieLinks
import com.example.showspotter.tmdbapidataclass.Movie.MovieVideosData
import com.example.showspotter.tmdbapidataclass.Movie.PopularTopRatedMoviesData
import com.example.showspotter.tmdbapidataclass.Movie.MovieReleaseDateAndCertification
import com.example.showspotter.tmdbapidataclass.Movie.MoviesNowPlayingData
import com.example.showspotter.tmdbapidataclass.Series.PopularSeriesData

class Repository {
    private val apiServices = RetrofitBuilder.getApi

    suspend fun getPopularMovies(): PopularTopRatedMoviesData? {
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

    suspend fun getPopularSeries(): PopularSeriesData? {
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

    suspend fun getMovieDetailById(id:Int): MovieDetailsData? {
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

    suspend fun getMovieVideosById(id:Int): MovieVideosData? {
        return try {
            val movies = apiServices.getMovieVideosById(
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

    suspend fun getMovieCreditsById(id:Int): MovieCreditsdata? {
        return try {
            val movies = apiServices.getMovieCreditsById(
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

    suspend fun getMovieReleaseDatesAndCertificationsById(id:Int): MovieReleaseDateAndCertification? {
        return try {
            val movies = apiServices.getMovieReleaseDatesAndCertificationsById(
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

    suspend fun getMovieLinksById(id:Int): MovieLinks? {
        return try {
            val movies = apiServices.getMovieLinksById(
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

    suspend fun getTopRatedMovies(): PopularTopRatedMoviesData? {
        return try {
            val movies = apiServices.getTopRatedMovies(
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

    suspend fun getNowPlayingMovies(): MoviesNowPlayingData? {
        return try {
            val movies = apiServices.getNowPlayingMovies(
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

    suspend fun getUpcomingMovies(): MoviesNowPlayingData? {
        return try {
            val movies = apiServices.getUpcomingMovies(
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