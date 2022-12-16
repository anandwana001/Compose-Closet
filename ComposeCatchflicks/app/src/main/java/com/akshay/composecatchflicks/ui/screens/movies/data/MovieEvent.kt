package com.akshay.composecatchflicks.ui.screens.movies.data

/**
 * Created by anandwana001 on
 * 15, November, 2022
 **/
sealed interface MovieEvent {
    data class incrementPageNumber(val currentPageNumber: Int): MovieEvent
}