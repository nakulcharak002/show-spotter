package com.example.showspotter.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.showspotter.R
import com.example.showspotter.designs.BottomNavigatorDesign
import com.example.showspotter.designs.LazyRowMoviesDesign
import com.example.showspotter.designs.LazyRowNowPlayingMoviesDesign
import com.example.showspotter.tmdbMVVM.ViewModel

@Composable
fun MovieTabScreen(viewModel: ViewModel,goToHomeScreen: () -> Unit, goToMovieTabScreen: () -> Unit,goToMovieDescScreen:(id:Int)->Unit){
//    viewModel.getPopularMovies() // dont have to call popular movies as it is colled in home screen already

    if(viewModel.getTopRatedMovies.collectAsState().value==null) {
        viewModel.getTopRatedMovies()
    }
    if(viewModel.getNowPlayingMovies.collectAsState().value==null) {
        viewModel.getNowPlayingMovies()
    }
    if(viewModel.getUpcomingMovies.collectAsState().value==null) {
        viewModel.getUpcomingMovies()
    }
    val popularMovies = viewModel.getPopularMovies.collectAsState().value
    val topRatedMovies = viewModel.getTopRatedMovies.collectAsState().value
    val nowPlayingMovies = viewModel.getNowPlayingMovies.collectAsState().value
    val upcomingMovies = viewModel.getUpcomingMovies.collectAsState().value

    Box( modifier = Modifier
        .fillMaxSize()
        .background(Color.Black) ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF1f1f1f))
                .verticalScroll(rememberScrollState())
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 45.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "notification",
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .size(35.dp)
                        .background(Color(0xFF121212), shape = CircleShape)
                        .padding(8.dp)
                        .clip(CircleShape)
                        .clickable(onClick = {

                        })
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.appicon),
                        contentDescription = "appicon",
                        modifier = Modifier.size(50.dp)
                    )
                    Text(
                        text = "ShowSpotter",
                        fontSize = 13.sp,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.interbold))
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.searchicon),
                    contentDescription = "search",
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .size(35.dp)
                        .background(Color(0xFF121212), shape = CircleShape)
                        .clip(CircleShape)
                        .padding(8.dp)
                )
            }
                // movies list

            if (nowPlayingMovies == null) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp), contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
                LazyRowNowPlayingMoviesDesign(viewModel,nowPlayingMovies, "Now Playing", goToMovieDescScreen)
            }
            if (topRatedMovies == null) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp), contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
                LazyRowMoviesDesign(viewModel,topRatedMovies, "Top Rated Movies", goToMovieDescScreen)
            }

            if (popularMovies == null) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp), contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
                LazyRowMoviesDesign(viewModel,popularMovies, "Popular Movies", goToMovieDescScreen)
            }

            if (upcomingMovies == null) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp), contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
                LazyRowNowPlayingMoviesDesign(viewModel,upcomingMovies, "Upcoming Movies", goToMovieDescScreen)
            }
        }
    }
    BottomNavigatorDesign(goToHomeScreen, goToMovieTabScreen)
}