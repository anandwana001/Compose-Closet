package com.akshay.composecatchflicks.ui.screens.movies.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.akshay.composecatchflicks.R
import com.akshay.composecatchflicks.ui.component.ListTitle
import com.akshay.composecatchflicks.ui.component.MovieTileCard
import com.akshay.composecatchflicks.ui.screens.movies.viewmodel.MoviesViewModel
import com.akshay.composecatchflicks.ui.theme.Purple40
import com.akshay.composecatchflicks.ui.theme.screenBackgroundColor

/**
 * Created by anandwana001 on
 * 08, November, 2022
 **/
@Composable
fun MoviesScreen(
    modifier: Modifier = Modifier, viewModel: MoviesViewModel,
    navController: NavHostController,
) {
    val data = viewModel.list.collectAsLazyPagingItems()
    val nowPlaying = viewModel.nowPlayingMoviesList.collectAsLazyPagingItems()
    val upcoming = viewModel.upcomingMoviesList.collectAsLazyPagingItems()
    LazyColumn(
        modifier = modifier
            .background(screenBackgroundColor)
            .fillMaxHeight()
    ) {
        item {
            ListTitle(R.string.now_playing_movies)
            LazyRow {
                items(nowPlaying) { item ->
                    item?.let {
                        NowPlayingCard(
                            modifier = modifier.clickable {
                                navController.navigate("detail/${it.id}") {
                                    popUpTo("movies")
                                }
                            },
                            movie = it
                        )
                    }
                }
            }
        }

        item {
            ListTitle(R.string.upcoming_movies)
            LazyRow {
                items(upcoming) { item ->
                    item?.let {
                        NowPlayingCard(
                            modifier = modifier.clickable {
                                navController.navigate("detail/${it.id}") {
                                    popUpTo("movies")
                                }
                            },
                            movie = it
                        )
                    }
                }
            }
        }

        item {
            ListTitle(R.string.popular_movies)
        }
        items(data) { item ->
            item?.let {
                MovieTileCard(
                    modifier = modifier.clickable {
                        navController.navigate("detail/${it.id}") {
                            popUpTo("movies")
                        }
                    },
                    movie = it
                )
            }
        }
        when (data.loadState.refresh) {
            is LoadState.Error -> {}
            is LoadState.Loading -> {
                item { ShowLoading(modifier = modifier) }
            }
            else -> {}
        }
    }
}

@Composable
private fun ShowLoading(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "Loading")
        CircularProgressIndicator(color = Purple40)
    }
}
