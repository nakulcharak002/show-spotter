package com.example.showspotter.designs

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.example.showspotter.R

@Composable
fun YouTubePlayerTrailer(videoId: String) {
    val context = LocalContext.current

    // YouTube Thumbnail URL
    val thumbnailUrl = "https://img.youtube.com/vi/$videoId/hqdefault.jpg"

    // Thumbnail with Clickable Behavior
    Box(
        modifier = Modifier
            .fillMaxWidth() // Set desired height
            .clickable {
                // Intent to open YouTube video
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.youtube.com/watch?v=$videoId")
                )
                context.startActivity(intent)
            }
    ) {
        // Load the Thumbnail Image
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Image(
                painter = rememberAsyncImagePainter(model = thumbnailUrl),
                contentDescription = "YouTube Video Thumbnail",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Image(painter = painterResource(id = R.drawable.play),contentDescription = "play",
                modifier = Modifier.size(50.dp))
        }
    }
}

@Composable
fun YouTubePlayerVideos(videoId: String) {
    val context = LocalContext.current

    // YouTube Thumbnail URL
    val thumbnailUrl = "https://img.youtube.com/vi/$videoId/maxresdefault.jpg"

    // Thumbnail with Clickable Behavior
    Box(
        modifier = Modifier // Set desired height
            .clickable {
                // Intent to open YouTube video
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.youtube.com/watch?v=$videoId")
                )
                context.startActivity(intent)
            }
            .padding(horizontal = 10.dp)
            .clip(RoundedCornerShape(10.dp))
    ) {
        // Load the Thumbnail Image
            Image(
                painter = rememberAsyncImagePainter(model = thumbnailUrl),
                contentDescription = "YouTube Video Thumbnail",
                modifier = Modifier.width(240.dp).height(135.dp),
                contentScale = ContentScale.Crop
            )
    }
}
@Composable
fun YouTubePlayerAllVideos(videoId: String) {
    val context = LocalContext.current

    // YouTube Thumbnail URL
    val thumbnailUrl = "https://img.youtube.com/vi/$videoId/maxresdefault.jpg"

    // Thumbnail with Clickable Behavior
    Box(
        modifier = Modifier // Set desired height
            .clickable {
                // Intent to open YouTube video
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.youtube.com/watch?v=$videoId")
                )
                context.startActivity(intent)
            }
            .padding(horizontal = 10.dp)
            .clip(RoundedCornerShape(10.dp))
    ) {
        // Load the Thumbnail Image
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

            Image(
                painter = rememberAsyncImagePainter(model = thumbnailUrl),
                contentDescription = "YouTube Video Thumbnail",
                modifier = Modifier.fillMaxWidth().height(200.dp),
                contentScale = ContentScale.Crop
            )
            Image(painter = painterResource(id = R.drawable.play),contentDescription = "play",
                modifier = Modifier.size(50.dp))
        }
    }
}




