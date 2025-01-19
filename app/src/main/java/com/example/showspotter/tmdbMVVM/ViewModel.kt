package com.example.showspotter.tmdbMVVM

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.showspotter.tmdbapidataclass.Movie.MovieCreditsdata
import com.example.showspotter.tmdbapidataclass.Movie.MovieDetailsData
import com.example.showspotter.tmdbapidataclass.Movie.MovieLinks
import com.example.showspotter.tmdbapidataclass.Movie.MovieVideosData
import com.example.showspotter.tmdbapidataclass.Movie.PopularTopRatedTrendingOnTheAirMoviesData
import com.example.showspotter.tmdbapidataclass.Movie.MovieReleaseDateAndCertification
import com.example.showspotter.tmdbapidataclass.Movie.MoviesNowPlayingData
import com.example.showspotter.tmdbapidataclass.Series.PopularTopRatedTrendingOnTheAirSeriesData
import com.example.showspotter.tmdbapidataclass.Series.SeriesCreditsOneData
import com.example.showspotter.tmdbapidataclass.Series.SeriesDetailsOneData
import com.example.showspotter.tmdbapidataclass.Series.SeriesVideosOneData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ViewModel(
    private val repository: Repository
) : ViewModel() {

    val getPopularMovies = MutableStateFlow<PopularTopRatedTrendingOnTheAirMoviesData?>(null)
    val getPopularSeries = MutableStateFlow<PopularTopRatedTrendingOnTheAirSeriesData?>(null)
    var getMovieDetailsById = MutableStateFlow<MovieDetailsData?>(null)
    var getMovieVideosById = MutableStateFlow<MovieVideosData?>(null)
    var getMovieCreditsById = MutableStateFlow<MovieCreditsdata?>(null)
    var getMovieReleaseDatesAndCertificationsById = MutableStateFlow<MovieReleaseDateAndCertification?>(null)
    val getMovieLinksById = MutableStateFlow<MovieLinks?>(null)
    val getTopRatedMovies = MutableStateFlow<PopularTopRatedTrendingOnTheAirMoviesData?>(null)
    val getNowPlayingMovies = MutableStateFlow<MoviesNowPlayingData?>(null)
    val getUpcomingMovies = MutableStateFlow<MoviesNowPlayingData?>(null)
    val getTrendingMovies = MutableStateFlow<PopularTopRatedTrendingOnTheAirMoviesData?>(null)
    val getSeriesDetailsById = MutableStateFlow<SeriesDetailsOneData?>(null)
    val getSeriesVideosById = MutableStateFlow<SeriesVideosOneData?>(null)
    val getSeriesCreditsById = MutableStateFlow<SeriesCreditsOneData?>(null)
    val getTrendingSeries = MutableStateFlow<PopularTopRatedTrendingOnTheAirSeriesData?>(null)
    val getOnTheAirSeries = MutableStateFlow<PopularTopRatedTrendingOnTheAirSeriesData?>(null)
    val getTopRatedSeries = MutableStateFlow<PopularTopRatedTrendingOnTheAirSeriesData?>(null)
    val getSearchedMovie = MutableStateFlow<PopularTopRatedTrendingOnTheAirMoviesData?>(null)
    val getSearchedSeries = MutableStateFlow<PopularTopRatedTrendingOnTheAirSeriesData?>(null)

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
    fun getSeriesDetailsById(id:Int){
        viewModelScope.launch(Dispatchers.IO){
            val movie = repository.getSeriesDetailsById(id)
            getSeriesDetailsById.value = movie
        }
    }
    fun getSeriesVideosById(id:Int){
        viewModelScope.launch(Dispatchers.IO){
            val movie = repository.getSeriesVideosById(id)
            getSeriesVideosById.value = movie
        }
    }

    fun getSeriesCreditsById(id:Int){
        viewModelScope.launch(Dispatchers.IO){
            val movie = repository.getSeriesCreditsById(id)
            getSeriesCreditsById.value = movie
        }
    }

    fun getTrendingMovies(timeWindow:String){
        viewModelScope.launch(Dispatchers.IO){
            val movie = repository.getTrendingMovies(timeWindow)
            getTrendingMovies.value = movie
        }
    }

    fun getTrendingSeries(timeWindow:String){
        viewModelScope.launch(Dispatchers.IO){
            val movie = repository.getTrendingSeries(timeWindow)
            getTrendingSeries.value = movie
        }
    }

    fun getOnTheAirSeries(){
        viewModelScope.launch(Dispatchers.IO){
            val movie = repository.getOnTheAirSeries()
            getOnTheAirSeries.value = movie
        }
    }

    fun getTopRatedSeries(){
        viewModelScope.launch(Dispatchers.IO){
            val movie = repository.getTopRatedSeries()
            getTopRatedSeries.value = movie
        }
    }

    fun getSearchedMovie(query: String){
        viewModelScope.launch(Dispatchers.IO){
            val movie = repository.getSearchedMovie(query)
            getSearchedMovie.value = movie
        }
    }

    fun getSearchedSeries(query: String){
        viewModelScope.launch(Dispatchers.IO){
            val movie = repository.getSearchedSeries(query)
            getSearchedSeries.value = movie
        }
    }

}
