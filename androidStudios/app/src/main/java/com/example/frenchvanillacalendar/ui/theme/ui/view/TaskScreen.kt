package com.example.frenchvanillacalendar.ui.theme.ui.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.frenchvanillacalendar.R
import java.time.LocalDate
import java.time.LocalTime


data class TaskCategory(
    val title: String,
    val color: Color,
    val tasks: List<Task>
)

data class Task(
    val title: String,
    val dateDue: LocalDate,
    val dueTime: LocalTime,
    val timeStr: String,
    val importance: Int
)


@Composable
fun TaskRow(
    cat: TaskCategory,
    task: Task
) {
    // TODO fix spacing
    Row(
        modifier = Modifier.padding(start = 50.dp)
    ){
        Text(
            text = task.title, // change for user's task title
            color = cat.color, // change for user's task's catagory's color
            modifier = Modifier.padding(all = 5.dp)
        )
        Text(
            text = task.timeStr, // change for user's task's time due
            color = Color(204, 134, 255),
            // TODO change for light or dark theme mode
            modifier = Modifier.padding(top = 5.dp, end = 5.dp)
        )
        if(task.importance == 1) {
            Image(
                painter = painterResource(id = R.drawable.exclimation_placeholder_icon),
                contentDescription = "Importance + 1",
                colorFilter = ColorFilter.tint(Color(214, 182, 0)),
                // changes based on user's task's importance
                // TODO change based on light or dark theme
                modifier = Modifier
                    .size(50.dp, 25.dp)
                    .padding(top = 5.dp)
            )
        }
        else if (task.importance == 2){
            Image(
                painter = painterResource(id = R.drawable.exclimation_placeholder_icon),
                contentDescription = "Importance + 1",
                colorFilter = ColorFilter.tint(Color(161, 72, 12)),
                // changes based on user's task's importance
                // TODO change based on light or dark theme
                modifier = Modifier
                    .size(50.dp, 25.dp)
                    .padding(top = 5.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.exclimation_placeholder_icon),
                contentDescription = "Importance + 1",
                colorFilter = ColorFilter.tint(Color(161, 72, 12)),
                // changes based on user's task's importance
                // TODO change based on light or dark theme
                modifier = Modifier
                    .size(50.dp, 25.dp)
                    .padding(top = 5.dp)
            )
        }
        else {
            Image(
                painter = painterResource(id = R.drawable.exclimation_placeholder_icon),
                contentDescription = "Importance + 1",
                colorFilter = ColorFilter.tint(Color(144, 0, 0)),
                // changes based on user's task's importance
                // TODO change based on light or dark theme
                modifier = Modifier
                    .size(50.dp, 25.dp)
                    .padding(top = 5.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.exclimation_placeholder_icon),
                contentDescription = "Importance + 1",
                colorFilter = ColorFilter.tint(Color(144, 0, 0)),
                // changes based on user's task's importance
                // TODO change based on light or dark theme
                modifier = Modifier
                    .size(50.dp, 25.dp)
                    .padding(top = 5.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.exclimation_placeholder_icon),
                contentDescription = "Importance + 1",
                colorFilter = ColorFilter.tint(Color(144, 0, 0)),
                // changes based on user's task's importance
                // TODO change based on light or dark theme
                modifier = Modifier
                    .size(50.dp, 25.dp)
                    .padding(top = 5.dp)
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TaskScreen () {
    // TODO change to be the tasks the user has created
    val cat1 = TaskCategory(
        title = "Fun",
        // TODO change to title user picks
        color = Color(84, 188, 223),
        // TODO change to color user picks
        tasks = listOf(
            Task(
                title = "Go Swimming",
                dateDue = LocalDate.of(2026, 6, 18),
                dueTime = LocalTime.of(17, 0),
                timeStr = "5:00pm",
                importance = 1
            ),
            Task(
                title = "Read 1 Chapter",
                dateDue = LocalDate.of(2026, 6, 18),
                dueTime = LocalTime.of(23, 0),
                timeStr = "11:00pm",
                importance = 1
            )
        )
        // TODO change to tasks user has set
    )
    val cat2 = TaskCategory(
        title = "School",
        // TODO change to title user picks
        color = Color(151, 186, 255),
        // TODO change to color user picks
        tasks = listOf(
            Task(
                title = "Calc WS",
                dateDue = LocalDate.of(2026, 6, 19),
                dueTime = LocalTime.of(17, 0),
                timeStr = "5:00pm",
                importance = 3
            ),
            Task(
                title = "Code for 10 min",
                dateDue = LocalDate.of(2026, 6, 19),
                dueTime = LocalTime.of(16, 0),
                timeStr = "4:00pm",
                importance = 1
            )
        )
        // TODO change to tasks user has set
    )
    val scrollState = rememberScrollState()
    // optomize to create one for each task
    var isToggled1 by remember { mutableStateOf(false) }
    val imageRes1 = if (isToggled1) {
        R.drawable.complete_task_icon
    } else {
        R.drawable.incomplete_task_icon
    }
    var isToggled2 by remember { mutableStateOf(false) }
    val imageRes2 = if (isToggled2) {
        R.drawable.complete_task_icon
    } else {
        R.drawable.incomplete_task_icon
    }
    var isToggled3 by remember { mutableStateOf(false) }
    val imageRes3 = if (isToggled3) {
        R.drawable.complete_task_icon
    } else {
        R.drawable.incomplete_task_icon
    }
    // TODO optomize to create one for each category
    var isToggledCat1 by remember {mutableStateOf(true)}
    var isToggledCat2 by remember {mutableStateOf(true)}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(29, 29, 29))
            // TODO change based on dark or light theme
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = "Categories Showing",
            fontSize = 24.sp,
            color = Color(204, 134, 255),
            // TODO change based on dark or light theme
            modifier = Modifier.padding(top = 10.dp)
        )
        Box(
            modifier = Modifier
                .padding(all = 20.dp)
                .width(500.dp)
                .size(90.dp)
                .border(width = 2.dp, color = Color(35, 35, 35))
                // TODO change based on dark or light theme
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 20.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // code for boxes that show the catagories showing
                // TODO need to add one for each category user has
                if (isToggledCat1) {
                    Button(
                        onClick =  { isToggledCat1 = !isToggledCat1 },
                        modifier = Modifier
                            .padding(all = 5.dp)
                            .width(100.dp)
                            .size(100.dp)
                            .fillMaxSize(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = cat1.color // change to color user selects
                        ),
                        border = BorderStroke(width = 2.dp, color = cat1.color), // change to color user selects
                        shape = RoundedCornerShape(15.dp)
                    ) {
                        Text(
                            text = cat1.title, // change to user's catigory title
                            color = Color(0, 0, 0)// change to color user selects
                        )
                    }
                }
                else {
                    Button(
                        onClick =  { isToggledCat1 = !isToggledCat1 },
                        modifier = Modifier
                            .padding(all = 5.dp)
                            .width(100.dp)
                            .size(100.dp)
                            .fillMaxSize(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(35, 35, 35)
                        ),
                        border = BorderStroke(width = 2.dp, color = cat1.color), // change to color user selects
                        shape = RoundedCornerShape(15.dp)
                    ) {
                        Text(
                            text = cat1.title, // change to user's catigory title
                            color = Color(255, 255, 255) // change to update based on bg color
                        )
                    }
                }
                if (isToggledCat2) {
                    OutlinedButton(
                        onClick =  { isToggledCat2 = !isToggledCat2 },
                        modifier = Modifier
                            .padding(all = 5.dp)
                            .width(100.dp)
                            .size(100.dp)
                            .fillMaxSize(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = cat2.color // change to color user selects
                        ),
                        border = BorderStroke(width = 2.dp, color = cat2.color), // change to color user selects
                        shape = RoundedCornerShape(15.dp)
                    ) {
                        Text(
                            text = cat2.title, // change to user's catigory title
                            color = Color(0, 0, 0)// change to color user selects
                        )
                    }
                }
                else {
                    Button(
                        onClick =  { isToggledCat2 = !isToggledCat2 },
                        modifier = Modifier
                            .padding(all = 5.dp)
                            .width(100.dp)
                            .size(100.dp)
                            .fillMaxSize(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(35, 35, 35)
                        ),
                        border = BorderStroke(width = 2.dp, color = cat2.color), // change to color user selects
                        shape = RoundedCornerShape(15.dp)
                    ) {
                        Text(
                            text = cat2.title, // change to user's catigory title
                            color = Color(255, 255, 255) // change to update based on bg color
                        )
                    }
                }
            }
        }

        // TODO change to show in oder of due date and multiple cats in one
        // day 1
        if (isToggledCat1) { // temp
            Text(
                text = "Today, June 18",
                // TODO change for which day the next item is due
                color = Color(255, 255, 255)
                // TODO change based on dark or light theme
            )
        }
        // TODO resize and respace based on text length
        // day 1 task 1
        // TODO optomize to change to only show if that cat is showing
        if (isToggledCat1) {
            Box(modifier = Modifier
                .padding(all = 20.dp)
                .width(500.dp)
                .size(50.dp)
                .border(width = 2.dp, color = Color(35, 35, 35))
                // TODO change based on dark or light theme
                .fillMaxSize(),
                contentAlignment = Alignment.CenterStart
            ){
                IconButton(onClick = { isToggled1 = !isToggled1 }){
                    Image(
                        painter = painterResource(id = imageRes1),
                        contentDescription = "Toggle Task Completion Button"
                    )
                }
                TaskRow(cat1, cat1.tasks[0])
            }
        }
        //TODO optomize to go through all user's upcoming tasks
        // day 1 task 2
        // TODO optomize to change to only show if that cat is showing
        if (isToggledCat1) {
            Box(modifier = Modifier
                .padding(all = 20.dp)
                .width(500.dp)
                .size(50.dp)
                .border(width = 2.dp, color = Color(35, 35, 35))
                // TODO change based on dark or light theme
                .fillMaxSize(),
                contentAlignment = Alignment.CenterStart
            ){
                IconButton(onClick = { isToggled2 = !isToggled2 }){
                    Image(
                        painter = painterResource(id = imageRes2),
                        contentDescription = "Toggle Task Completion Button"
                    )
                }
                TaskRow(cat1, cat1.tasks[1])
            }
        }

        // day 2
        if (isToggledCat2) { // temp
            Text(
                text = "Tomorrow, June 19",
                // TODO change for which day the next item is due after one above
                color = Color(255, 255, 255)
                // TODO change based on dark or light theme
            )
        }
        // day 2 task 1
        // TODO optomize to change to only show if that cat is showing
        if (isToggledCat2) {
            Box(modifier = Modifier
                .padding(all = 20.dp)
                .width(500.dp)
                .size(50.dp)
                .border(width = 2.dp, color = Color(35, 35, 35))
                // TODO change based on dark or light theme
                .fillMaxSize(),
                contentAlignment = Alignment.CenterStart
            ) {
                IconButton(onClick = { isToggled3 = !isToggled3 }) {
                    Image(
                        painter = painterResource(id = imageRes3),
                        contentDescription = "Toggle Task Completion Button"
                    )
                }
                TaskRow(cat2, cat2.tasks[0])
            }
        }
        // day 2 task 2
        // TODO optomize to change to only show if that cat is showing
        if (isToggledCat2) {
            Box(modifier = Modifier
                .padding(all = 20.dp)
                .width(500.dp)
                .size(50.dp)
                .border(width = 2.dp, color = Color(35, 35, 35))
                // TODO change based on dark or light theme
                .fillMaxSize(),
                contentAlignment = Alignment.CenterStart
            ) {
                IconButton(onClick = { isToggled3 = !isToggled3 }) {
                    Image(
                        painter = painterResource(id = imageRes3),
                        contentDescription = "Toggle Task Completion Button"
                    )
                }
                TaskRow(cat2, cat2.tasks[1])
            }
        }
        // TODO change size to fit screen depending on how many tasks there are
        Spacer(modifier = Modifier.weight(1f))
        // TODO make into button to add task

        // add task
        Box(modifier = Modifier
            .padding(top = 20.dp, bottom = 20.dp, start = 250.dp, end = 20.dp)
            .width(150.dp)
            .size(50.dp)
            .border(width = 2.dp, color = Color(138, 138, 138, 255)) // change based on dark or light theme
            .background(Color(102, 80, 164))
            // TODO change based on light or dark theme
        ){
            Image(
                painter = painterResource(id = R.drawable.plus_icon),
                contentDescription = "Plus Sign",
                colorFilter = ColorFilter.tint(Color(84, 188, 223)),
                // TODO change based on light or dark theme
                modifier = Modifier
                    .size(50.dp, 50.dp)
                    .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 5.dp)
            )
            Text(
                text = "Add Task",
                color = Color(84, 188, 223),
                // TODO change depending on light or dark theme
                modifier = Modifier.fillMaxSize()
                    .padding(start = 55.dp, end = 5.dp, top = 15.dp, bottom = 15.dp)
            )
        }
        // TODO end button

        // TODO add a way to delete tasks
    }
}