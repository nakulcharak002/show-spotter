package com.example.showspotter.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.showspotter.repositories.TMDBRepository
import com.example.showspotter.tmdbapidataclass.MailerooResponse
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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TMDBViewModel(
    private val TMDBRepository: TMDBRepository
) : ViewModel() {

    val getPopularMovies = MutableStateFlow<PopularTopRatedTrendingOnTheAirMoviesData?>(null)
    val getPopularSeries = MutableStateFlow<PopularTopRatedTrendingOnTheAirSeriesData?>(null)
    var getMovieDetailsById = MutableStateFlow<MovieDetailsData?>(null)
    var getMovieVideosById = MutableStateFlow<MovieVideosData?>(null)
    var getMovieCreditsById = MutableStateFlow<MovieCreditsdata?>(null)
    var getMovieReleaseDatesAndCertificationsById =
        MutableStateFlow<MovieReleaseDateAndCertification?>(null)
    val getMovieLinksById = MutableStateFlow<MovieLinks?>(null)
    val getTopRatedMovies = MutableStateFlow<PopularTopRatedTrendingOnTheAirMoviesData?>(null)
    val getNowPlayingMovies = MutableStateFlow<PopularTopRatedTrendingOnTheAirMoviesData?>(null)
    val getUpcomingMovies = MutableStateFlow<PopularTopRatedTrendingOnTheAirMoviesData?>(null)
    val getTrendingMovies = MutableStateFlow<PopularTopRatedTrendingOnTheAirMoviesData?>(null)
    val getSeriesDetailsById = MutableStateFlow<SeriesDetailsOneData?>(null)
    val getSeriesVideosById = MutableStateFlow<SeriesVideosOneData?>(null)
    val getSeriesCreditsById = MutableStateFlow<SeriesCreditsOneData?>(null)
    val getTrendingSeries = MutableStateFlow<PopularTopRatedTrendingOnTheAirSeriesData?>(null)
    val getOnTheAirSeries = MutableStateFlow<PopularTopRatedTrendingOnTheAirSeriesData?>(null)
    val getTopRatedSeries = MutableStateFlow<PopularTopRatedTrendingOnTheAirSeriesData?>(null)
    val getSearchedMovie = MutableStateFlow<PopularTopRatedTrendingOnTheAirMoviesData?>(null)
    val getSearchedSeries = MutableStateFlow<PopularTopRatedTrendingOnTheAirSeriesData?>(null)
    val getValidEmail = MutableStateFlow<MailerooResponse?>(null)


    init{
        getPopularMovies()
        getPopularSeries()
    }

    fun checkEmailAddress(email: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = TMDBRepository.checkEmailAddress(email)
                withContext(Dispatchers.Main) {
                    getValidEmail.value = response
                }
            } catch (e: Exception) {
                Log.e("EmailViewModel", "Error verifying email", e)
                withContext(Dispatchers.Main) {
                    getValidEmail.value = null
                }
            }
        }
    }


    fun getPopularMovies(){
        viewModelScope.launch(Dispatchers.IO){
            val movies = TMDBRepository.getPopularMovies()
            getPopularMovies.value = movies

        }
    }
    fun getPopularSeries(){
        viewModelScope.launch(Dispatchers.IO){
            val series = TMDBRepository.getPopularSeries()
            getPopularSeries.value = series
        }
    }

    fun getMovieDetailById(id:Int){
        viewModelScope.launch(Dispatchers.IO){
            val movie = TMDBRepository.getMovieDetailById(id)
            getMovieDetailsById.value = movie
        }
    }

    fun getMovieVideosById(id:Int){
        viewModelScope.launch(Dispatchers.IO){
            val movie = TMDBRepository.getMovieVideosById(id)
            getMovieVideosById.value = movie
        }
    }

    fun getMovieCreditsById(id:Int){
        viewModelScope.launch(Dispatchers.IO){
            val movie = TMDBRepository.getMovieCreditsById(id)
            getMovieCreditsById.value = movie
        }
    }

    fun getMovieReleaseDatesAndCertificationsById(id:Int){
        viewModelScope.launch(Dispatchers.IO){
            val movie = TMDBRepository.getMovieReleaseDatesAndCertificationsById(id)
            getMovieReleaseDatesAndCertificationsById.value = movie
        }
    }

    fun getMovieLinksById(id:Int){
        viewModelScope.launch(Dispatchers.IO){
            val movie = TMDBRepository.getMovieLinksById(id)
            getMovieLinksById.value = movie
        }
    }

    fun getTopRatedMovies(){
        viewModelScope.launch(Dispatchers.IO){
            val movie = TMDBRepository.getTopRatedMovies()
            getTopRatedMovies.value = movie
        }
    }
    fun getNowPlayingMovies(){
        viewModelScope.launch(Dispatchers.IO){
            val movie = TMDBRepository.getNowPlayingMovies()
            getNowPlayingMovies.value = movie
        }
    }
    fun getUpcomingMovies(){
        viewModelScope.launch(Dispatchers.IO){
            val movie = TMDBRepository.getUpcomingMovies()
            getUpcomingMovies.value = movie
        }
    }
    fun getSeriesDetailsById(id:Int){
        viewModelScope.launch(Dispatchers.IO){
            val movie = TMDBRepository.getSeriesDetailsById(id)
            getSeriesDetailsById.value = movie
        }
    }
    fun getSeriesVideosById(id:Int){
        viewModelScope.launch(Dispatchers.IO){
            val movie = TMDBRepository.getSeriesVideosById(id)
            getSeriesVideosById.value = movie
        }
    }

    fun getSeriesCreditsById(id:Int){
        viewModelScope.launch(Dispatchers.IO){
            val movie = TMDBRepository.getSeriesCreditsById(id)
            getSeriesCreditsById.value = movie
        }
    }

    fun getTrendingMovies(timeWindow:String){
        viewModelScope.launch(Dispatchers.IO){
            val movie = TMDBRepository.getTrendingMovies(timeWindow)
            getTrendingMovies.value = movie
        }
    }

    fun getTrendingSeries(timeWindow:String){
        viewModelScope.launch(Dispatchers.IO){
            val movie = TMDBRepository.getTrendingSeries(timeWindow)
            getTrendingSeries.value = movie
        }
    }

    fun getOnTheAirSeries(){
        viewModelScope.launch(Dispatchers.IO){
            val movie = TMDBRepository.getOnTheAirSeries()
            getOnTheAirSeries.value = movie
        }
    }

    fun getTopRatedSeries(){
        viewModelScope.launch(Dispatchers.IO){
            val movie = TMDBRepository.getTopRatedSeries()
            getTopRatedSeries.value = movie
        }
    }

    fun getSearchedMovie(query: String){
        viewModelScope.launch(Dispatchers.IO){
            val movie = TMDBRepository.getSearchedMovie(query)
            getSearchedMovie.value = movie
        }
    }

    fun getSearchedSeries(query: String){
        viewModelScope.launch(Dispatchers.IO){
            val movie = TMDBRepository.getSearchedSeries(query)
            getSearchedSeries.value = movie
        }
    }
}