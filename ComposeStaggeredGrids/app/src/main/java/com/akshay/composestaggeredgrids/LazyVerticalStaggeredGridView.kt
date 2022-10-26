package com.akshay.composestaggeredgrids

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.akshay.composestaggeredgrids.ui.theme.ComposeStaggeredGridsTheme

/**
 * Created by anandwana001 on
 * 25, October, 2022
 **/
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyVerticalStaggeredGridView(modifier: Modifier = Modifier) {

    val state = rememberLazyStaggeredGridState()

    LazyVerticalStaggeredGrid(modifier = modifier
        .padding(top = 8.dp, bottom = 16.dp),
        columns = StaggeredGridCells.Fixed(3),
        state = state,
        content = {
            items(50) {
                SingleCard(index = it)
            }
        })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview1() {
    ComposeStaggeredGridsTheme {
        LazyVerticalStaggeredGridView()
    }
}
