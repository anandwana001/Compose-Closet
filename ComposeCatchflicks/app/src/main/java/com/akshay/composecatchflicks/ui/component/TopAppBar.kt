package com.akshay.composecatchflicks.ui.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.akshay.composecatchflicks.R
import com.akshay.composecatchflicks.ui.theme.CatchflicksFont
import com.akshay.composecatchflicks.ui.theme.ComposeCatchflicksTheme
import com.akshay.composecatchflicks.ui.theme.backgroundColor

/**
 * Created by anandwana001 on
 * 01, November, 2022
 **/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatchflicksTopAppBar(
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = {
            Text(
                color = Color.White,
                text = stringResource(id = R.string.app_name),
                fontFamily = CatchflicksFont
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = backgroundColor
        ),
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
private fun TopAppBarPreview() {
    ComposeCatchflicksTheme {
        CatchflicksTopAppBar()
    }
}
