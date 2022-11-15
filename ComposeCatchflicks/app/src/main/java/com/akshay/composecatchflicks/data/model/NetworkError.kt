package com.akshay.composecatchflicks.data.model

/**
 * Created by anandwana001 on
 * 15, November, 2022
 **/
data class NetworkError(
    val statusMessage: String = "The resource you requested could not be found.",
    val success: Boolean = false,
    val statusCode: Int = 34
)
