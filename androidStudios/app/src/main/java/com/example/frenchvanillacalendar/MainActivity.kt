package com.example.frenchvanillacalendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

    Column(modifier = modifier) {
        Text(
            text = "June 2026"
        )
        Spacer(modifier = Modifier.height(8.dp))

        WeekdayRow()

        Spacer(modifier = Modifier.height(16.dp))

        MonthGrid(events = events)

        Spacer(modifier = Modifier.height(16.dp))

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

@Composable
fun MonthGrid(events: List<CalendarEvent>) {
    val weeks = listOf(
        listOf("", "1", "2", "3", "4", "5", "6"),
        listOf("7", "8", "9", "10", "11", "12", "13"),
        listOf("14", "15", "16", "17", "18", "19", "20"),
        listOf("21", "22", "23", "24", "25", "26", "27"),
        listOf("28", "29", "30", "", "", "", "")
    )

    Column {
        weeks.forEach { week ->
            Row(modifier = Modifier.fillMaxWidth()) {
                week.forEach { day ->
                    val eventForDay = events.firstOrNull { event ->
                        event.date == "June $day, 2026"
                    }

                    Column(modifier = Modifier.weight(1f)) {
                     Text(
                         text = day,
                         textAlign = TextAlign.Center,
                         modifier = Modifier.fillMaxWidth()
                     )
                        if (eventForDay != null) {
                            Text(
                                text = "*",  // Event Temp Event Name
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun WeekdayRow() {
    val weekdays = listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        weekdays.forEach { day ->
            Text(text = day)
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