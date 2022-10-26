package com.akshay.composestaggeredgrids

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.akshay.composestaggeredgrids.ui.theme.ComposeStaggeredGridsTheme

/**
 * Created by anandwana001 on
 * 25, October, 2022
 **/
@ExperimentalFoundationApi
@Composable
fun LazyHorizontalStaggeredGridView(modifier: Modifier = Modifier) {

    LazyHorizontalStaggeredGrid(modifier = modifier
        .padding(top = 8.dp, bottom = 16.dp),
        rows = StaggeredGridCells.Fixed(5), content = {
            items(50) {
                SingleCard(
                    modifier = modifier.width(114.dp),
                    index = it
                )
            }
        })
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeStaggeredGridsTheme {
        LazyHorizontalStaggeredGridView()
    }
}
