package com.akshay.composecatchflicks.ui.screens.movies

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.akshay.composecatchflicks.ui.component.MovieTileCard
import com.akshay.composecatchflicks.ui.theme.ComposeCatchflicksTheme
import com.akshay.composecatchflicks.ui.theme.screenBackgroundColor

/**
 * Created by anandwana001 on
 * 08, November, 2022
 **/
@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun MoviesScreen(modifier: Modifier = Modifier, viewModel: MoviesViewModel = hiltViewModel()) {
    val data by viewModel.movieStateData.collectAsStateWithLifecycle()
    LazyColumn(modifier = modifier.background(screenBackgroundColor)) {
        data.let {
            itemsIndexed(it) { index, item ->
                MovieTileCard(
                    modifier,
                    item.title,
                    item.overview,
                    item.vote_average,
                    item.poster_path
                )
                if (index == it.size - 1) {
                    Spacer(
                        modifier = modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MoviesScreenPreview() {
    ComposeCatchflicksTheme() {
        MoviesScreen()
    }
}
