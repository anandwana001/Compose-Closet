package com.akshay.compose_catchflicks.ui

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.akshay.compose_catchflicks.ui.components.ComposeCatchflicksBottomBar
import com.akshay.compose_catchflicks.ui.components.NavHostContainer
import com.akshay.compose_catchflicks.ui.home.HomeSections
import com.akshay.compose_catchflicks.ui.theme.ComposeCatchflicksTheme
import com.akshay.compose_catchflicks.ui.theme.catchflicksFont

/**
 * Created by anandwana001 on
 * 10, July, 2022
 **/
@Composable
fun ComposeCatchflicks() {
    ComposeCatchflicksTheme {
        val navController = rememberNavController()
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "ComposeCatchflicks",
                            fontFamily = catchflicksFont
                        )
                    },
                    actions = {

                    }
                )
            },
            bottomBar = { ComposeCatchflicksBottomBar(HomeSections.values(), navController) },
        ) {
            NavHostContainer(navController = navController)
        }
    }
}
