package com.akshay.composestaggeredgrids

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Created by anandwana001 on
 * 25, October, 2022
 **/
@ExperimentalFoundationApi
@Composable
fun LazyHorizontalStaggeredGridView(modifier: Modifier = Modifier, listOfItems: List<String>) {

    LazyHorizontalStaggeredGrid(modifier = modifier
        .padding(top = 8.dp, bottom = 16.dp),
        rows = StaggeredGridCells.Fixed(5), content = {
            items(listOfItems) {
                SingleCard(
                    modifier = modifier,
                    text = it
                )
            }
        })
}

