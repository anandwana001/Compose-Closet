package com.akshay.composecatchflicks.ui.screens.movies.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akshay.composecatchflicks.domain.MoviesRepository
import com.akshay.composecatchflicks.domain.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by anandwana001 on
 * 14, November, 2022
 **/
@HiltViewModel
class MoviesViewModel @Inject constructor(private val moviesRepository: MoviesRepository) : ViewModel() {

    private val _movieStateData = MutableStateFlow<List<Movie>>(emptyList())
    val movieStateData = _movieStateData.asStateFlow()

    init {
        fetchInitialMovies()
    }

    private fun fetchInitialMovies() {
        viewModelScope.launch {
            _movieStateData.value = moviesRepository.getPopularMovies("en", 1)
        }
    }
}
