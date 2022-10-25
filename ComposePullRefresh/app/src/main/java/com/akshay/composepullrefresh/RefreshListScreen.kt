package com.akshay.composepullrefresh

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.akshay.composepullrefresh.ui.theme.ComposePullRefreshTheme
import com.akshay.composepullrefresh.ui.theme.Indicator
import com.akshay.composepullrefresh.ui.theme.Purple500
import com.akshay.composepullrefresh.ui.theme.Teal200
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by anandwana001 on
 * 25, October, 2022
 **/

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RefreshListScreen(modifier: Modifier = Modifier) {
    val refreshScope = rememberCoroutineScope()
    val listState = rememberLazyListState()
    var refreshing by remember { mutableStateOf(false) }
    var itemCount by remember { mutableStateOf(5) }

    fun refresh() = refreshScope.launch {
        refreshing = true
        delay(1500)
        itemCount += 5
        refreshing = false
    }

    val state = rememberPullRefreshState(
        refreshing = refreshing,
        onRefresh = ::refresh,
        refreshThreshold = 70.dp,
        refreshingOffset = 60.dp
    )

    Box(modifier.pullRefresh(state)) {
        LazyColumn(
            modifier
                .fillMaxSize()
                .padding(top = 16.dp, bottom = 16.dp), state = listState) {
            items(itemCount) {
                ListItem(modifier = modifier.padding(horizontal = 4.dp, vertical = 4.dp)) {
                    RefreshListItem(modifier, itemCount, it)
                }
            }
        }

        PullRefreshIndicator(
            refreshing = refreshing,
            state = state,
            modifier = Modifier.align(Alignment.TopCenter),
            backgroundColor = Indicator,
            contentColor = Teal200,
            scale = true
        )
    }
}

@Composable
private fun RefreshListItem(modifier: Modifier = Modifier, itemCount: Int, it: Int) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Purple500
    ) {
        Text(
            modifier = modifier
                .padding(top = 8.dp, bottom = 8.dp, start = 8.dp),
            text = "Item ${itemCount - it}",
            color = Teal200
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePullRefreshTheme {
        RefreshListScreen()
    }
}