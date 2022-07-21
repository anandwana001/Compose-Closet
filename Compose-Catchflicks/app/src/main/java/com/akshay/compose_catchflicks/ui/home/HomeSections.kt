package com.akshay.compose_catchflicks.ui.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.akshay.compose_catchflicks.R

/**
 * Created by anandwana001 on
 * 10, July, 2022
 **/
enum class HomeSections(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val route: String
) {
    POPULAR(R.string.popular_movies, R.drawable.popular, "popular"),
    UPCOMING(R.string.upcoming_movies, R.drawable.upcoming, "upcoming"),
    NOWPLAYING(R.string.now_playing_movies, R.drawable.now_playing, "now_playing"),
    SEARCH(R.string.search, R.drawable.ic_baseline_search_24, "search")
}
