package com.akshay.composecatchflicks.ui.screens.movies.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akshay.composecatchflicks.domain.MoviesRepository
import com.akshay.composecatchflicks.ui.screens.movies.data.MovieEvent
import com.akshay.composecatchflicks.ui.screens.movies.data.MovieState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
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
        }
    }

    fun fetchMovies(pageNumber: Int = 1) {
        viewModelScope.launch {
            _movieStateData.update {
                it.copy(
                    currentPage = pageNumber,
                    listOfMovies = moviesRepository.getPopularMovies(
                        "en",
                        pageNumber
                    ).let {
                        movieStateData.value.listOfMovies.addAll(it)
                        movieStateData.value.listOfMovies
                    }
                )
            }
        }
    }
}
