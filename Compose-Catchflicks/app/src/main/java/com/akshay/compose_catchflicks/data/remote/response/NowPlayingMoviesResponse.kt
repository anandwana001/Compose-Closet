package com.akshay.compose_catchflicks.data.remote.response

import com.akshay.compose_catchflicks.data.model.Dates
import com.akshay.compose_catchflicks.data.model.Movie

/**
 * Created by anandwana001 on
 * 10, July, 2022
 **/
data class NowPlayingMoviesResponse(
    val page: Int,
    val totalResults: Int,
    val totalPages: Int,
    val results: List<Movie>,
    val dates: Dates
)