package com.akshay.composecatchflicks.ui.screens.moviedetail.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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
    movieDetailViewModel: MovieDetailViewModel = hiltViewModel()
) {
    val detail by movieDetailViewModel.movieStateData.collectAsStateWithLifecycle()
    Column(modifier = modifier.fillMaxSize()) {

    }
}

@Preview(showBackground = true)
@Composable
private fun DetailScreenPreview() {
    ComposeCatchflicksTheme {
        MovieDetailScreen()
    }
}
