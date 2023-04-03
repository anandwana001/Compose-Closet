package com.akshay.composecatchflicks.ui.screens.movies.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.akshay.composecatchflicks.domain.model.Movie
import com.akshay.composecatchflicks.ui.component.MovieDescription
import com.akshay.composecatchflicks.ui.component.MovieRating
import com.akshay.composecatchflicks.ui.component.MovieThumbnailCard
import com.akshay.composecatchflicks.ui.component.MovieTitle

/**
 * Created by anandwana001 on
 * 03, April, 2023
 **/
@Composable
fun NowPlayingCard(
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
            .width(300.dp)
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
