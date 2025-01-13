package com.example.showspotter.screens

import com.example.showspotter.tmdbMVVM.ViewModel

fun SeriesDescScreen(viewModel: ViewModel,id:Int){
    val movie = viewModel.getMovieDetailById(id)

}