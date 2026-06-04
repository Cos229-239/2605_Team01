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
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
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
    val date: Int,
    val time: String,
    val category: String,
)

@Composable
fun CalendarScreen(modifier: Modifier = Modifier) {
    val events = listOf(
        CalendarEvent(
            title = "Homework",
            date = 10,
            time = "3:00 PM",
            category = "School"
        ),
        CalendarEvent(
            title = "The PACER Exam",
            date = 14,
            time = "10:00 AM",
            category = "School"
        )
    )

    val monthName =  "June"
    val year = 2026
    val daysInMonth = 30
    val startingBlankDays = 1

    Column(modifier = modifier) {
        Text(
            text = "$monthName $year"
        )
        Spacer(modifier = Modifier.height(8.dp))

        WeekdayRow()

        Spacer(modifier = Modifier.height(16.dp))

        MonthGrid(
            events = events,
            daysInMonth = daysInMonth,
            startingBlankDays = startingBlankDays
            )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Calendar setup started - ${events.size} events loaded"
        )

        Spacer(modifier = Modifier.height(16.dp))

        events.forEach { event ->
            Text(
                text = "$monthName ${event.date}, $year: ${event.title} at ${event.time}"
            )
        }
    }
}

@Composable
fun MonthGrid(
    events: List<CalendarEvent>,
    daysInMonth: Int,
    startingBlankDays: Int
) {
    val calendarSlots = List(startingBlankDays) { "" } + (1..daysInMonth).map { day -> day.toString()
    }
    val trailingBlankDays = (7 -calendarSlots.size % 7) % 7
    val weeks = (calendarSlots + List(trailingBlankDays) { "" }).chunked(7)

    Column {
        weeks.forEach { week ->
            Row(modifier = Modifier.fillMaxWidth()) {
                week.forEach { day ->
                    val eventForDay = events.firstOrNull { event ->
                        day.isNotBlank() && event.date == day.toInt()
                    }

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = day,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                         )
                        if (eventForDay != null) {
                            Text(
                                text = "*",
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