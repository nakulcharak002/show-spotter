package com.example.showspotter.tmdbMVVM

import android.util.Log
import com.example.moviesapp.Retrofit.RetrofitBuilder
import com.example.showspotter.tmdbapidataclass.Movie.MovieCreditsdata
import com.example.showspotter.tmdbapidataclass.Movie.MovieDetailsData
import com.example.showspotter.tmdbapidataclass.Movie.MovieLinks
import com.example.showspotter.tmdbapidataclass.Movie.MovieReleaseDateAndCertification
import com.example.showspotter.tmdbapidataclass.Movie.MovieVideosData
import com.example.showspotter.tmdbapidataclass.Movie.PopularTopRatedTrendingOnTheAirMoviesData
import com.example.showspotter.tmdbapidataclass.Series.PopularTopRatedTrendingOnTheAirSeriesData
import com.example.showspotter.tmdbapidataclass.Series.SeriesCreditsOneData
import com.example.showspotter.tmdbapidataclass.Series.SeriesDetailsOneData
import com.example.showspotter.tmdbapidataclass.Series.SeriesVideosOneData

class Repository {
    private val apiServices = RetrofitBuilder.getApi

    suspend fun getPopularMovies(): PopularTopRatedTrendingOnTheAirMoviesData? {
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

    suspend fun getPopularSeries(): PopularTopRatedTrendingOnTheAirSeriesData? {
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

    suspend fun getMovieDetailById(id: Int): MovieDetailsData? {
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

    suspend fun getMovieVideosById(id: Int): MovieVideosData? {
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

    suspend fun getMovieCreditsById(id: Int): MovieCreditsdata? {
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

    suspend fun getMovieReleaseDatesAndCertificationsById(id: Int): MovieReleaseDateAndCertification? {
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

    suspend fun getMovieLinksById(id: Int): MovieLinks? {
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

    suspend fun getTopRatedMovies(): PopularTopRatedTrendingOnTheAirMoviesData? {
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

    suspend fun getNowPlayingMovies(): PopularTopRatedTrendingOnTheAirMoviesData? {
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

    suspend fun getUpcomingMovies(): PopularTopRatedTrendingOnTheAirMoviesData? {
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

    suspend fun getSeriesDetailsById(id: Int): SeriesDetailsOneData? {
        return try {
            val movies = apiServices.getSeriesDetailsById(
                seriesId = id,
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

    suspend fun getSeriesVideosById(id: Int): SeriesVideosOneData? {
        return try {
            val movies = apiServices.getSeriesVideosById(
                seriesId = id,
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

    suspend fun getSeriesCreditsById(id: Int): SeriesCreditsOneData? {
        return try {
            val movies = apiServices.getSeriesCreditsById(
                seriesId = id,
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

    suspend fun getTrendingMovies(timeWindow: String): PopularTopRatedTrendingOnTheAirMoviesData? {
        return try {
            val movies = apiServices.getTrendingMovies(
                timeWindow = timeWindow,
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

    suspend fun getTrendingSeries(timeWindow: String): PopularTopRatedTrendingOnTheAirSeriesData? {
        return try {
            val movies = apiServices.getTrendingSeries(
                timeWindow = timeWindow,
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

    suspend fun getOnTheAirSeries(): PopularTopRatedTrendingOnTheAirSeriesData? {
        return try {
            val movies = apiServices.getOnTheAirSeries(
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

    suspend fun getTopRatedSeries(): PopularTopRatedTrendingOnTheAirSeriesData? {
        return try {
            val movies = apiServices.getTopRatedSeries(
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

    suspend fun getSearchedMovie(query: String): PopularTopRatedTrendingOnTheAirMoviesData? {
        return try {
            val movies = apiServices.getSearchedMovie(
                query = query,
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

    suspend fun getSearchedSeries(query: String): PopularTopRatedTrendingOnTheAirSeriesData? {
        return try {
            val movies = apiServices.getSearchedSeries(
                query = query,
                accept = "application/json",
                authorization = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhZTQwZjMzODI0NTc2ZTFhZTRjNTljNDMyOWNiYTllYyIsIm5iZiI6MTczNjQ1NTgxMi4yMDUsInN1YiI6IjY3ODAzNjg0NDRkNjQ5ZmZhZTdiNTg3NiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.AURYa6P9bFNnHl5CtkMPqYU5tL84XtzkPg7D3XoEyww"
            )
            Log.d("Repository", "Movies fetched successfully:  movies")
            movies // returing
        } catch (e: Exception) {
            Log.e("Repository", "Error fetching Movie", e)
            null // Return null or handle it differently based on your use case
        }
    }
}