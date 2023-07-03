package com.akshay.composecatchflicks.domain.repository

import com.akshay.composecatchflicks.data.remote.NetworkService
import com.akshay.composecatchflicks.di.IoDispatcher
import com.akshay.composecatchflicks.domain.model.Genres
import com.akshay.composecatchflicks.domain.model.Movie
import com.akshay.composecatchflicks.domain.model.MovieDetail
import com.akshay.composecatchflicks.util.createPager
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

/**
 * Created by anandwana001 on
 * 15, November, 2022
 **/
class MoviesRepository @Inject constructor(
    private val networkService: NetworkService,
    @IoDispatcher private val dispatchers: CoroutineDispatcher = Dispatchers.IO
) {

    fun getPopularMovies(
        language: String,
    ) = createPager { page ->
        val data = networkService.getPopularMovies(
            language = language,
            page = page
        )
        Pair(
            first = data.results?.map {
                Movie(
                    id = it.id,
                    title = it.title,
                    overview = it.overview,
                    voteAverage = it.vote_average,
                    posterPath = it.poster_path,
                    backdropPath = it.backdrop_path
                )
            } ?: emptyList(),
            second = data.total_pages ?: 0
        )
    }.flow

    fun getNowPlayingMovies(
        language: String,
    ) = createPager { page ->
        val data = networkService.getNowPlayingMovies(
            language = language,
            page = page
        )
        Pair(
            first = data.results?.map {
                Movie(
                    id = it.id,
                    title = it.title,
                    overview = it.overview,
                    voteAverage = it.vote_average,
                    posterPath = it.poster_path,
                    backdropPath = it.backdrop_path
                )
            } ?: emptyList(),
            second = data.total_pages ?: 0
        )
    }.flow

    fun getUpcomingMovies(
        language: String,
    ) = createPager { page ->
        val data = networkService.getUpcomingMovies(
            language = language,
            page = page
        )
        Pair(
            first = data.results?.map {
                Movie(
                    id = it.id,
                    title = it.title,
                    overview = it.overview,
                    voteAverage = it.vote_average,
                    posterPath = it.poster_path,
                    backdropPath = it.backdrop_path
                )
            } ?: emptyList(),
            second = data.total_pages ?: 0
        )
    }.flow

    suspend fun getMovieDetails(movieId: Int): MovieDetail {
        val data = networkService.getMovieDetails(movieId = movieId)
        return MovieDetail(
            id = data.id,
            title = data.title,
            overview = data.overview,
            voteAverage = data.vote_average,
            posterPath = data.poster_path,
            backdropPath = data.backdrop_path,
            genres = data.genres?.filter {
                it.name != null && it.id != null
            }?.map {
                Genres(it.id, it.name)
            } ?: run {
                emptyList()
            }
        )
    }
}
