package com.akshay.compose_catchflicks.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.akshay.compose_catchflicks.ui.theme.catchflicksBoldFont
import com.akshay.compose_catchflicks.ui.theme.catchflicksFont

/**
 * Created by anandwana001 on
 * 13, July, 2022
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
        modifier = modifier.padding(start = 16.dp, end = 16.dp)
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
            .padding(top = 60.dp)
            .height(200.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = modifier
                .padding(start = 150.dp)
        ) {
            movieRating(modifier, movieRating)
            movieTitle(modifier, movieName)
            movieDescription(modifier, movieDes)
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
        elevation = 10.dp
    ) {
        posterThumbnail?.let {
            Image(
                painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/original" + it),
                contentDescription = "",
                modifier = Modifier,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun movieTitle(modifier: Modifier, movieName: String) {
    Text(
        modifier = modifier
            .fillMaxWidth(),
        text = movieName,
        maxLines = 2,
        style = MaterialTheme.typography.h6,
        fontFamily = catchflicksBoldFont
    )
}

@Composable
fun movieRating(modifier: Modifier, movieRating: Float) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(end = 8.dp, top = 8.dp),
        text = movieRating.toString(),
        textAlign = TextAlign.End,
        style = MaterialTheme.typography.h6,
        color = Color(0xFFffbc03),
        fontFamily = catchflicksBoldFont
    )
}

@Composable
fun movieDescription(modifier: Modifier, movieDes: String) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(end = 8.dp, top = 16.dp, bottom = 24.dp),
        text = movieDes,
        maxLines = 5,
        style = MaterialTheme.typography.subtitle2,
        color = Color(0xFFffbc03),
        overflow = TextOverflow.Ellipsis,
        fontFamily = catchflicksFont
    )
}

@Preview(showBackground = true)
@Composable
fun movieTile() {
    MovieTileCard(
        Modifier,
        "Aladdin",
        "A kindhearted street urchin named Aladdin embarks on a magical adventure after finding a lamp that releases a wisecracking genie while a power-hungry Grand Vizier vies for the same lamp that has the power to make their deepest wishes come true.",
        9.8F,
        "https://github.com/anandwana001/catchflicks/blob/master/app/src/main/res/drawable/poster_sample.jpg?raw=true"
    )
}
