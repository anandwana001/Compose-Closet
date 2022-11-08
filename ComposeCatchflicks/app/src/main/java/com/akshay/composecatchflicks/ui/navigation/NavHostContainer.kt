package com.akshay.composecatchflicks.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.akshay.composecatchflicks.ui.screens.movies.MoviesScreen
import com.akshay.composecatchflicks.ui.screens.search.SearchScreen
import com.akshay.composecatchflicks.ui.screens.tv.TvScreen

/**
 * Created by anandwana001 on
 * 08, November, 2022
 **/
@Composable
fun NavHostContainer(
    navController: NavHostController,
    paddingValues: PaddingValues,
) {
    NavHost(
        navController = navController,
        startDestination = ComposeCatchflicksCategory.MOVIE.route,
        modifier = Modifier.padding(paddingValues),
        builder = {
            composable("movies") {
                MoviesScreen()
            }
            composable("tv") {
                TvScreen()
            }
            composable("search") {
                SearchScreen()
            }
        })
}