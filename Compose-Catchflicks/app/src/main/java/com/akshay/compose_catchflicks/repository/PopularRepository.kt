package com.akshay.compose_catchflicks.repository

import com.akshay.compose_catchflicks.data.remote.NetworkService

/**
 * Created by anandwana001 on
 * 17, July, 2022
 **/
class PopularRepository(
    private val networkService: NetworkService
) {
    suspend fun fetchPopularMovies(language: String, pageNumber: Int) =
        networkService.doPopularMoviesCall(language = language, page = pageNumber).results
}
