package com.akshay.composecalendar

import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Surface
import com.akshay.composecalendar.ui.theme.ComposeCalendarTheme

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCalendarTheme {
                Surface {
                    MaterialDatePickerDialog()
                }
            }
        }
    }
}
