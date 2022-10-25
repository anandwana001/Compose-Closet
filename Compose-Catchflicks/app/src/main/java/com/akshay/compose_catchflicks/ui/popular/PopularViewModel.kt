package com.akshay.compose_catchflicks.ui.popular

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akshay.compose_catchflicks.data.model.Movie
import com.akshay.compose_catchflicks.repository.PopularRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by anandwana001 on
 * 17, July, 2022
 **/
class PopularViewModel(
    val popularRepository: PopularRepository
) : ViewModel() {

    private val _movieStateData = MutableStateFlow<List<Movie>?>(emptyList())
    val movieStateData = _movieStateData.asStateFlow()

    init {
        getPopularMoviesData()
    }

    fun getPopularMoviesData() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = popularRepository.fetchPopularMovies(
                language = "en-US",
                pageNumber = 1
            )
            withContext(Dispatchers.Main) {
                _movieStateData.value = result
            }
        }
    }
}
