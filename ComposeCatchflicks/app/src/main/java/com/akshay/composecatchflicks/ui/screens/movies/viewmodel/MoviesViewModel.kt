package com.akshay.composecatchflicks.ui.screens.movies.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akshay.composecatchflicks.domain.MoviesRepository
import com.akshay.composecatchflicks.ui.screens.movies.data.MovieState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by anandwana001 on
 * 14, November, 2022
 **/
@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository
) : ViewModel() {

    private val _movieStateData = MutableStateFlow(MovieState())
    val movieStateData = _movieStateData.asStateFlow()

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        viewModelScope.launch {
            _movieStateData.update {
                it.copy(
                    listOfMovies = moviesRepository.getPopularMovies(
                        "en",
                        1
                    ).takeIf { it.isNotEmpty() }?.apply {
                        movieStateData.value.listOfMovies.toMutableList().addAll(this)
                        movieStateData.value.listOfMovies
                    } ?: run {
                        it.listOfMovies
                    }
                )
            }
        }
    }
}
