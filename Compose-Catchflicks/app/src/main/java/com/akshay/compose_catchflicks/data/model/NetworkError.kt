package com.akshay.compose_catchflicks.data.model

/**
 * Created by anandwana001 on
 * 10, July, 2022
 **/
data class NetworkError(
    val statusMessage: String = "The resource you requested could not be found.",
    val success: Boolean = false,
    val statusCode: Int = 34
)
