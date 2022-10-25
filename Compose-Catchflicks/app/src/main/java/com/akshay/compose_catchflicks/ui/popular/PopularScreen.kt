package com.akshay.compose_catchflicks.ui.popular

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.akshay.compose_catchflicks.ui.components.MovieTileCard
import com.akshay.compose_catchflicks.ui.theme.backgroundColor

/**
 * Created by anandwana001 on
 * 17, July, 2022
 **/
@Composable
fun PopularScreen(viewModel: PopularViewModel) {
    val data by viewModel.movieStateData.collectAsState(listOf())

    LazyColumn(modifier = Modifier.background(backgroundColor)) {
        data?.let {
            itemsIndexed(it) { index, item ->
                MovieTileCard(
                    Modifier,
                    item.title,
                    item.overview,
                    item.vote_average,
                    item.poster_path
                )
                if(index == it.size - 1) {
                    Spacer(modifier = Modifier.fillMaxWidth().height(100.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun show() {
    LazyColumn(modifier = Modifier.background(backgroundColor)) {
        items(5) {
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
