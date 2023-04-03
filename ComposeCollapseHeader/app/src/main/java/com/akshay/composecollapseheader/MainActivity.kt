package com.akshay.composecollapseheader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.akshay.composecollapseheader.ui.theme.ComposeCollapseHeaderTheme
import java.lang.Float.min

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCollapseHeaderTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    content = {
                        val scrollState = rememberLazyListState()
                        val scrollOffset: Float = min(
                            1f,
                            1 - (scrollState.firstVisibleItemScrollOffset / 600f + scrollState.firstVisibleItemIndex)
                        )
                        println("firstVisibleItemScrollOffset = ${scrollState.firstVisibleItemScrollOffset} \n firstVisibleItemIndex = ${scrollState.firstVisibleItemIndex}")
                        Column(
                            modifier = Modifier
                                .padding(it)
                        ) {
                            val toolbarHeight by animateDpAsState(
                                targetValue = max(
                                    24.dp,
                                    128.dp * scrollOffset
                                ),
                            )
                            Column(
                                modifier = Modifier
                                    .height(toolbarHeight)
                                    .fillMaxWidth()
                                    .background(
                                        Brush.horizontalGradient(
                                            listOf(
                                                Color.Black,
                                                Color(0XFFe74c3c)
                                            )
                                        )
                                    )
                                    .align(Alignment.CenterHorizontally),
                            ) {
                                if (toolbarHeight > 24.dp) {
                                    Button(onClick = { /*TODO*/ }) {
                                        Text(text = "This button should go away on scroll")
                                    }
                                }
                                Spacer(modifier = Modifier.weight(1f))
                                Text(text = "Title", color = Color.White)
                            }

                            Row(modifier = Modifier.fillMaxWidth()) {
                                Button(onClick = { /*TODO*/ }) {
                                    Text(text = "Button 1")
                                }
                                Spacer(modifier = Modifier.weight(1f))
                                Button(onClick = { /*TODO*/ }) {
                                    Text(text = "Button 2")
                                }
                            }

                            LazyColumn(state = scrollState, content = {
                                items(100, itemContent = { item ->
                                    Text(
                                        text = "Item number $item",
                                        modifier = Modifier.padding(vertical = 10.dp)
                                    )
                                })
                            })
                        }
                    }
                )
            }
        }
    }
}
