package com.example.frenchvanillacalendar.ui.theme.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.frenchvanillacalendar.ui.theme.FrenchVanillaCalendarTheme
import java.util.Calendar


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

    val monthName = "June"
    val year = 2026
    val month = Calendar.JUNE
    var weekStartsOn by remember { mutableIntStateOf(Calendar.SUNDAY) }

    val calendar = Calendar.getInstance().apply {
        set(year, month, 1)
    }

    val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    val firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
    val startingBlankDays = (firstDayOfWeek - weekStartsOn + 7) % 7

    Column(modifier = modifier) {
        Text(
            text = "$monthName $year"
        )
        Spacer(modifier = Modifier.height(8.dp))

        WeekdayRow(weekStartsOn = weekStartsOn)
        Spacer(modifier = Modifier.height(8.dp))

        Row {
            Button(onClick = { weekStartsOn = Calendar.SUNDAY }) {
                Text(text = "Sunday")
            }

            Button(onClick = { weekStartsOn = Calendar.MONDAY }) {
                Text(text = "Monday")
            }
        }

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
    val calendarSlots = List(startingBlankDays) { "" } + (1..daysInMonth).map { day ->
        day.toString()
    }
    val trailingBlankDays = (7 - calendarSlots.size % 7) % 7
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
fun WeekdayRow(weekStartsOn: Int) {
    val weekdays = if (weekStartsOn == Calendar.MONDAY) {
        listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
    } else {
        listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")
    }
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