package com.example.showspotter.designs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.rememberAsyncImagePainter
import com.example.showspotter.tmdbapidataclass.Movie.PopularTopRatedTrendingOnTheAirMoviesData
//import com.example.showspotter.tmdbapidataclass.Result
import com.example.showspotter.R
import com.example.showspotter.tmdbMVVM.ViewModel
import com.example.showspotter.tmdbapidataclass.Movie.MovieNowPlayingResult
import com.example.showspotter.tmdbapidataclass.Movie.MoviesNowPlayingData
import com.example.showspotter.tmdbapidataclass.Movie.PopularTopRatedTrendingMoviesResult
//import com.example.showspotter.tmdbapidataclass.Movie.PopularTopRatedMoviesResult
import com.example.showspotter.tmdbapidataclass.Series.PopularTopRatedTrendingOnTheAirSeriesData
import com.example.showspotter.tmdbapidataclass.Series.PopularSeriesResult
import kotlin.math.roundToInt

@Composable
fun LazyRowMoviesDesign(movies: PopularTopRatedTrendingOnTheAirMoviesData?, heading:String, goToMovieDescScreen:(id:Int)->Unit) {
    if(movies != null) {
        val result: List<PopularTopRatedTrendingMoviesResult> = movies.results
        Box( modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1f1f1f)) ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
                    .padding(start = 7.dp, end = 7.dp, top = 30.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFF2e2d2d)),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = heading,
                    modifier = Modifier.padding(top = 10.dp, start = 15.dp, bottom = 10.dp),
                    color = Color(0xFFE0E0E0),
                    fontFamily = FontFamily(Font(R.font.interbold)),
                    fontSize = 20.sp
                )
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp)
                        .background(Color(0xFF2e2d2d))
                ) {
                    items(result) {
                        Card(
                            modifier = Modifier
                                .padding(start = 4.dp, end = 4.dp)
                                .width(120.dp)
                                .height(280.dp)
                                .clickable(
                                    onClick = {
                                        //when a movie thumbnail got clicked
                                        //for easy we will only send id to next page
                                        goToMovieDescScreen(it.id)
                                    }
                                )
                        ) {
                            Card(modifier = Modifier.background(Color(0xFF2e2d2d))) {
                                Image(
                                    painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/w300/${it.poster_path}"),
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxWidth(),
                                    contentScale = ContentScale.FillWidth
                                )
                            }
                            Column(
                                verticalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .background(Color(0xFF2e2d2d))
                                    .padding(8.dp)
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                            ) {
                                Text(
                                    text = it.title,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 2.dp, bottom = 10.dp)
                                        .align(Alignment.Start),
                                    color = Color(0xFFE0E0E0),
                                    fontFamily = FontFamily(Font(R.font.interfont)),
                                    fontSize = 16.sp,
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Row(
                                    modifier = Modifier
                                        .padding(2.dp)
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Image(
                                            painterResource(id = R.drawable.star),
                                            contentDescription = null,
                                            modifier = Modifier.size(13.dp)
                                        )
                                        Text(
                                            text = ((it.vote_average * 10).roundToInt() / 10.0).toString(),
                                            color = Color(0xFF7091C2),
                                            fontFamily = FontFamily(Font(R.font.robotolight)),
                                            modifier = Modifier.padding(start = 2.dp)
                                        )
                                    }
                                    Text(
                                        text = it.release_date.substring(0, 4),
                                        color = Color(0xFF7091C2),
                                        fontFamily = FontFamily(Font(R.font.robotolight)),
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LazyRowNowPlayingMoviesDesign(movies: MoviesNowPlayingData?, heading:String, goToMovieDescScreen:(id:Int)->Unit) {
    if(movies != null) {
        val result: List<MovieNowPlayingResult> = movies.results
        Box( modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1f1f1f)) ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
                    .padding(start = 7.dp, end = 7.dp, top = 30.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFF2e2d2d)),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = heading,
                    modifier = Modifier.padding(top = 10.dp, start = 15.dp, bottom = 10.dp),
                    color = Color(0xFFE0E0E0),
                    fontFamily = FontFamily(Font(R.font.interbold)),
                    fontSize = 20.sp
                )
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp)
                        .background(Color(0xFF2e2d2d))
                ) {
                    items(result) {
                        Card(
                            modifier = Modifier
                                .padding(start = 4.dp, end = 4.dp)
                                .width(120.dp)
                                .height(280.dp)
                                .clickable(
                                    onClick = {
                                        //when a movie thumbnail got clicked
                                        //for easy we will only send id to next page
                                        goToMovieDescScreen(it.id)
                                    }
                                )
                        ) {
                            Card(modifier = Modifier.background(Color(0xFF2e2d2d))) {
                                Image(
                                    painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/w300/${it.poster_path}"),
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxWidth(),
                                    contentScale = ContentScale.FillWidth
                                )
                            }
                            Column(
                                verticalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .background(Color(0xFF2e2d2d))
                                    .padding(8.dp)
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                            ) {
                                Text(
                                    text = it.title,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 2.dp, bottom = 10.dp)
                                        .align(Alignment.Start),
                                    color = Color(0xFFE0E0E0),
                                    fontFamily = FontFamily(Font(R.font.interfont)),
                                    fontSize = 16.sp,
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Row(
                                    modifier = Modifier
                                        .padding(2.dp)
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Image(
                                            painterResource(id = R.drawable.star),
                                            contentDescription = null,
                                            modifier = Modifier.size(13.dp)
                                        )
                                        Text(
                                            text = ((it.vote_average * 10).roundToInt() / 10.0).toString(),
                                            color = Color(0xFF7091C2),
                                            fontFamily = FontFamily(Font(R.font.robotolight)),
                                            modifier = Modifier.padding(start = 2.dp)
                                        )
                                    }
                                    Text(
                                        text = it.release_date.substring(0, 4),
                                        color = Color(0xFF7091C2),
                                        fontFamily = FontFamily(Font(R.font.robotolight)),
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LazyRowSeriesDesign(movies: PopularTopRatedTrendingOnTheAirSeriesData?, heading: String, goToSeriesDescScreen:(id:Int)->Unit) {
    if(movies != null) {
        val result: List<PopularSeriesResult> = movies.results
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .padding(start = 7.dp, end = 7.dp,top=30.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFF2e2d2d)),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = heading,
                modifier = Modifier.padding(top = 10.dp, start = 15.dp, bottom = 10.dp),
                color = Color(0xFFE0E0E0),
                fontFamily = FontFamily(Font(R.font.interbold)),
                fontSize = 20.sp
            )
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start=8.dp)
                    .background(Color(0xFF2e2d2d))
            ) {
                items(result) {
                    Card(
                        modifier = Modifier
                            .padding(start = 4.dp, end = 4.dp)
                            .width(120.dp)
                            .height(280.dp)
                            .clickable(
                                onClick = {
                                    //when a movie thumbnail got clicked
                                    //for easy we will only send id to next page
                                    goToSeriesDescScreen(it.id)
                                }
                            )
                    ) {
                        Card(modifier = Modifier.background(Color(0xFF2e2d2d))) {
                            Image(
                                painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/w300/${it.poster_path}"),
                                contentDescription = null,
                                modifier = Modifier.fillMaxWidth(),
                                contentScale = ContentScale.FillWidth
                            )
                        }
                        Column(
                            verticalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .background(Color(0xFF2e2d2d))
                                .padding(8.dp)
                                .fillMaxWidth()
                                .fillMaxHeight()
                        ) {
                            Text(
                                text = it.name,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 2.dp, bottom = 10.dp)
                                    .align(Alignment.Start),
                                color = Color(0xFFE0E0E0),
                                fontFamily = FontFamily(Font(R.font.interfont)),
                                fontSize = 16.sp,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                            Row(
                                modifier = Modifier
                                    .padding(2.dp)
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Image(
                                        painterResource(id = R.drawable.star),
                                        contentDescription = null,
                                        modifier = Modifier.size(13.dp)
                                    )
                                    Text(
                                        text = ((it.vote_average * 10).roundToInt() / 10.0).toString(),
                                        color = Color(0xFF7091C2),
                                        fontFamily = FontFamily(Font(R.font.robotolight)),
                                        modifier = Modifier.padding(start = 2.dp)
                                    )
                                }
                                Text(
                                    text = it.first_air_date.substring(0, 4),
                                    color = Color(0xFF7091C2),
                                    fontFamily = FontFamily(Font(R.font.robotolight)),
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}