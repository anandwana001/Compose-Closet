package com.akshay.composecatchflicks.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.akshay.composecatchflicks.ui.theme.CatchflicksBoldFont
import com.akshay.composecatchflicks.ui.theme.CatchflicksFont

/**
 * Created by anandwana001 on
 * 14, November, 2022
 **/
@Composable
fun MovieTileCard(
    modifier: Modifier,
    movieName: String,
    movieDes: String,
    movieRating: Float,
    posterThumbnail: String?
) {
    Box(
        modifier = modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp)
    ) {
        MovieTileDetail(modifier, movieName, movieDes, movieRating)
        MovieThumbnailCard(modifier, posterThumbnail)
    }
}

@Composable
fun MovieTileDetail(
    modifier: Modifier,
    movieName: String,
    movieDes: String,
    movieRating: Float,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 45.dp)
            .height(200.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = modifier
                .padding(start = 150.dp)
        ) {
            MovieRating(modifier, movieRating)
            MovieTitle(modifier, movieName)
            MovieDescription(modifier, movieDes)
        }
    }
}

@Composable
fun MovieThumbnailCard(modifier: Modifier, posterThumbnail: String?) {
    Card(
        modifier = modifier
            .padding(start = 16.dp, top = 16.dp, end = 8.dp, bottom = 24.dp)
            .width(120.dp)
            .height(200.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        posterThumbnail?.let {
            Image(
                painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/original" + it),
                contentDescription = "",
                modifier = modifier.fillMaxHeight(),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun MovieTitle(modifier: Modifier, movieName: String) {
    Text(
        modifier = modifier
            .fillMaxWidth(),
        text = movieName,
        maxLines = 2,
        style = MaterialTheme.typography.titleMedium,
        fontFamily = CatchflicksBoldFont
    )
}

@Composable
fun MovieRating(modifier: Modifier, movieRating: Float) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(end = 8.dp, top = 8.dp),
        text = movieRating.toString(),
        textAlign = TextAlign.End,
        style = MaterialTheme.typography.bodyMedium,
        color = Color(0xFFffbc03),
        fontFamily = CatchflicksBoldFont
    )
}

@Composable
fun MovieDescription(modifier: Modifier, movieDes: String) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(end = 8.dp, top = 16.dp, bottom = 24.dp),
        text = movieDes,
        maxLines = 3,
        style = MaterialTheme.typography.titleSmall,
        color = Color(0xFFffbc03),
        overflow = TextOverflow.Ellipsis,
        fontFamily = CatchflicksFont
    )
}

@Preview(showBackground = true)
@Composable
fun MovieTileCardPreview() {
    MovieTileCard(
        Modifier,
        "Aladdin",
        "A kindhearted street urchin named Aladdin embarks on a magical adventure after finding a lamp that releases a wisecracking genie while a power-hungry Grand Vizier vies for the same lamp that has the power to make their deepest wishes come true.",
        9.8F,
        "https://github.com/anandwana001/catchflicks/blob/master/app/src/main/res/drawable/poster_sample.jpg?raw=true"
    )
}
