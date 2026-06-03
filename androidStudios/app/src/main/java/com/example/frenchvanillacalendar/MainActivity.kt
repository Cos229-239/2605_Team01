package com.example.frenchvanillacalendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.frenchvanillacalendar.ui.theme.FrenchVanillaCalendarTheme
import com.example.frenchvanillacalendar.ui.theme.ui.view.NavigationDrawer

//import com.example.frenchvanillacalendar.ui.theme.ui.view.NavigationDrawer

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FrenchVanillaCalendarTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationDrawer()
                    CalendarScreen(
                        modifier = Modifier.padding(innerPadding)
                            .paddingFromBaseline(top = 100.dp)
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
    Column(modifier = modifier) {
        Text(
            text = "Calendar setup started - ${events.size} events loaded"
        )
        Spacer(modifier = Modifier.height(16.dp))
        events.forEach { event ->
            Text(
                text = "${event.date}: ${event.title} at ${event.time}"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalendarPreview() {
    FrenchVanillaCalendarTheme {
        CalendarScreen()
    }
}