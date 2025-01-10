package com.example.showspotter

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.showspotter.apidataclass.PopularMovies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ViewModel(
    private val repository: Repository
) : ViewModel() {

    val getPopularMovies = MutableStateFlow<PopularMovies?>(null)

    init{
        getPopularMovies()
    }

    fun getPopularMovies(){
        viewModelScope.launch(Dispatchers.IO){
            Log.i("call","calling")
            val movies = repository.getPopularMovies()
            getPopularMovies.value = movies
            Log.i("4563","done")
        }
    }
}
