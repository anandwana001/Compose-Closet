package com.akshay.compose_catchflicks.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Created by anandwana001 on
 * 13, July, 2022
 **/

@Composable
fun genreCard(modifier: Modifier, cardBackgroundColor: Int, genreTitle: String) {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color(cardBackgroundColor),
        elevation = 4.dp,
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        Text(
            modifier = modifier
                .padding(all = 16.dp),
            text = genreTitle,
            style = MaterialTheme.typography.h6,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun previewGenreCard() {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color(0xFFffbc03),
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(all = 16.dp),
            text = "Action",
            style = MaterialTheme.typography.h6
        )
    }
}
