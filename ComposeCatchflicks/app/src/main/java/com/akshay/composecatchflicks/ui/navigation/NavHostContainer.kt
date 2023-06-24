package com.akshay.composecatchflicks.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.paging.compose.collectAsLazyPagingItems
import com.akshay.composecatchflicks.ui.screens.moviedetail.compose.MovieDetailScreen
import com.akshay.composecatchflicks.ui.screens.moviedetail.viewModel.MovieDetailViewModel
import com.akshay.composecatchflicks.ui.screens.movies.composables.MoviesScreen
import com.akshay.composecatchflicks.ui.screens.movies.viewmodel.MoviesViewModel
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
    val viewModel = hiltViewModel<MoviesViewModel>()
    NavHost(
        navController = navController,
        startDestination = ComposeCatchflicksCategory.MOVIE.route,
        modifier = Modifier.padding(paddingValues),
        builder = {
            composable("movies") {
                val data = viewModel.list.collectAsLazyPagingItems()
                val nowPlaying = viewModel.nowPlayingMoviesList.collectAsLazyPagingItems()
                val upcoming = viewModel.upcomingMoviesList.collectAsLazyPagingItems()
                MoviesScreen(
                    data = data,
                    nowPlaying = nowPlaying,
                    upcoming = upcoming,
                ) { id ->
                    navController.navigate("detail/${id}") {
                        popUpTo("movies")
                    }
                }
            }
            composable("tv") {
                TvScreen()
            }
            composable("search") {
                SearchScreen()
            }
            composable(
                "detail/{movieId}",
                arguments = listOf(navArgument("movieId") { type = NavType.IntType })
            ) {
                val movieDetailViewModel = hiltViewModel<MovieDetailViewModel>()
                val detail = movieDetailViewModel.movieStateData.collectAsStateWithLifecycle()
                MovieDetailScreen(detail = detail)
            }
        })
}