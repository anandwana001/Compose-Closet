package com.akshay.composecatchflicks.data.remote.response

import com.akshay.composecatchflicks.data.model.Genres
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by anandwana001 on
 * 02, January, 2023
 **/
@Serializable
data class MovieDetailResponse(
    @SerialName("popularity") val popularity: Float,
    @SerialName("vote_count") val vote_count: Int,
    @SerialName("video") val video: Boolean,
    @SerialName("poster_path") val poster_path: String?,
    @SerialName("id") val id: Int,
    @SerialName("adult") val adult: Boolean,
    @SerialName("backdrop_path") val backdrop_path: String?,
    @SerialName("original_language") val original_language: String,
    @SerialName("original_title") val original_title: String,
    @SerialName("title") val title: String,
    @SerialName("genres") val genres: List<Genres>,
    @SerialName("vote_average") val vote_average: Float,
    @SerialName("overview") val overview: String,
    @SerialName("release_date") val release_date: String
)
