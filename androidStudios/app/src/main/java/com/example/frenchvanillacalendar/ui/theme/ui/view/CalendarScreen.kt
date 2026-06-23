package com.example.frenchvanillacalendar.ui.theme.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
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
fun CalendarScreen(
    modifier: Modifier = Modifier,      // Layout mods (parent screens)
    weekStartsOn: Int,                  // Which week days shows first
    weekLength: Int,                     // # of days per week/row
    month: Int,                         // Month from shared navs.
    year: Int,
    weekStartDate: String,              // picked start date from settings
    onPreviousMonth: () -> Unit,        // Moves back a month
    onNextMonth: () -> Unit,
) {
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

    val monthNames = listOf(                                             // List of month's to display.
        "January", "February", "March", "April", "May", "June", "July", "August", "September",
        "October", "November", "December"
    )

    val monthName = monthNames[month]                                    // List to grab from to match month

    val calendar = Calendar.getInstance().apply {
        set(year, month, 1)
    }
                        // Includes the tricky leap year and does math for me.
    val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
    val firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
    val startingBlankDays = (firstDayOfWeek - weekStartsOn + 7) % 7
                                        // Placement for header
    Column(modifier = modifier.padding(top = 86.dp)) {
        Row(                                                        // Header is a cleaner setup
            modifier = Modifier.fillMaxWidth(),                     // Flushed size
            horizontalArrangement = Arrangement.SpaceBetween,       // Controls for next month
            verticalAlignment = Alignment.CenterVertically          // Screen structure
        ) {
            Button(onClick = onPreviousMonth) {
                Text(text = "<")                        // < Button function
            }

            Text(text = "$monthName $year")
            Button(onClick = onNextMonth) {
                Text(text = ">")                        // Forward button >
            }
        }

            Spacer(modifier = Modifier.height(8.dp))

            WeekdayRow(weekStartsOn = weekStartsOn)
            Spacer(modifier = Modifier.height(8.dp))

            Spacer(modifier = Modifier.height(16.dp))

            MonthGrid(
                events = events,
                daysInMonth = daysInMonth,
                startingBlankDays = startingBlankDays
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Week starts: $weekStartDate"
            )

            Spacer(modifier = Modifier.height(8.dp))


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
    val trailingBlankDays =                              // Calculates empty cell for final row
        (7 - calendarSlots.size % 7) % 7

    val weeks =                                         // Splits calendar cells into rows
        (calendarSlots + List(trailingBlankDays) { "" }).chunked(7)

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
    val weekdays = listOf(              // Pairing labels
        Calendar.SUNDAY to "Sun",
        Calendar.MONDAY to "Mon",
        Calendar.TUESDAY to "Tue",
        Calendar.WEDNESDAY to "Wed",
        Calendar.THURSDAY to "Thu",
        Calendar.FRIDAY to "Fri",
        Calendar.SATURDAY to "Sat"
    )
    // start day verify with settings
    val startIndex = weekdays.indexOfFirst { it.first == weekStartsOn }
    // Keeps day ordered after start day determined
    val orderedWeekdays = weekdays.drop(startIndex) + weekdays.take(startIndex)

    Row(modifier = Modifier.fillMaxWidth()) {       // Flushed display
        orderedWeekdays.forEach { day ->            // Order to follow
            Text(
                text = day.second,
                textAlign = TextAlign.Center,       // Location
                modifier = Modifier.weight(1f)      // Weekday has equal space in the row
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalendarPreview() {
    FrenchVanillaCalendarTheme {
        CalendarScreen(
            weekStartsOn = Calendar.SUNDAY,        // Shows previous week
            weekLength = 7,                         // Basic 7 day layout
            month = Calendar.JUNE,
            year = 2026,
            weekStartDate = "June 1, 2026",
            onPreviousMonth = {},                   // Testing > < functions
            onNextMonth = {}
        )
    }
}