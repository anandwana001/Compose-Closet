package com.akshay.compose_catchflicks.data.remote.response

import com.akshay.compose_catchflicks.data.model.Movie
/**
 * Created by anandwana001 on
 * 10, July, 2022
 **/
data class PopularMoviesResponse(
    val page: Int,
    val total_pages: Int,
    val total_results: Int,
    val results: List<Movie>
)
