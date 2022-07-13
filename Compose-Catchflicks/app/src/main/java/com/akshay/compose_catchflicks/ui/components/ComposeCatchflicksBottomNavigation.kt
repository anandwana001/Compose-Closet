package com.akshay.compose_catchflicks.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.akshay.compose_catchflicks.ui.home.HomeSections

/**
 * Created by anandwana001 on
 * 10, July, 2022
 **/

private val BottomNavigationItemPadding = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)

@Composable
fun ComposeCatchflicksBottomBar(
    tabs: Array<HomeSections>
) {
    BottomNavigation {
        tabs.forEach { section ->
            BottomNavigationItem(
                selected = false,
                alwaysShowLabel = false,
                label = { Text(stringResource(id = section.title)) },
                icon = {
                    Icon(
                        painter = painterResource(id = section.icon),
                        contentDescription = "",
                        modifier = BottomNavigationItemPadding,
                        tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
                    )
                },
                onClick = {}
            )
        }
    }
}
