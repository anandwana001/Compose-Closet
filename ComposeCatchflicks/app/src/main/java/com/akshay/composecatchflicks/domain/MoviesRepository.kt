package com.akshay.composecatchflicks.domain

import com.akshay.composecatchflicks.data.remote.NetworkService
import com.akshay.composecatchflicks.domain.model.Movie
import javax.inject.Inject

/**
 * Created by anandwana001 on
 * 15, November, 2022
 **/
class MoviesRepository @Inject constructor(private val networkService: NetworkService) {

    suspend fun getPopularMovies(language: String, pageNumber: Int): List<Movie> {
        return networkService.getPopularMovies(language = language, page = pageNumber).results.map {
            Movie(
                title = it.title,
                overview = it.overview,
                voteAverage = it.vote_average,
                posterPath = it.poster_path
            )
        }
    }
}
