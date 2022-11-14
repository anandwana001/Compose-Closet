package com.akshay.composecatchflicks.ui.screens.movies

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

/**
 * Created by anandwana001 on
 * 14, November, 2022
 **/
@HiltViewModel
class MoviesViewModel @Inject constructor(): ViewModel() {
    private val _movieStateData = MutableStateFlow<List<String>?>(listOf("a", "a", "a", "a"))
    val movieStateData = _movieStateData.asStateFlow()
}
