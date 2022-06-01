package com.akshay.composecalendar

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.datetime.*
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MaterialDatePickerDialog() {
    val datePicked = remember {
        mutableStateOf(getTodaysDate())
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = dateFormatter(datePicked.value))
        OpenCalendarButton(datePicked.value) {
            datePicked.value = it
        }
    }
}

@Composable
fun OpenCalendarButton(selectedDate: Long, showSelectedDate: (Long) -> Unit) {
    Column {
        val context = LocalContext.current as AppCompatActivity
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 16.dp, 16.dp, 16.dp),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 4.dp,
                pressedElevation = 8.dp
            ),
            onClick = {
                showCalendar(context, selectedDate) {
                    showSelectedDate(it)
                }
            },
        ) {
            Text(
                text = "Open Calendar",
                color = Color.White
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
private fun getTodaysDate(): Long {
    val currentMoment = Clock.System.now()
    return currentMoment.toEpochMilliseconds()
}

@RequiresApi(Build.VERSION_CODES.O)
private fun dateFormatter(milliseconds: Long): String {
    val localDate = Instant.fromEpochMilliseconds(milliseconds).toLocalDateTime(TimeZone.UTC)
        .toJavaLocalDateTime()
    return localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
}

private fun showCalendar(
    context: AppCompatActivity,
    selectedDate: Long,
    updateDate: (Long) -> Unit
) {
    val datePicker =
        MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select date")
            .setSelection(selectedDate)
            .build()
    datePicker.show(context.supportFragmentManager, "")
    datePicker.addOnPositiveButtonClickListener {
        updateDate(it)
    }
}
