package com.example.moviesapp.Retrofit


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
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

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
    ): PopularTopRatedTrendingOnTheAirMoviesData

    @GET("tv/popular")
    suspend fun getPopularSeries(
        @Header("accept") accept: String,
        @Header("Authorization") authorization: String
    ): PopularTopRatedTrendingOnTheAirSeriesData

    @GET("movie/{movie_id}")
    suspend fun getMovieDetailById(
        @Path("movie_id") movieId: Int,
        @Header("accept") accept: String,
        @Header("Authorization") authorization: String
    ): MovieDetailsData

    @GET("movie/{movie_id}/videos")
    suspend fun getMovieVideosById(
        @Path("movie_id") movieId: Int,
        @Header("accept") accept: String,
        @Header("Authorization") authorization: String
    ): MovieVideosData

    @GET("movie/{movie_id}/credits")
    suspend fun getMovieCreditsById(
        @Path("movie_id") movieId: Int,
        @Header("accept") accept: String,
        @Header("Authorization") authorization: String
    ): MovieCreditsdata

    @GET("movie/{movie_id}/release_dates")
    suspend fun getMovieReleaseDatesAndCertificationsById(
        @Path("movie_id") movieId: Int,
        @Header("accept") accept: String,
        @Header("Authorization") authorization: String
    ): MovieReleaseDateAndCertification

    @GET("movie/{movie_id}/external_ids")
    suspend fun getMovieLinksById(
        @Path("movie_id") movieId: Int,
        @Header("accept") accept: String,
        @Header("Authorization") authorization: String
    ): MovieLinks

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Header("accept") accept: String,
        @Header("Authorization") authorization: String
    ): PopularTopRatedTrendingOnTheAirMoviesData

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Header("accept") accept: String,
        @Header("Authorization") authorization: String
    ): PopularTopRatedTrendingOnTheAirMoviesData

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Header("accept") accept: String,
        @Header("Authorization") authorization: String
    ): PopularTopRatedTrendingOnTheAirMoviesData

    @GET("trending/movie/{time_window}")
    suspend fun getTrendingMovies(
        @Path("time_window") timeWindow: String,
        @Header("accept") accept: String,
        @Header("Authorization") authorization: String
    ): PopularTopRatedTrendingOnTheAirMoviesData


    @GET("tv/{series_id}")
    suspend fun getSeriesDetailsById(
        @Path("series_id") seriesId: Int,
        @Header("accept") accept: String,
        @Header("Authorization") authorization: String
    ): SeriesDetailsOneData

    @GET("tv/{series_id}/videos")
    suspend fun getSeriesVideosById(
        @Path("series_id") seriesId: Int,
        @Header("accept") accept: String,
        @Header("Authorization") authorization: String
    ): SeriesVideosOneData

    @GET("tv/{series_id}/credits")
    suspend fun getSeriesCreditsById(
        @Path("series_id") seriesId: Int,
        @Header("accept") accept: String,
        @Header("Authorization") authorization: String
    ): SeriesCreditsOneData

    @GET("trending/tv/{time_window}")
    suspend fun getTrendingSeries(
        @Path("time_window") timeWindow: String,
        @Header("accept") accept: String,
        @Header("Authorization") authorization: String
    ): PopularTopRatedTrendingOnTheAirSeriesData

    @GET("tv/on_the_air")
    suspend fun getOnTheAirSeries(
        @Header("accept") accept: String,
        @Header("Authorization") authorization: String
    ): PopularTopRatedTrendingOnTheAirSeriesData

    @GET("tv/top_rated")
    suspend fun getTopRatedSeries(
        @Header("accept") accept: String,
        @Header("Authorization") authorization: String
    ): PopularTopRatedTrendingOnTheAirSeriesData

    @GET("search/movie")
    suspend fun getSearchedMovie(
        @Query("query") query: String,
        @Header("accept") accept: String,
        @Header("Authorization") authorization: String
    ): PopularTopRatedTrendingOnTheAirMoviesData

    @GET("search/tv")
    suspend fun getSearchedSeries(
        @Query("query") query: String,
        @Header("accept") accept: String,
        @Header("Authorization") authorization: String
    ): PopularTopRatedTrendingOnTheAirSeriesData
}