package com.akshay.compose_catchflicks.data.model

/**
 * Created by anandwana001 on
 * 10, July, 2022
 **/
data class Movie(
    val popularity: Float,
    val vote_count: Int,
    val video: Boolean,
    val poster_path: String?,
    val id: Int,
    val adult: Boolean,
    val backdrop_path: String?,
    val original_language: String,
    val original_title: String,
    val genre_ids: List<Int>,
    val title: String,
    val vote_average: Float,
    val overview: String,
    val release_date: String

)