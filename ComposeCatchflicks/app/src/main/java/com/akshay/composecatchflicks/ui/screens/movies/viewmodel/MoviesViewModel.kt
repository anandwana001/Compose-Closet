package com.akshay.composecatchflicks.ui.screens.movies.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.akshay.composecatchflicks.domain.MoviesRepository
import com.akshay.composecatchflicks.ui.screens.movies.data.MovieState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

/**
 * Created by anandwana001 on
 * 14, November, 2022
 **/
@HiltViewModel
class MoviesViewModel @Inject constructor(
    moviesRepository: MoviesRepository
) : ViewModel() {

    private val _movieStateData = MutableStateFlow(MovieState())
    val movieStateData = _movieStateData.asStateFlow()

    val list = moviesRepository.getPopularMovies("en").cachedIn(viewModelScope)
    val nowPlayingMoviesList = moviesRepository.getNowPlayingMovies("en").cachedIn(viewModelScope)
    val upcomingMoviesList = moviesRepository.getUpcomingMovies("en").cachedIn(viewModelScope)
}
