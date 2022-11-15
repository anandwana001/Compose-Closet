package com.akshay.composecatchflicks.domain

import com.akshay.composecatchflicks.data.model.Movie
import com.akshay.composecatchflicks.data.remote.NetworkService
import javax.inject.Inject

/**
 * Created by anandwana001 on
 * 15, November, 2022
 **/
class MoviesRepository @Inject constructor(private val networkService: NetworkService) {

    suspend fun getPopularMovies(language: String, pageNumber: Int): List<Movie> {
        return networkService.getPopularMovies(language = language, page = pageNumber).results
    }
}
