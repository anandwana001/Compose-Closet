package com.akshay.composecatchflicks.data.remote

import com.akshay.composecatchflicks.BuildConfig
import com.akshay.composecatchflicks.data.remote.response.*
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by anandwana001 on
 * 15, November, 2022
 **/
interface NetworkService {

    @GET(Endpoints.GENRE)
    fun getGenres(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
        @Query("language") language: String?
    ): GenreResponse

    @GET(Endpoints.MOVIES_POPULAR)
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
        @Query("language") language: String?,
        @Query("page") page: Int?
    ): PopularMoviesResponse

    @GET(Endpoints.MOVIES_NOW_PLAYING)
    fun getNowPlayingMovies(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
        @Query("language") language: String?,
        @Query("page") page: Int?
    ): NowPlayingMoviesResponse

    @GET(Endpoints.MOVIES_UPCOMING)
    fun getUpcomingMovies(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
        @Query("language") language: String?,
        @Query("page") page: Int?
    ): UpcomingMoviesResponse

    @GET(Endpoints.MOVIES_SEARCH)
    fun searchMovies(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
        @Query("language") language: String?,
        @Query("query") query: String,
        @Query("page") page: Int?
    ): SearchMoviesResponse
}
