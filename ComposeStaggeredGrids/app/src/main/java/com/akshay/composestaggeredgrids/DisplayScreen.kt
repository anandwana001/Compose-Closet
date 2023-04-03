package com.akshay.composestaggeredgrids

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Created by anandwana001 on
 * 26, October, 2022
 **/
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DisplayScreen() {
    Column {
        ShowTitle("LazyVerticalStaggeredGrid")
        LazyVerticalStaggeredGridView(modifier = Modifier.weight(0.5f), listOfItems)
        Spacer(modifier = Modifier.height(10.dp))
        ShowTitle("LazyHorizontalStaggeredGrid")
        LazyHorizontalStaggeredGridView(modifier = Modifier.weight(0.5f), listOfItems)
    }
}

@Composable
private fun ShowTitle(title: String) {
    Text(
        modifier = Modifier.padding(start = 8.dp, top = 8.dp),
        text = title
    )
}

private const val SINGLE_LINE_ITEM = "A single line to test."
private const val MULTIPLE_LINE_ITEM = "This is a multi-line string to test on the item for staggering."
private val listOfItems = listOf<String>(
    MULTIPLE_LINE_ITEM,
    SINGLE_LINE_ITEM,
    SINGLE_LINE_ITEM,
    SINGLE_LINE_ITEM,
    MULTIPLE_LINE_ITEM,
    MULTIPLE_LINE_ITEM,
    SINGLE_LINE_ITEM,
    SINGLE_LINE_ITEM,
    SINGLE_LINE_ITEM,
    MULTIPLE_LINE_ITEM,
    MULTIPLE_LINE_ITEM,
    SINGLE_LINE_ITEM,
    SINGLE_LINE_ITEM,
    SINGLE_LINE_ITEM,
    MULTIPLE_LINE_ITEM,
    MULTIPLE_LINE_ITEM,
    SINGLE_LINE_ITEM,
    SINGLE_LINE_ITEM,
    SINGLE_LINE_ITEM,
    MULTIPLE_LINE_ITEM,
    MULTIPLE_LINE_ITEM,
    SINGLE_LINE_ITEM,
    SINGLE_LINE_ITEM,
    SINGLE_LINE_ITEM,
    MULTIPLE_LINE_ITEM,
)