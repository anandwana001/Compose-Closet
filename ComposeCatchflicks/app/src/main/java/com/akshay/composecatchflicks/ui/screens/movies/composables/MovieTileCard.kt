package com.akshay.composecatchflicks.ui.screens.movies.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.akshay.composecatchflicks.R
import com.akshay.composecatchflicks.domain.model.Movie
import com.akshay.composecatchflicks.ui.theme.Purple80
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
private fun MovieTileDetail(
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
    posterThumbnail?.let {
        val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://image.tmdb.org/t/p/original$it")
                .diskCachePolicy(CachePolicy.ENABLED)
                .size(200, 380)
                .build()
        )
        val painterRem by remember(posterThumbnail) {
            mutableStateOf(painter)
        }
        when (painterRem.state) {
            is AsyncImagePainter.State.Success -> {
                Card(
                    modifier = modifier
                        .padding(start = 16.dp, top = 16.dp, end = 8.dp, bottom = 24.dp)
                        .width(120.dp)
                        .height(200.dp),
                    shape = RoundedCornerShape(8.dp),
                    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Image(
                        painter = painterRem,
                        contentDescription = "",
                        modifier = modifier.fillMaxHeight(),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            is AsyncImagePainter.State.Error -> {
                Box(
                    modifier = modifier
                        .padding(start = 16.dp, top = 16.dp, end = 8.dp, bottom = 24.dp)
                        .width(120.dp)
                        .height(200.dp),
                ) {
                    Icon(
                        modifier = Modifier
                            .align(Alignment.Center),
                        painter = painterResource(id = R.drawable.baseline_movie_24),
                        contentDescription = null,
                    )
                }
            }

            is AsyncImagePainter.State.Loading -> {
                Box(
                    modifier = modifier
                        .padding(start = 16.dp, top = 16.dp, end = 8.dp, bottom = 24.dp)
                        .width(120.dp)
                        .height(200.dp),
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .align(Alignment.Center),
                        color = Purple80
                    )
                }
            }

            else -> Unit
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
            color = Color.Black,
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
