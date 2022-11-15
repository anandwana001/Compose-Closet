package com.akshay.composecatchflicks.data.remote.response

import com.akshay.composecatchflicks.data.model.Movie

/**
 * Created by anandwana001 on
 * 15, November, 2022
 **/
data class SearchMoviesResponse(
    val page: Int,
    val totalResults: Int,
    val totalPages: Int,
    val results: List<Movie>
)