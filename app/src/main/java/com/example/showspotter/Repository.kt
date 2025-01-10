package com.example.showspotter

import com.example.moviesapp.Retrofit.RetrofitBuilder
import com.example.showspotter.apidataclass.PopularMovies

class Repository {
    private val apiServices = RetrofitBuilder.getApi

    suspend fun getPopularMovies() : PopularMovies {
        return apiServices.getPopularMovies(
            accept = "application/json",
            authorization = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhZTQwZjMzODI0NTc2ZTFhZTRjNTljNDMyOWNiYTllYyIsIm5iZiI6MTczNjQ1NTgxMi4yMDUsInN1YiI6IjY3ODAzNjg0NDRkNjQ5ZmZhZTdiNTg3NiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.AURYa6P9bFNnHl5CtkMPqYU5tL84XtzkPg7D3XoEyww")
    }
}