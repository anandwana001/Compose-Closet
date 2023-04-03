package com.akshay.composestaggeredgrids

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Created by anandwana001 on
 * 25, October, 2022
 **/
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyVerticalStaggeredGridView(modifier: Modifier = Modifier, listOfItems: List<String>) {

    val state = rememberLazyStaggeredGridState()

    LazyVerticalStaggeredGrid(modifier = modifier
        .padding(top = 8.dp, bottom = 16.dp),
        columns = StaggeredGridCells.Fixed(3),
        state = state,
        content = {
            items(listOfItems) {
                SingleCard(text = it)
            }
        })
}

