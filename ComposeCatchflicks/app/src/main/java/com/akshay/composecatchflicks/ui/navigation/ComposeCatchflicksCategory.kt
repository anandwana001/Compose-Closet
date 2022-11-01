package com.akshay.composecatchflicks.ui.navigation

import androidx.annotation.StringRes
import com.akshay.composecatchflicks.R

/**
 * Created by anandwana001 on
 * 01, November, 2022
 **/
enum class ComposeCatchflicksCategory(
    @StringRes val titleId: Int,
) {
    MOVIE(R.string.movies),
    TV(R.string.tv),
    SEARCH(R.string.search)
}
