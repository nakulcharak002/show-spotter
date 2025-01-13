package com.example.showspotter.screens

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import coil3.compose.rememberAsyncImagePainter
import com.example.showspotter.tmdbMVVM.ViewModel
import androidx.compose.runtime.collectAsState

@Composable
fun MovieDescScreen(viewModel: ViewModel, id: Int) {
    viewModel.getMovieDetailById(id)
    var movie = viewModel.getMovieById.collectAsState().value

    if (movie != null) {
        Image(
            rememberAsyncImagePainter("https://image.tmdb.org/t/p/w500/${movie.poster_path}"),
            contentDescription = null
        )
    }

}