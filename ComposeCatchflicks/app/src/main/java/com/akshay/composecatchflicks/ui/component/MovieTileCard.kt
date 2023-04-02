package com.akshay.composecatchflicks.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.akshay.composecatchflicks.domain.model.Movie
import com.akshay.composecatchflicks.ui.theme.textColor

/**
 * Created by anandwana001 on
 * 14, November, 2022
 **/
@Composable
fun MovieTileCard(
    modifier: Modifier,
    movie: Movie,
) {
    Box(
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        MovieTileDetail(modifier, movie.title, movie.overview, movie.voteAverage)
        MovieThumbnailCard(modifier, movie.posterPath)
    }
}

@Composable
fun MovieTileDetail(
    modifier: Modifier,
    movieName: String?,
    movieDes: String?,
    movieRating: Float?,
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
                .fillMaxWidth()
                .padding(start = 140.dp)
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
fun MovieTitle(modifier: Modifier, movieName: String?) {
    movieName?.let {
        Text(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            text = it,
            maxLines = 2,
            fontSize = 16.sp,
            lineHeight = 22.sp,
            style = MaterialTheme.typography.headlineLarge
        )
    }
}

@Composable
fun MovieRating(modifier: Modifier, movieRating: Float?) {
    movieRating?.let {
        Text(
            modifier = modifier
                .fillMaxWidth()
                .padding(end = 8.dp, top = 8.dp),
            text = it.toString(),
            textAlign = TextAlign.End,
            fontSize = 14.sp,
            maxLines = 1,
            style = MaterialTheme.typography.headlineSmall,
            color = textColor,
        )
    }
}

@Composable
fun MovieDescription(modifier: Modifier, movieDes: String?) {
    movieDes?.let {
        Text(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp, top = 16.dp, bottom = 24.dp),
            text = it,
            maxLines = 3,
            style = MaterialTheme.typography.bodyLarge,
            color = textColor,
            overflow = TextOverflow.Ellipsis,
            fontSize = 14.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MovieTileCardPreview() {
    MovieTileCard(
        Modifier,
        Movie(
            title = "Aladdin",
            overview = "A kindhearted street urchin named Aladdin embarks on a magical adventure after finding a lamp that releases a wisecracking genie while a power-hungry Grand Vizier vies for the same lamp that has the power to make their deepest wishes come true.",
            voteAverage = 9.8f,
            posterPath = "https://github.com/anandwana001/catchflicks/blob/master/app/src/main/res/drawable/poster_sample.jpg?raw=true"
        )
    )
}
