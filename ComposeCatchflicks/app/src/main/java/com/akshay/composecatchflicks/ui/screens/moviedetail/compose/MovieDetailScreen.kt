package com.akshay.composecatchflicks.ui.screens.moviedetail.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberAsyncImagePainter
import com.akshay.composecatchflicks.ui.screens.moviedetail.viewModel.MovieDetailViewModel
import com.akshay.composecatchflicks.ui.theme.ComposeCatchflicksTheme

/**
 * Created by anandwana001 on
 * 15, December, 2022
 **/
@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun MovieDetailScreen(
    modifier: Modifier = Modifier,
    movieDetailViewModel: MovieDetailViewModel
) {
    val detail by movieDetailViewModel.movieStateData.collectAsStateWithLifecycle()
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState(),
            )
    ) {
        Image(
            painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/original" + detail.backdropPath),
            contentDescription = "",
            modifier = modifier
                .fillMaxWidth()
                .aspectRatio(1.0f),
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = modifier.padding(16.dp),
            text = detail.title ?: ""
        )
        Text(
            modifier = modifier.padding(16.dp),
            text = "Story Line"
        )
        Text(
            modifier = modifier.padding(16.dp),
            text = detail.overview ?: ""
        )
        Text(
            modifier = modifier.padding(16.dp),
            text = "Genres"
        )
        LazyRow(content = {
            items(detail.genres.size) { index ->
                Text(
                    modifier = modifier.padding(16.dp),
                    text = detail.genres[index].name
                )
            }
        })
        Spacer(modifier = modifier.height(50.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailScreenPreview() {
    ComposeCatchflicksTheme {
        val viewModel = hiltViewModel<MovieDetailViewModel>()
        MovieDetailScreen(movieDetailViewModel = viewModel)
    }
}
