package com.akshay.composecatchflicks.ui.screens.movies.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akshay.composecatchflicks.domain.MoviesRepository
import com.akshay.composecatchflicks.ui.screens.movies.data.MovieEvent
import com.akshay.composecatchflicks.ui.screens.movies.data.MovieState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by anandwana001 on
 * 14, November, 2022
 **/
@HiltViewModel
class MoviesViewModel @Inject constructor(private val moviesRepository: MoviesRepository) :
    ViewModel() {

    private val _movieStateData = MutableStateFlow<MovieState>(MovieState())
    val movieStateData = _movieStateData.asStateFlow()

    private val _movieEventData = MutableSharedFlow<MovieEvent>()
    val movieEventData = _movieEventData.asSharedFlow()

    init {
        fetchMovies()
    }

    fun onEvent(event: MovieEvent) {
        when (event) {
            is MovieEvent.IncrementPageNumber -> {
                _movieStateData.value = _movieStateData.value.copy(
                    currentPage = event.currentPage + 1
                )
            }
            else -> Unit
        }
    }

    fun fetchMovies() {
        viewModelScope.launch {
            _movieStateData.value = _movieStateData.value.copy(
                listOfMovies = moviesRepository.getPopularMovies(
                    "en",
                    movieStateData.value.currentPage
                )
            )
        }
    }
}
