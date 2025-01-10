package com.example.showspotter.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.showspotter.R

@Composable
fun Pager() {
    val imageList = listOfNotNull(
        R.drawable.image8,
        R.drawable.image5,
        R.drawable.image3,
        R.drawable.image10,
        R.drawable.image1,
        R.drawable.image6,
        R.drawable.image7,
        R.drawable.image9,
        R.drawable.image2
    )

    val pagerState = rememberPagerState(pageCount = {
        imageList.size
    })

    LaunchedEffect(key1 = pagerState) {
        while (true) {
            kotlinx.coroutines.delay(4000L)
            val nextPage = (pagerState.currentPage + 1) % imageList.size
            pagerState.animateScrollToPage(nextPage)
        }
    }


    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize(),
        userScrollEnabled = false // Disable user interaction
    ) { page ->
        Image(
            painter = painterResource(id = imageList[page]),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}
