package com.akshay.compose_catchflicks.ui

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.akshay.compose_catchflicks.ui.components.ComposeCatchflicksBottomBar
import com.akshay.compose_catchflicks.ui.home.HomeSections
import com.akshay.compose_catchflicks.ui.theme.ComposeCatchflicksTheme

/**
 * Created by anandwana001 on
 * 10, July, 2022
 **/
@Composable
fun ComposeCatchflicks() {
    ComposeCatchflicksTheme {
        Scaffold(
            modifier = Modifier,
            scaffoldState = rememberScaffoldState(),
            topBar = {},
            bottomBar = { ComposeCatchflicksBottomBar(HomeSections.values()) },
            snackbarHost = {},
            floatingActionButton = {},
            floatingActionButtonPosition = FabPosition.End,
            isFloatingActionButtonDocked = false,
            drawerContent = {},
            drawerShape = MaterialTheme.shapes.large,
            drawerElevation = DrawerDefaults.Elevation,
            drawerBackgroundColor = Color.Black,
            drawerContentColor = Color.Black,
            drawerScrimColor = Color.Black,
            backgroundColor = Color.Black,
            contentColor = Color.Black,
            content = {}
        )
    }
}
