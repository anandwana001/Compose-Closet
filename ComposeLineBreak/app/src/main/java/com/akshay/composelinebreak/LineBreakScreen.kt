package com.akshay.composelinebreak

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akshay.composelinebreak.ui.theme.Purple500
import com.akshay.composelinebreak.ui.theme.Teal200

/**
 * Created by anandwana001 on
 * 27, October, 2022
 **/

private const val TITLE_TEXT = "Title of an article"
private const val PARAGRAPH_TEXT =
    "A long paragraph in an article. A long paragraph in an article. A long paragraph in an article. A long paragraph in an article. A long paragraph in an article."

@OptIn(ExperimentalTextApi::class)
@Composable
fun LineBreakScreen(modifier: Modifier = Modifier) {

    LazyColumn(content = {
        item {
            Title(text = "LineBreak = Simple - Text")
            LineBreakItem(modifier, LineBreak.Simple, TITLE_TEXT)
        }
        item {
            Title(text = "LineBreak = Heading - Text")
            LineBreakItem(modifier, LineBreak.Heading, TITLE_TEXT)
        }
        item {
            Title(text = "LineBreak = Paragraph - Text")
            LineBreakItem(modifier.fillMaxWidth(), LineBreak.Paragraph, PARAGRAPH_TEXT)
        }
        item {
            Title(text = "LineBreak = Simple - TextField")
            LineBreakEditItem(modifier.fillMaxWidth(), LineBreak.Simple, PARAGRAPH_TEXT)
        }
    })
}

@Composable
fun Title(text: String) {
    Text(
        modifier = Modifier.padding(start = 8.dp, top = 8.dp),
        text = text
    )
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun LineBreakItem(modifier: Modifier = Modifier, titleLineBreak: LineBreak, text: String) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .width(150.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Purple500,
    ) {
        LineBreakText(modifier = modifier.padding(8.dp), titleLineBreak, text)
    }
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun LineBreakEditItem(modifier: Modifier = Modifier, titleLineBreak: LineBreak, text: String) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .width(150.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Purple500,
    ) {
        LineBreakEditText(modifier = modifier.padding(8.dp), titleLineBreak, text)
    }
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun LineBreakText(modifier: Modifier = Modifier, lineBreak: LineBreak, text: String) {
    Text(
        modifier = modifier,
        text = text,
        style = TextStyle(
            fontSize = 20.sp,
            lineBreak = lineBreak
        ),
        color = Teal200
    )
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun LineBreakEditText(modifier: Modifier = Modifier, lineBreak: LineBreak, text: String) {
    val textState = remember { mutableStateOf(TextFieldValue(text)) }

    BasicTextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        modifier = modifier,
        textStyle = TextStyle(
            fontSize = 20.sp,
            lineBreak = lineBreak,
            color = Teal200
        ),
    )
}
