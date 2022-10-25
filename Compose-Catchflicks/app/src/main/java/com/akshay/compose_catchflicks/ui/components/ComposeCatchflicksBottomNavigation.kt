package com.akshay.compose_catchflicks.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.akshay.compose_catchflicks.ui.home.HomeSections
import com.akshay.compose_catchflicks.ui.now_playing.NowPlaying
import com.akshay.compose_catchflicks.ui.popular.PopularScreen
import com.akshay.compose_catchflicks.ui.popular.PopularViewModel
import com.akshay.compose_catchflicks.ui.search.Search
import com.akshay.compose_catchflicks.ui.theme.Teal200
import com.akshay.compose_catchflicks.ui.theme.Teal700
import com.akshay.compose_catchflicks.ui.upcoming.Upcoming
import org.koin.androidx.compose.getViewModel

/**
 * Created by anandwana001 on
 * 10, July, 2022
 **/

@Composable
fun ComposeCatchflicksBottomBar(
    tabs: Array<HomeSections>,
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    BottomNavigation(modifier = Modifier.height(70.dp)) {
        tabs.forEach { navItem ->
            BottomNavigationItem(
                selected = currentRoute == navItem.route,
                label = { Text(stringResource(id = navItem.title)) },
                icon = {
                    Icon(
                        painter = painterResource(id = navItem.icon),
                        contentDescription = "",
                        modifier = Modifier.height(32.dp).padding(bottom = 8.dp),
                        tint = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
                    )
                },
                onClick = {
                    navController.navigate(navItem.route)
                },
                selectedContentColor = Teal200,
                unselectedContentColor = Teal700,
            )
        }
    }
}

@Composable
fun NavHostContainer(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = HomeSections.POPULAR.route,
        modifier = Modifier,
        builder = {
            composable("popular") {
                val viewModel = getViewModel<PopularViewModel>()
                PopularScreen(viewModel)
            }
            composable("search") {
                Search()
            }
            composable("upcoming") {
                Upcoming()
            }
            composable("now_playing") {
                NowPlaying()
            }
        })
}
