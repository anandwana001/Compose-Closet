package com.akshay.composecatchflicks.ui.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.akshay.composecatchflicks.R
import com.akshay.composecatchflicks.ui.navigation.ComposeCatchflicksCategory
import com.akshay.composecatchflicks.ui.theme.CatchflicksFont
import com.akshay.composecatchflicks.ui.theme.ComposeCatchflicksTheme
import com.akshay.composecatchflicks.ui.theme.UnSelectedTextItemColor
import com.akshay.composecatchflicks.ui.theme.backgroundColor

/**
 * Created by anandwana001 on
 * 01, November, 2022
 **/
@Composable
fun CatchflicksBottomNavigationBar(
    modifier: Modifier = Modifier,
) {
    val list = ComposeCatchflicksCategory.values().asList()
    CatchflicksBottomBar(
        modifier = modifier,
    ) {
        list.forEach { category ->
            CatchflicksBottomNavigationBarItem(
                selected = category.titleId == R.string.movies,
                label = {
                    Text(
                        fontFamily = CatchflicksFont,
                        text = stringResource(category.titleId)
                    )
                }
            )
        }
    }
}

@Composable
fun CatchflicksBottomBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    NavigationBar(
        containerColor = backgroundColor,
        modifier = modifier,
        content = content
    )
}

@Composable
fun RowScope.CatchflicksBottomNavigationBarItem(
    selected: Boolean,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    alwaysShowLabel: Boolean = true
) {
    NavigationBarItem(
        selected = selected,
        modifier = modifier,
        enabled = enabled,
        label = label,
        alwaysShowLabel = alwaysShowLabel,
        colors = NavigationBarItemDefaults.colors(
            selectedTextColor = Color.White,
            unselectedTextColor = UnSelectedTextItemColor,
            unselectedIconColor = UnSelectedTextItemColor
        ),
        icon = {
            Icon(
                painter = painterResource(id = R.drawable.popular),
                contentDescription = "",
                modifier = Modifier.height(20.dp),
            )
        },
        onClick = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun CatchflicksBottomNavigationBarPreview() {
    ComposeCatchflicksTheme {
        CatchflicksBottomNavigationBar()
    }
}