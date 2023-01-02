package com.akshay.composecatchflicks.ui.screens.movies

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.core.os.bundleOf
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.akshay.composecatchflicks.ui.component.MovieTileCard
import com.akshay.composecatchflicks.ui.navigation.ComposeCatchflicksCategory
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
    modifier: Modifier = Modifier, viewModel: MoviesViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val data by viewModel.movieStateData.collectAsStateWithLifecycle()
    LazyColumn(modifier = modifier.background(screenBackgroundColor)) {
        itemsIndexed(data) { index, item ->
            MovieTileCard(
                modifier.clickable {
                    navController.navigate("detail/${item.id}") {
                        popUpTo("movies")
                    }
                },
                item
            )
            if (index == data.size - 1) {
                Spacer(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(50.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MoviesScreenPreview() {
    ComposeCatchflicksTheme() {
        MoviesScreen(navController = rememberNavController())
    }
}
