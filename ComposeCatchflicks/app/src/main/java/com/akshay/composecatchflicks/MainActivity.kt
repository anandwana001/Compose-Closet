package com.akshay.composecatchflicks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.akshay.composecatchflicks.ui.component.CatchflicksBottomNavigationBar
import com.akshay.composecatchflicks.ui.component.CatchflicksTopAppBar
import com.akshay.composecatchflicks.ui.theme.ComposeCatchflicksTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCatchflicksTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { CatchflicksTopAppBar() },
                    bottomBar = { CatchflicksBottomNavigationBar() }
                ) { padding ->
                    Box(modifier = Modifier.padding(padding)) {}
                }
            }
        }
    }
}
