package com.akshay.composecatchflicks.ui.screens.search

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.akshay.composecatchflicks.ui.theme.ComposeCatchflicksTheme

/**
 * Created by anandwana001 on
 * 08, November, 2022
 **/
@Composable
fun SearchScreen(modifier: Modifier = Modifier) {
    Text(text = "Search")
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    ComposeCatchflicksTheme() {
        SearchScreen()
    }
}
