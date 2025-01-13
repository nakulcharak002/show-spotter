package com.example.showspotter.tmdbMVVM

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.showspotter.tmdbapidataclass.MoviesData
import com.example.showspotter.tmdbapidataclass.MoviesResult
import com.example.showspotter.tmdbapidataclass.SeriesData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ViewModel(
    private val repository: Repository
) : ViewModel() {

    val getPopularMovies = MutableStateFlow<MoviesData?>(null)
    val getPopularSeries = MutableStateFlow<SeriesData?>(null)
    val getMovieById = MutableStateFlow<MoviesResult?>(null)

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
            getMovieById.value = movie
        }
    }
}
