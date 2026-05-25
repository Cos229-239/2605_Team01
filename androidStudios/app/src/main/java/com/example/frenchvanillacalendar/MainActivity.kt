package com.example.frenchvanillacalendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.frenchvanillacalendar.ui.theme.FrenchVanillaCalendarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FrenchVanillaCalendarTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CalendarScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
data class CalendarEvent(
    val title: String,
    val date: String,
    val time: String,
    val category: String,
)
@Composable
fun CalendarScreen(modifier: Modifier = Modifier) {
    val events = listOf(
        CalendarEvent(
            title = "Homework",
            date = "June 10, 2026",
            time = "3:00 PM",
            category = "School"
        ),
        CalendarEvent(
            title = "The PACER Exam",
            date = "June 14, 2026",
            time = "10:00 AM",
            category = "School"
        )
    )
    Text(
        text = "Calendar setup started - ${events.size} events loaded",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun CalendarPreview() {
    FrenchVanillaCalendarTheme {
        CalendarScreen()
    }
}