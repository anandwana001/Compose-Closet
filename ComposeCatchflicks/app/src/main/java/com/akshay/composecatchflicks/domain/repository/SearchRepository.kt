package com.akshay.composecatchflicks.domain.repository

import com.akshay.composecatchflicks.data.remote.NetworkService
import com.akshay.composecatchflicks.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by anandwana001 on
 * 02, July, 2023
 **/
class SearchRepository @Inject constructor(
    private val networkService: NetworkService,
    @IoDispatcher private val dispatchers: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun getSearchResult(query: String, page: Int = 1): List<String> =
        withContext(dispatchers) {
            networkService.searchMovies(
                query = query,
                language = "en",
                page = page
            ).results.mapNotNull { it.title }
        }
}
