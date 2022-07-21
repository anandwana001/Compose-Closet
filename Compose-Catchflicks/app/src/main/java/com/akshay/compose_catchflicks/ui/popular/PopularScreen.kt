package com.akshay.compose_catchflicks.ui.popular

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.akshay.compose_catchflicks.ui.components.MovieTileCard

/**
 * Created by anandwana001 on
 * 17, July, 2022
 **/
@Composable
fun PopularScreen(viewModel: PopularViewModel) {
    val data by viewModel.movieStateData.collectAsState(listOf())

    LazyColumn {
        data?.let {
            items(it) {
                MovieTileCard(
                    Modifier,
                    it.title,
                    it.overview,
                    it.vote_average,
                    it.poster_path
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun show() {
    LazyColumn {
        items(5) { item ->
            MovieTileCard(
                Modifier,
                "Aladdin",
                "A kindhearted street urchin named Aladdin embarks on a magical adventure after finding a lamp that releases a wisecracking genie while a power-hungry Grand Vizier vies for the same lamp that has the power to make their deepest wishes come true.",
                9.8F,
                "/wKiOkZTN9lUUUNZLmtnwubZYONg.jpg"
            )
        }
    }
}
