package com.example.showspotter.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.showspotter.R
import com.example.showspotter.designs.BottomNavigatorDesign
import com.example.showspotter.designs.LazyRowMoviesDesign
import com.example.showspotter.designs.LazyRowSeriesDesign
import com.example.showspotter.tmdbMVVM.ViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlin.random.Random

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: ViewModel,
    auth: FirebaseAuth,
    goToOnBoardingScreen:()->Unit,
    goToSeriesDescScreen: (id: Int) -> Unit,
    goToMovieDescScreen: (id: Int) -> Unit,
    goToHomeScreen:()->Unit,
    goToMovieTabScreen:()->Unit,
    goToSeriesTabScreen:()->Unit,
    goToSearchScreen:()->Unit,
    goToProfileScreen:()->Unit
) {
    val popularMovies = viewModel.getPopularMovies.collectAsState().value
    val popularSeries = viewModel.getPopularSeries.collectAsState().value
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
                                    goToProfileScreen()
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
                        .clickable(
                            onClick = {
                                goToSearchScreen()
                            }
                        )
                )
            }
            val thumbnails = listOf(
                R.drawable.thumbnail1,
                R.drawable.thumbnail2,
                R.drawable.thumbnail3,
                R.drawable.thumbnail4,
                R.drawable.thumbnail5,
                R.drawable.thumbnail6,
                R.drawable.thumbnail7,
                R.drawable.thumbnail8,
                R.drawable.thumbnail9,
                R.drawable.thumbnail10,
                R.drawable.thumbnail11
            )
            val randomIndex = remember { Random.nextInt(thumbnails.size) }

            Card(
                modifier = Modifier
                    .padding(top = 25.dp, start = 8.dp, end = 8.dp)
                    .fillMaxWidth()
            ) {
                Box {
                    Image(
                        painter = painterResource(id = thumbnails[randomIndex]),
                        contentDescription = "thumbnail",
                        contentScale = ContentScale.Crop, // Crop the image to fill the width
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp), // Set a fixed height for the card
                        colorFilter = ColorFilter.tint(
                            Color.Cyan.copy(alpha = 0.3f),
                            blendMode = BlendMode.SrcAtop
                        )
                    )


                    Column(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(top = 18.dp, start = 16.dp)
                    ) {
                        Text(
                            text = "WELCOME.",
                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.interbold)),
                            fontSize = 32.sp,
                            modifier = Modifier.padding(bottom = 5.dp)
                        )
                        Text(
                            text = "A world of movies and TV series, where every story unfolds.",
                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.robotomedium)),
                            fontSize = 21.sp
                        )
                        Text(
                            text = "Explore now.",
                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.robotomedium)),
                            fontSize = 21.sp
                        )
                    }
                }
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
                LazyRowMoviesDesign(popularMovies, "Popular Movies", goToMovieDescScreen)
            }


            if (popularSeries == null) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp), contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else { // last content of page
                LazyRowSeriesDesign(popularSeries, "Popular Series", goToSeriesDescScreen)
                Spacer(modifier = Modifier.padding(top=100.dp))
            }
        }
        BottomNavigatorDesign(navController,goToHomeScreen,goToMovieTabScreen, goToSeriesTabScreen)
    }
}