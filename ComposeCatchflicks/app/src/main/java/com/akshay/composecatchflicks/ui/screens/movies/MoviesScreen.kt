package com.akshay.composecatchflicks.ui.screens.movies

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
fun MoviesScreen(modifier: Modifier = Modifier) {
    Text(text = "Movies")
}

@Preview(showBackground = true)
@Composable
fun MoviesScreenPreview() {
    ComposeCatchflicksTheme() {
        MoviesScreen()
    }
}

