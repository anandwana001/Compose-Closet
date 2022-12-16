package com.akshay.composecatchflicks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.akshay.composecatchflicks.ui.component.CatchflicksBottomNavigationBar
import com.akshay.composecatchflicks.ui.component.CatchflicksTopAppBar
import com.akshay.composecatchflicks.ui.navigation.NavHostContainer
import com.akshay.composecatchflicks.ui.theme.ComposeCatchflicksTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCatchflicksTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { CatchflicksTopAppBar() },
                    bottomBar = {
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentRoute = navBackStackEntry?.destination?.route
                        if(currentRoute != "detail") {
                            CatchflicksBottomNavigationBar(navController = navController)
                        }
                    }
                ) { paddingValues ->
                    NavHostContainer(navController = navController, paddingValues = paddingValues)
                }
            }
        }
    }
}
