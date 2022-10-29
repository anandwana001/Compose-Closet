package com.akshay.composeanimation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.akshay.composeanimation.ui.theme.Indicator
import com.akshay.composeanimation.ui.theme.Purple500
import com.akshay.composeanimation.ui.theme.Teal200

/**
 * Created by anandwana001 on
 * 29, October, 2022
 **/
@Composable
fun AnimationDisplayScreen(modifier: Modifier = Modifier) {
    Box {
        AnimationDisplayList(modifier)
    }
}

@Composable
fun AnimationDisplayList(modifier: Modifier = Modifier) {
    LazyColumn(
        content = {
            item {
                AnimateMultiple(modifier.padding(horizontal = 8.dp, vertical = 8.dp))
            }
            item {
                AnimateDp(modifier.padding(horizontal = 8.dp, vertical = 8.dp))
            }
            item {
                AnimateScale(modifier.padding(horizontal = 8.dp, vertical = 8.dp))
            }
            item {
                AnimateRectangle(modifier.padding(horizontal = 8.dp, vertical = 8.dp))
            }
            item {
                AnimateSize(modifier.padding(horizontal = 8.dp, vertical = 8.dp))
            }
            item {
                AnimateColor(modifier.padding(horizontal = 8.dp, vertical = 8.dp))
            }
            item {
                AnimateInt(modifier.padding(horizontal = 8.dp, vertical = 8.dp))
            }
            item {
                AnimateColorWithSnap(modifier.padding(horizontal = 8.dp, vertical = 8.dp))
            }
            item {
                Spacer(modifier = modifier.height(80.dp))
            }
        })
}

@Composable
private fun AnimateMultiple(modifier: Modifier = Modifier) {
    var state by remember { mutableStateOf(AnimationDisplayListState()) }

    val color by animateColorAsState(
        targetValue = if (state.isAnimateColorItem) Purple500 else Indicator,
    )
    val scale by animateFloatAsState(
        targetValue = if (state.isAnimateFloatItem) 1f else 2f,
    )
    val offset by animateDpAsState(
        targetValue = if (state.isAnimateDpItem) 130.dp else 10.dp,
        tween(1000)
    )

    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = color
    ) {
        Column {
            Text(
                modifier = modifier
                    .scale(scale)
                    .absoluteOffset(x = offset)
                    .padding(top = 8.dp, start = 8.dp),
                text = "Akshay",
                style = TextStyle(
                    fontFamily = if (state.isAnimateFloatItem) FontFamily.Cursive else FontFamily.Monospace,
                ),
                fontWeight = FontWeight.Bold,
                color = Teal200
            )
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Teal200),
                onClick = {
                    state = state.copy(
                        isAnimateColorItem = !state.isAnimateColorItem,
                        isAnimateFloatItem = !state.isAnimateFloatItem,
                        isAnimateDpItem = !state.isAnimateDpItem
                    )
                }) {
                Text(text = "Animate using Color/Dp/Float Value")
            }
        }
    }
}

@Composable
private fun AnimateColor(modifier: Modifier = Modifier) {

    var state by remember { mutableStateOf(AnimationDisplayListState()) }
    val color by animateColorAsState(
        targetValue = if (state.isAnimateColorItem) Purple500 else Indicator,
    )

    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = color
    ) {
        Column {
            Text(
                modifier = modifier
                    .padding(top = 8.dp, start = 8.dp),
                text = "animateColorAsState \nAnimationSpec = spring",
                fontWeight = FontWeight.Bold,
                color = Teal200
            )
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Teal200),
                onClick = { state = state.copy(isAnimateColorItem = !state.isAnimateColorItem) }) {
                Text(text = "Animate using Color Value")
            }
        }
    }
}

@Composable
private fun AnimateColorWithSnap(modifier: Modifier = Modifier) {

    var state by remember { mutableStateOf(AnimationDisplayListState()) }
    val color by animateColorAsState(
        targetValue = if (state.isAnimateColorItem) Purple500 else Indicator,
        animationSpec = snap(500)
    )

    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = color
    ) {
        Column {
            Text(
                modifier = modifier
                    .padding(top = 8.dp, start = 8.dp),
                text = "animateColorAsState \nAnimationSpec = snap(500)",
                fontWeight = FontWeight.Bold,
                color = Teal200
            )
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Teal200),
                onClick = { state = state.copy(isAnimateColorItem = !state.isAnimateColorItem) }) {
                Text(text = "Animate using Color Value")
            }
        }
    }
}

@Composable
private fun AnimateScale(modifier: Modifier = Modifier) {
    var state by remember { mutableStateOf(AnimationDisplayListState()) }
    val scale by animateFloatAsState(
        targetValue = if (state.isAnimateFloatItem) 1f else 2f,
    )

    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Purple500
    ) {
        Column {
            Text(
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .scale(scale)
                    .padding(top = 8.dp, start = 8.dp),
                text = "animateFloatAsState",
                fontWeight = FontWeight.Bold,
                color = Teal200
            )
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Teal200),
                onClick = { state = state.copy(isAnimateFloatItem = !state.isAnimateFloatItem) }) {
                Text(text = "Animate using Float Value")
            }
        }
    }

}

@Composable
private fun AnimateDp(modifier: Modifier = Modifier) {
    var state by remember { mutableStateOf(AnimationDisplayListState()) }
    val offset by animateDpAsState(
        targetValue = if (state.isAnimateDpItem) 120.dp else 5.dp,
        tween(1000)
    )

    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Purple500
    ) {
        Column {
            Text(
                modifier = modifier
                    .absoluteOffset(x = offset)
                    .padding(top = 8.dp, start = 8.dp),
                text = "animateDpAsState \nAnimation Spec = tween(1000)",
                fontWeight = FontWeight.Bold,
                color = Teal200
            )
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Teal200),
                onClick = { state = state.copy(isAnimateDpItem = !state.isAnimateDpItem) }) {
                Text(text = "Animate using Density Pixel Value")
            }
        }
    }

}

@Composable
private fun AnimateInt(modifier: Modifier = Modifier) {
    var state by remember { mutableStateOf(AnimationDisplayListState()) }
    val number by animateIntAsState(
        targetValue = if (state.isAnimateIntItem) 0 else 20
    )

    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Purple500
    ) {
        Column {
            Text(
                modifier = Modifier
                    .padding(top = number.dp, start = 8.dp),
                text = "animateIntAsState",
                fontWeight = FontWeight.Bold,
                color = Teal200
            )
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Teal200),
                onClick = { state = state.copy(isAnimateIntItem = !state.isAnimateIntItem) }) {
                Text(text = "Animate using Int Value")
            }
        }
    }

}

@Composable
private fun AnimateRectangle(modifier: Modifier = Modifier) {
    var state by remember { mutableStateOf(AnimationDisplayListState()) }
    val rectangle by animateRectAsState(
        targetValue = if (state.isAnimateRectItem)
            Rect(210f, 10f, 300f, 80f) else
            Rect(10f, 10f, 130f, 80f),
    )

    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Purple500
    ) {
        Column {
            Text(
                modifier = modifier
                    .padding(top = 8.dp, start = 8.dp),
                text = "animateRectAsState",
                fontWeight = FontWeight.Bold,
                color = Teal200
            )
            Box(
                modifier = modifier
                    .offset(rectangle.left.dp, rectangle.top.dp)
                    .size(rectangle.width.dp, rectangle.height.dp)
                    .background(Indicator)
            )
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Teal200),
                onClick = { state = state.copy(isAnimateRectItem = !state.isAnimateRectItem) }) {
                Text(text = "Animate using Rectangle Value")
            }
        }
    }

}

@Composable
private fun AnimateSize(modifier: Modifier = Modifier) {
    var state by remember { mutableStateOf(AnimationDisplayListState()) }
    val rectangle by animateSizeAsState(
        targetValue = if (state.isAnimateSizeItem) Size(200f, 50f) else Size(100f, 10f),
    )

    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Purple500
    ) {
        Column {
            Text(
                modifier = modifier
                    .padding(top = 8.dp, start = 8.dp),
                text = "animateSizeAsState",
                fontWeight = FontWeight.Bold,
                color = Teal200
            )
            Box(
                modifier = modifier
                    .size(rectangle.width.dp, rectangle.height.dp)
                    .background(Indicator)
            )
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Teal200),
                onClick = { state = state.copy(isAnimateSizeItem = !state.isAnimateSizeItem) }) {
                Text(text = "Animate using Size Value")
            }
        }
    }

}
