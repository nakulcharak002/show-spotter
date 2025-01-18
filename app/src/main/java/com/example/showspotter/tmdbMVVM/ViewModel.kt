package com.example.showspotter.tmdbMVVM

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.showspotter.tmdbapidataclass.Movie.MovieCreditsdata
import com.example.showspotter.tmdbapidataclass.Movie.MovieDetailsData
import com.example.showspotter.tmdbapidataclass.Movie.MovieLinks
import com.example.showspotter.tmdbapidataclass.Movie.MovieVideosData
import com.example.showspotter.tmdbapidataclass.Movie.PopularTopRatedMoviesData
import com.example.showspotter.tmdbapidataclass.Movie.MovieReleaseDateAndCertification
import com.example.showspotter.tmdbapidataclass.Movie.MoviesNowPlayingData
import com.example.showspotter.tmdbapidataclass.Series.PopularSeriesData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ViewModel(
    private val repository: Repository
) : ViewModel() {



    val getPopularMovies = MutableStateFlow<PopularTopRatedMoviesData?>(null)
    val getPopularSeries = MutableStateFlow<PopularSeriesData?>(null)
    var getMovieDetailsById = MutableStateFlow<MovieDetailsData?>(null)
    var getMovieVideosById = MutableStateFlow<MovieVideosData?>(null)
    var getMovieCreditsById = MutableStateFlow<MovieCreditsdata?>(null)
    var getMovieReleaseDatesAndCertificationsById = MutableStateFlow<MovieReleaseDateAndCertification?>(null)
    val getMovieLinksById = MutableStateFlow<MovieLinks?>(null)
    val getTopRatedMovies = MutableStateFlow<PopularTopRatedMoviesData?>(null)
    val getNowPlayingMovies = MutableStateFlow<MoviesNowPlayingData?>(null)
    val getUpcomingMovies = MutableStateFlow<MoviesNowPlayingData?>(null)

    init{
        getPopularMovies()
        getPopularSeries()
    }

    fun getPopularMovies(){
        viewModelScope.launch(Dispatchers.IO){
            val movies = repository.getPopularMovies()
            getPopularMovies.value = movies

        }
    }
    fun getPopularSeries(){
        viewModelScope.launch(Dispatchers.IO){
            val series = repository.getPopularSeries()
            getPopularSeries.value = series
        }
    }

    fun getMovieDetailById(id:Int){
        viewModelScope.launch(Dispatchers.IO){
            val movie = repository.getMovieDetailById(id)
            getMovieDetailsById.value = movie
        }
    }

    fun getMovieVideosById(id:Int){
        viewModelScope.launch(Dispatchers.IO){
            val movie = repository.getMovieVideosById(id)
            getMovieVideosById.value = movie
        }
    }

    fun getMovieCreditsById(id:Int){
        viewModelScope.launch(Dispatchers.IO){
            val movie = repository.getMovieCreditsById(id)
            getMovieCreditsById.value = movie
        }
    }

    fun getMovieReleaseDatesAndCertificationsById(id:Int){
        viewModelScope.launch(Dispatchers.IO){
            val movie = repository.getMovieReleaseDatesAndCertificationsById(id)
            getMovieReleaseDatesAndCertificationsById.value = movie
        }
    }

    fun getMovieLinksById(id:Int){
        viewModelScope.launch(Dispatchers.IO){
            val movie = repository.getMovieLinksById(id)
            getMovieLinksById.value = movie
        }
    }

    fun getTopRatedMovies(){
        viewModelScope.launch(Dispatchers.IO){
            val movie = repository.getTopRatedMovies()
            getTopRatedMovies.value = movie
        }
    }
    fun getNowPlayingMovies(){
        viewModelScope.launch(Dispatchers.IO){
            val movie = repository.getNowPlayingMovies()
            getNowPlayingMovies.value = movie
        }
    }
    fun getUpcomingMovies(){
        viewModelScope.launch(Dispatchers.IO){
            val movie = repository.getUpcomingMovies()
            getUpcomingMovies.value = movie
        }
    }

}
