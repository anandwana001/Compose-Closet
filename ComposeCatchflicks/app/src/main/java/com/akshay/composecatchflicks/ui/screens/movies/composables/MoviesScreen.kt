package com.akshay.composecatchflicks.ui.screens.movies.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.akshay.composecatchflicks.ui.component.MovieTileCard
import com.akshay.composecatchflicks.ui.screens.movies.data.MovieState
import com.akshay.composecatchflicks.ui.theme.screenBackgroundColor

/**
 * Created by anandwana001 on
 * 08, November, 2022
 **/
@Composable
fun MoviesScreen(
    modifier: Modifier = Modifier, data: MovieState,
    navController: NavHostController,
) {
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
        }
    }
}
