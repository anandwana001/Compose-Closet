package com.akshay.composecatchflicks.ui.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.akshay.composecatchflicks.R

/**
 * Created by anandwana001 on
 * 31, October, 2022
 **/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatchflicksTopAppBar() {
    TopAppBar(
        title = {
            Text(
                color = Color.Black,
                text = stringResource(id = R.string.app_name)
            )
        },
    )
}