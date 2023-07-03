package com.akshay.composecatchflicks.ui.screens.movies.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.akshay.composecatchflicks.R
import com.akshay.composecatchflicks.domain.model.Movie
import com.akshay.composecatchflicks.ui.component.ListTitle
import com.akshay.composecatchflicks.ui.theme.Purple40
import com.akshay.composecatchflicks.ui.theme.screenBackgroundColor

/**
 * Created by anandwana001 on
 * 08, November, 2022
 **/
@Composable
fun MoviesScreen(
    modifier: Modifier = Modifier,
    data: LazyPagingItems<Movie>,
    nowPlaying: LazyPagingItems<Movie>,
    upcoming: LazyPagingItems<Movie>,
    popTo: (Int) -> Unit,
) {
    LazyColumn(
        modifier = modifier
            .background(screenBackgroundColor)
            .fillMaxHeight()
    ) {
        showUpcomingMovies(nowPlaying, modifier, popTo)
        showNowPlayingMovies(upcoming, modifier, popTo)
        showPopularMovies(data, modifier, popTo)
    }
}

private fun LazyListScope.showPopularMovies(
    data: LazyPagingItems<Movie>,
    modifier: Modifier,
    popTo: (Int) -> Unit,
) {
    when (data.loadState.refresh) {
        LoadState.Loading -> {
            item { ShowLoading(modifier = modifier) }
        }
        else -> {
            item {
                ListTitle(R.string.popular_movies)
            }
            items(items = data.itemSnapshotList) { item ->
                item?.let {
                    MovieTileCard(
                        modifier = modifier.navigate(it.id, popTo),
                        movie = it
                    )
                }
            }
        }
    }
}

private fun LazyListScope.showUpcomingMovies(
    nowPlaying: LazyPagingItems<Movie>,
    modifier: Modifier,
    popTo: (Int) -> Unit,
) {
    when (nowPlaying.loadState.refresh) {
        LoadState.Loading -> {
            item { ShowLoading(modifier = modifier) }
        }
        else -> {
            item {
                ListTitle(R.string.now_playing_movies)
                LazyRow {
                    items(items = nowPlaying.itemSnapshotList) { item ->
                        item?.let {
                            NowPlayingCard(
                                modifier = modifier.navigate(it.id, popTo),
                                movie = it
                            )
                        }
                    }
                }
            }
        }
    }
}

private fun LazyListScope.showNowPlayingMovies(
    upcoming: LazyPagingItems<Movie>,
    modifier: Modifier,
    popTo: (Int) -> Unit,
) {
    when (upcoming.loadState.refresh) {
        LoadState.Loading -> {
            item { ShowLoading(modifier = modifier) }
        }
        else -> {
            item {
                ListTitle(R.string.upcoming_movies)
                LazyRow {
                    items(items = upcoming.itemSnapshotList) { item ->
                        item?.let {
                            NowPlayingCard(
                                modifier = modifier.navigate(it.id, popTo),
                                movie = it
                            )
                        }
                    }
                }
            }
        }
    }
}

private fun Modifier.navigate(id: Int?, popTo: (Int) -> Unit) = clickable {
    id?.let { popTo(it) }
}

@Composable
private fun ShowLoading(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "Loading")
        Spacer(modifier = Modifier.height(4.dp))
        CircularProgressIndicator(color = Purple40)
    }
}
