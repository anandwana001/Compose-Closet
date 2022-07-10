package com.akshay.compose_catchflicks.data.remote

import com.akshay.compose_catchflicks.data.remote.response.*
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by anandwana001 on
 * 10, July, 2022
 **/
interface NetworkService {

    @GET(Endpoints.GENRE)
    fun doGenreCall(
        @Query("api_key") apiKey: String = Networking.API_KEY,
        @Query("language") language: String?
    ): GenreResponse

    @GET(Endpoints.MOVIES_POPULAR)
    fun doPopularMoviesCall(
        @Query("api_key") apiKey: String = Networking.API_KEY,
        @Query("language") language: String?,
        @Query("page") page: Int?
    ): PopularMoviesResponse

    @GET(Endpoints.MOVIES_NOW_PLAYING)
    fun doNowPlayingMovieCall(
        @Query("api_key") apiKey: String = Networking.API_KEY,
        @Query("language") language: String?,
        @Query("page") page: Int?
    ): NowPlayingMoviesResponse

    @GET(Endpoints.MOVIES_UPCOMING)
    fun doUpcomingMovieCall(
        @Query("api_key") apiKey: String = Networking.API_KEY,
        @Query("language") language: String?,
        @Query("page") page: Int?
    ): UpcomingMoviesResponse

    @GET(Endpoints.MOVIES_SEARCH)
    fun doSearchMovieCall(
        @Query("api_key") apiKey: String = Networking.API_KEY,
        @Query("language") language: String?,
        @Query("query") query: String,
        @Query("page") page: Int?
    ): SearchMoviesResponse
}
