package com.akshay.composestaggeredgrids

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.akshay.composestaggeredgrids.ui.theme.Purple500
import com.akshay.composestaggeredgrids.ui.theme.Teal200

/**
 * Created by anandwana001 on
 * 26, October, 2022
 **/
@Composable
fun SingleCard(modifier: Modifier = Modifier, text: String) {
    Card(
        modifier = modifier.padding(horizontal = 4.dp, vertical = 4.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Purple500
    ) {
        Text(
            modifier = modifier
                .padding(top = 8.dp, bottom = 8.dp, start = 8.dp),
            text = text,
            color = Teal200
        )
    }
}
