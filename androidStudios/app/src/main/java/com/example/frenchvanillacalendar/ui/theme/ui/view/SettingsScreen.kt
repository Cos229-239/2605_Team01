package com.example.frenchvanillacalendar.ui.theme.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import java.util.Calendar
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.frenchvanillacalendar.R

@Composable
fun SettingsScreen (
    weekStartsOn: Int,
    onWeekStartsOnChange: (Int) -> Unit,
    weekStartDate: String,
    onWeekStartDateChange: (String) -> Unit,           // Date detail display
    weekLength: Int,
    onWeekLengthChange: (Int) -> Unit,                 // Updates days in a week!
    selectedMonth: Int,
    selectedYear: Int
) {
    val scrollState = rememberScrollState()
                                                                    // dropdown detection
    var weekStartDateMenuExpanded by remember { mutableStateOf(false) }
    var weekLengthMenuExpanded by remember { mutableStateOf(false) }

    val monthNames = listOf(
        "January", "February", "March", "April", "May", "June", "July", "August", "September",
        "October", "November", "December"
    )

    val selectedMonthName = monthNames[selectedMonth]
    val selectedMonthCalendar = Calendar.getInstance().apply {
        set(selectedYear, selectedMonth, 1)
    }

    val daysInSelectedMonth = selectedMonthCalendar.getActualMaximum(Calendar.DAY_OF_MONTH) // Pulls info/calculation

    val weekStartDateOptions = (1..daysInSelectedMonth).map { day ->
        "$selectedMonthName $day, $selectedYear"
    }

    var expandMonthStartDay by remember {mutableStateOf(false)}
    var expandMonthWeekLength by remember {mutableStateOf(false)}
    var expandWeekStartDay by remember {mutableStateOf(false)}

    val selectedWeekStartLabel = when (weekStartsOn) {  // #'s to text for the settings
        Calendar.SUNDAY -> "Sunday"
        Calendar.MONDAY -> "Monday"
        Calendar.TUESDAY -> "Tuesday"
        Calendar.WEDNESDAY -> "Wednesday"
        Calendar.THURSDAY -> "Thursday"
        Calendar.FRIDAY -> "Friday"
        Calendar.SATURDAY -> "Saturday"
        else -> "Sunday"
    }

    Column(modifier = Modifier
        .verticalScroll(scrollState)
        .background(Color(29, 29, 29))
        .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(                                                               // Josh add this to test settings screen
            text = "Settings",
            color = Color(255,255,255),
            modifier = Modifier.padding(start = 20.dp, bottom = 12.dp)
        )                                                                  // Josh
        Box(modifier = Modifier
            .padding(all = 20.dp)
            .width(500.dp)
            .size(100.dp)
            .border(width = 2.dp, color = Color(35, 35, 35))
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 20.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.login_icon),
                    contentDescription = null,
                    modifier = Modifier.padding(20.dp)
                        .size(20.dp)
                )
                Column{
                    Text(
                        text = "Shane Gilles",
                        color = Color(255, 255, 255)
                    )
                    Text(
                        text = "traending_comedians@aol.com",
                        color = Color(255, 255,255)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "PREFERENCES",
            color = Color(204, 134, 255)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Box(modifier = Modifier
            .padding(start = 50.dp, end = 50.dp)
            .width(500.dp)
            .border(width = 2.dp, color = Color(35, 35, 35))
        ){
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 20.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.edit_notifications),
                        contentDescription = null,
                        modifier = Modifier.padding(10.dp)
                            .size(20.dp)
                    )
                    Text(
                        text = "Notifications",
                        color = Color(255, 255, 255)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 20.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.paint_roller),
                        contentDescription = null,
                        modifier = Modifier.padding(10.dp)
                            .size(20.dp)
                    )
                    Text(
                        text = "Theme",
                        color = Color(255, 255, 255)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 20.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.reminder_time),
                        contentDescription = null,
                        modifier = Modifier.padding(10.dp)
                            .size(20.dp)
                    )
                    Text(
                        text = "Reminder Time",
                        color = Color(255, 255, 255)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Account",
            color = Color(204, 134, 255)
        )
        Box(modifier = Modifier
            .padding(start = 50.dp, end = 50.dp)
            .width(500.dp)
            .border(width = 2.dp, color = Color(35, 35, 35))
        ){
            Column{
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 20.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.profile),
                        contentDescription = null,
                        modifier = Modifier.padding(10.dp)
                            .size(20.dp)
                    )
                    Text(
                        text = "Profile Information",
                        color = Color(255, 255, 255)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 20.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.lock),
                        contentDescription = null,
                        modifier = Modifier.padding(10.dp)
                            .size(20.dp)
                    )
                    Text(
                        text = "Change Password",
                        color = Color(255, 255, 255)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 20.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.privacy_placeholder),
                        contentDescription = null,
                        modifier = Modifier.padding(10.dp)
                            .size(20.dp)
                    )
                    Text(
                        text = "Privacy",
                        color = Color(255, 255, 255)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Appearance of Month",
            color = Color(204, 134, 255)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Box(modifier = Modifier
            .padding(start = 50.dp, end = 50.dp)
            .width(500.dp)
            .border(width = 2.dp, color = Color(35, 35, 35))
        ){
            Column {
                Text(
                    text = "Start Day",
                    modifier = Modifier.padding(20.dp),
                    color = Color(255, 255, 255)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 20.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.edit_calendar_placeholder),
                        contentDescription = null,
                        modifier = Modifier.padding(10.dp)
                            .size(20.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Box(modifier = Modifier
                        .width(200.dp)
                        .size(50.dp)
                        .border(width = 2.dp, color = Color(35, 35, 35))
                        .clickable { weekStartDateMenuExpanded = true } // Opens start date options
                    ) {
                        Row() {
                            Text(
                                text = weekStartDate,              // Updated to week start date
                                color = Color(255, 255, 255),
                                modifier = Modifier
                                    .padding(
                                        top = 10.dp,
                                        start = 10.dp,
                                        bottom = 10.dp,
                                        end = 80.dp
                                    )
                            )
                            Button(
                                onClick = { expandMonthStartDay = true },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(29, 29, 29)
                                )
                            ) {
                                Image(
                                    imageVector = ImageVector.vectorResource(id = R.drawable.right_arrow),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(20.dp)
                                )
                            }
                        }
                        DropdownMenu(
                            expanded = expandMonthStartDay,
                            onDismissRequest = { expandMonthStartDay = false }
                        ) {
                            DropdownMenuItem(
                                text = { Text("Sunday") },
                                onClick = {
                                    expandMonthStartDay = false
                                    onWeekStartDateChange("Sunday")
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Monday") },
                                onClick = {
                                    expandMonthStartDay = false
                                    onWeekStartDateChange("Monday")
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Tuesday") },
                                onClick = {
                                    expandMonthStartDay = false
                                    onWeekStartDateChange("Tuesday")
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Wednesday") },
                                onClick = {
                                    expandMonthStartDay = false
                                    onWeekStartDateChange("Wednesday")
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Thursday") },
                                onClick = {
                                    expandMonthStartDay = false
                                    onWeekStartDateChange("Thursday")
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Friday") },
                                onClick = {
                                    expandMonthStartDay = false
                                    onWeekStartDateChange("Friday")
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Saturday") },
                                onClick = {
                                    expandMonthStartDay = false
                                    onWeekStartDateChange("Saturday")
                                }
                            )
                        }
                        DropdownMenu(
                            expanded = weekStartDateMenuExpanded,
                            onDismissRequest = {
                                weekStartDateMenuExpanded = false
                            }
                        ) {
                            weekStartDateOptions.forEach { dateOption ->
                                DropdownMenuItem(
                                    text = {
                                        Text(text = dateOption)
                                    },
                                    onClick = {
                                        onWeekStartDateChange(dateOption)
                                        weekStartDateMenuExpanded = false
                                    }
                                )
                            }
                        }
                    }
                }

                Text(
                    text = "View",
                    modifier = Modifier.padding(20.dp),
                    color = Color(255, 255, 255)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 20.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.calendar_view_day),
                        contentDescription = null,
                        modifier = Modifier.padding(10.dp)
                            .size(20.dp)
                    )
                    Box(modifier = Modifier
                        .width(200.dp)
                        .size(50.dp)
                        .border(width = 2.dp, color = Color(35, 35, 35))
                    ){
                        Row{
                            Text(
                                text = "Day/Details",
                                color = Color(255, 255, 255),
                                modifier = Modifier
                                    .padding(top = 10.dp,
                                        start = 10.dp,
                                        bottom = 10.dp,
                                        end = 45.dp)
                            )
                            // TODO make button
                            Image(
                                imageVector = ImageVector.vectorResource(id = R.drawable.right_arrow),
                                contentDescription = null,
                                modifier = Modifier.padding(15.dp)
                                    .size(20.dp)
                            )
                        }
                    }
                }
                Text(
                    text = "Week Length",
                    modifier = Modifier.padding(20.dp),
                    color = Color(255, 255, 255)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 20.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.edit_calendar_placeholder),
                        contentDescription = null,
                        modifier = Modifier.padding(10.dp)
                            .size(20.dp)
                    )
                    Box(modifier = Modifier
                        .width(200.dp)
                        .size(50.dp)
                        .border(width = 2.dp, color = Color(35, 35, 35))
                        .clickable { weekLengthMenuExpanded = true }            // Opens/Expand when selected
                    ){
                        Row() {
                            Text(                                    // Single days to multiple day reply.
                                text = if (weekLength == 1) "1 Day" else "$weekLength Days",
                                color = Color(255, 255, 255),
                                modifier = Modifier
                                    .padding(top = 10.dp,
                                        start = 10.dp,
                                        bottom = 10.dp,
                                        end = 55.dp)
                            )
                            Button(
                                onClick = { expandMonthWeekLength = true },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(29, 29, 29)
                                )
                            ) {
                                Image(
                                    imageVector = ImageVector.vectorResource(id = R.drawable.right_arrow),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(20.dp)
                                )
                            }
                        }
                        DropdownMenu(
                            expanded = expandMonthWeekLength,
                            onDismissRequest = { expandMonthWeekLength = false }
                        ) {
                            DropdownMenuItem(
                                text = { Text("5 Days") },
                                onClick = {
                                    expandMonthWeekLength = false
                                    onWeekLengthChange(5)
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("7 Days") },
                                onClick = {
                                    expandMonthWeekLength = false
                                    onWeekLengthChange(7)
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("10 Days") },
                                onClick = {
                                    expandMonthWeekLength = false
                                    onWeekLengthChange(10)
                                }
                            )
                        }
                        DropdownMenu(                           //  Display wee-length choices
                            expanded = weekLengthMenuExpanded,
                            onDismissRequest = {
                                weekLengthMenuExpanded = false  // Close button (outside click)
                            }
                        ) {                                     // Dropdown for every option 1-10
                            (1..10).forEach { length ->
                                DropdownMenuItem(
                                    text = {
                                        Text(       //  Displays current option with grammar check
                                            text = if (length == 1) "1 Day" else "$length Days"
                                        )
                                    },
                                    onClick = {
                                        onWeekLengthChange(length)      // Saves length and closes
                                        weekLengthMenuExpanded = false
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Appearance of Week",
            color = Color(204, 134, 255)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Box(modifier = Modifier
            .padding(start = 50.dp, end = 50.dp, bottom = 10.dp)
            .width(500.dp)
            .border(width = 2.dp, color = Color(35, 35, 35))
        ){
            Column {
                Text(
                    text = "Start Day",
                    modifier = Modifier.padding(20.dp),
                    color = Color(255, 255, 255)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 20.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.edit_calendar_placeholder),
                        contentDescription = null,
                        modifier = Modifier.padding(10.dp)
                            .size(20.dp)
                    )
                    Box(modifier = Modifier
                        .width(200.dp)
                        .size(50.dp)
                        .border(width = 2.dp, color = Color(35, 35, 35))
                    ){
                        Row{
                            Text(
                                text = selectedWeekStartLabel,                      // week start day
                                color = Color(255, 255, 255),
                                modifier = Modifier
                                    .padding(top = 10.dp,
                                        start = 10.dp,
                                        bottom = 10.dp,
                                        end = 50.dp)
                            )
                            Button(
                                onClick = { expandWeekStartDay = true },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(29, 29, 29)
                                )
                            ) {
                                Image(
                                    imageVector = ImageVector.vectorResource(id = R.drawable.right_arrow),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(20.dp)
                                )
                            }
                        }
                        DropdownMenu(
                            expanded = expandWeekStartDay,
                            onDismissRequest = { expandWeekStartDay = false }
                        ) {
                            DropdownMenuItem(
                                text = { Text("Sunday") },
                                onClick = {
                                    expandWeekStartDay = false
                                    onWeekStartsOnChange(Calendar.SUNDAY)
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Monday") },
                                onClick = {
                                    expandWeekStartDay = false
                                    onWeekStartsOnChange(Calendar.MONDAY)
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Tuesday") },
                                onClick = {
                                    expandWeekStartDay = false
                                    onWeekStartsOnChange(Calendar.TUESDAY)
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Wednesday") },
                                onClick = {
                                    expandWeekStartDay = false
                                    onWeekStartsOnChange(Calendar.WEDNESDAY)
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Thursday") },
                                onClick = {
                                    expandWeekStartDay = false
                                    onWeekStartsOnChange(Calendar.THURSDAY)
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Friday") },
                                onClick = {
                                    expandWeekStartDay = false
                                    onWeekStartsOnChange(Calendar.FRIDAY)
                                }
                            )
                            DropdownMenuItem(
                                text = { Text("Saturday") },
                                onClick = {
                                    expandWeekStartDay = false
                                    onWeekStartsOnChange(Calendar.SATURDAY)
                                }
                            )
                        }
                    }
                }

                Text(
                    text = "View",
                    modifier = Modifier.padding(20.dp),
                    color = Color(255, 255, 255)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 20.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.details_view),
                        contentDescription = null,
                        modifier = Modifier.padding(10.dp)
                            .size(20.dp)
                    )
                    Box(modifier = Modifier
                        .width(200.dp)
                        .size(50.dp)
                        .border(width = 2.dp, color = Color(35, 35, 35))
                    ){
                        Row {
                            Text(
                                text = "Details",
                                color = Color(255, 255, 255),
                                modifier = Modifier
                                    .padding(top = 10.dp,
                                        start = 10.dp,
                                        bottom = 10.dp,
                                        end = 80.dp)
                            )
                            Image(
                                imageVector = ImageVector.vectorResource(id = R.drawable.right_arrow),
                                contentDescription = null,
                                modifier = Modifier.padding(15.dp)
                                    .size(20.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}