package com.example.showspotter.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.showspotter.ViewModel
import com.google.firebase.auth.FirebaseAuth

@Composable
fun HomeScreen(viewModel: ViewModel,auth: FirebaseAuth,goToOnBoadingScreen:()->Unit) {
    Box(modifier = Modifier.padding(top=20.dp)) {
        Column() {
            val movies = viewModel.getPopularMovies.collectAsState().value
            Text(text = movies?.results[0]?.title.toString())
        }

    }

}