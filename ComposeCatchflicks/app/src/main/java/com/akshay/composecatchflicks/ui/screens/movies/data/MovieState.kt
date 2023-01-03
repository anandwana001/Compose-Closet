package com.akshay.composecatchflicks.ui.screens.movies.data

import com.akshay.composecatchflicks.domain.model.Movie


/**
 * Created by anandwana001 on
 * 15, November, 2022
 **/
data class MovieState(
    val currentPage: Int = 1,
    val listOfMovies: List<Movie> = emptyList()
)
