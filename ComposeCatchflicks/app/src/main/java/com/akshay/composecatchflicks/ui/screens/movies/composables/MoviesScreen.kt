package com.akshay.composecatchflicks.ui.screens.movies.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.akshay.composecatchflicks.ui.component.MovieTileCard
import com.akshay.composecatchflicks.ui.screens.movies.viewmodel.MoviesViewModel
import com.akshay.composecatchflicks.ui.theme.ComposeCatchflicksTheme
import com.akshay.composecatchflicks.ui.theme.screenBackgroundColor

/**
 * Created by anandwana001 on
 * 08, November, 2022
 **/
@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun MoviesScreen(
    modifier: Modifier = Modifier, viewModel: MoviesViewModel,
    navController: NavHostController,
) {
    val data = viewModel.movieStateData.collectAsStateWithLifecycle().value
    LazyColumn(modifier = modifier.background(screenBackgroundColor)) {
        itemsIndexed(data.listOfMovies) { index, item ->
            MovieTileCard(
                modifier.clickable {
                    navController.navigate("detail/${item.id}") {
                        popUpTo("movies")
                    }
                },
                item
            )
            if (index == data.listOfMovies.size - 1) {
                Spacer(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(50.dp)
                )
                //viewModel.onEvent(MovieEvent.IncrementPageNumber(data.currentPage + 1))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MoviesScreenPreview() {
    ComposeCatchflicksTheme() {
        val viewModel = hiltViewModel<MoviesViewModel>()
        MoviesScreen(
            navController = rememberNavController(),
            viewModel = viewModel
        )
    }
}
