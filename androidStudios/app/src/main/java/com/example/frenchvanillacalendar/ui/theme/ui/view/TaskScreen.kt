package com.example.frenchvanillacalendar.ui.theme.ui.view

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.frenchvanillacalendar.R

@Composable
fun TaskScreen () {
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
    Column(modifier = Modifier
        .verticalScroll(scrollState)
        .background(Color(29, 29, 29)) // changed based on dark or light theme
        .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = "Categories Showing",
            color = Color(204, 134, 255), // change based on dark or light theme
            modifier = Modifier.padding(bottom = 12.dp)
        )
        Box(
            modifier = Modifier
                .padding(all = 20.dp)
                .width(500.dp)
                .size(90.dp)
                .border(width = 2.dp, color = Color(35, 35, 35)) // change based on dark or light theme
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 20.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // code for boxes that show the catagories showing
                // need to add one for each category user has set
                Box(
                    modifier = Modifier
                        .padding(all = 10.dp)
                        .width(80.dp)
                        .size(80.dp)
                        .clip(RoundedCornerShape(18.dp))
                        .border(width = 2.dp, color = Color(84, 188, 223)) // change to color user selects
                        .background(color = Color(84, 188, 223)) // change to color user selects if showing
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Fun", // change to user's catigory title
                        color = Color(0, 0, 0) // change to update based on bg color
                    )
                }
            }
        }
        Text(
            text = "Today, Oct. 1", // change for which day the next item is due
            color = Color(255, 255,255) // change based on dark or light theme
        )
        // resize and respace based on text length
        Box(modifier = Modifier
            .padding(all = 20.dp)
            .width(500.dp)
            .size(50.dp)
            .border(width = 2.dp, color = Color(35, 35, 35)) // change based on dark or light theme
            .fillMaxSize(),
            contentAlignment = Alignment.CenterStart
        ){
            IconButton(onClick = { isToggled1 = !isToggled1 }){
                Image(
                    painter = painterResource(id = imageRes1),
                    contentDescription = "Toggle Task Completion Button"
                )
            }
            Row(
                modifier = Modifier.padding(start = 50.dp)
            ){
                Text(
                    text = "Go Swimming", // change for user's task title
                    color = Color(84, 188, 223), // change for user's task's catagory's color
                    modifier = Modifier.padding(all = 5.dp)
                )
                Text(
                    text = "5:00pm", // change for user's task's time due
                    color = Color(204, 134, 255), // change for light or dark theme mode
                    modifier = Modifier.padding(top = 5.dp, end = 5.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.exclimation_placeholder_icon),
                    contentDescription = "Importance + 1",
                    colorFilter = ColorFilter.tint(Color(214, 182, 0)), // change to be based on user's task's importance and based on light or dark theme
                    modifier = Modifier
                        .size(50.dp, 25.dp)
                        .padding(top = 5.dp)
                )
            }
        }
        Box(modifier = Modifier
            .padding(all = 20.dp)
            .width(500.dp)
            .size(50.dp)
            .border(width = 2.dp, color = Color(35, 35, 35)) // change based on dark or light theme
            .fillMaxSize(),
            contentAlignment = Alignment.CenterStart
        ){
            IconButton(onClick = { isToggled2 = !isToggled2 }){
                Image(
                    painter = painterResource(id = imageRes2),
                    contentDescription = "Toggle Task Completion Button"
                )
            }
            Row(
                modifier = Modifier.padding(start = 50.dp)
            ){
                Text(
                    text = "Read 1 Chapter", // change for user's task title
                    color = Color(84, 188, 223), // change for user's task's catagory's color
                    modifier = Modifier.padding(all = 5.dp)
                )
                Text(
                    text = "11:00pm", // change for user's task's time due
                    color = Color(204, 134, 255), // change for light or dark theme mode
                    modifier = Modifier.padding(all = 5.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.exclimation_placeholder_icon),
                    contentDescription = "Importance + 1",
                    colorFilter = ColorFilter.tint(Color(161, 72, 12)), // change to be based on user's task's importance and based on light or dark theme
                    modifier = Modifier
                        .size(50.dp, 25.dp)
                        .padding(top = 5.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.exclimation_placeholder_icon),
                    contentDescription = "Importance + 1",
                    colorFilter = ColorFilter.tint(Color(161, 72, 12)), // change to be based on user's task's importance and based on light or dark theme
                    modifier = Modifier
                        .size(50.dp, 25.dp)
                        .padding(top = 5.dp)
                )
            }
        }
        Text(
            text = "Tomorrow, Oct. 2", // change for which day the next item is due after one above
            color = Color(255, 255,255) // change based on dark or light theme
        )
        Box(modifier = Modifier
            .padding(all = 20.dp)
            .width(500.dp)
            .size(50.dp)
            .border(width = 2.dp, color = Color(35, 35, 35)) // change based on dark or light theme
            .fillMaxSize(),
            contentAlignment = Alignment.CenterStart
        ){
            IconButton(onClick = { isToggled3 = !isToggled3 }){
                Image(
                    painter = painterResource(id = imageRes3),
                    contentDescription = "Toggle Task Completion Button"
                )
            }
            Row(
                modifier = Modifier.padding(start = 50.dp)
            ){
                Text(
                    text = "Watch A TV Show", // change for user's task title
                    color = Color(84, 188, 223), // change for user's task's catagory's color
                    modifier = Modifier.padding(all = 5.dp)
                )
                Text(
                    text = "6:30pm", // change for user's task's time due
                    color = Color(204, 134, 255), // change for light or dark theme mode
                    modifier = Modifier.padding(all = 5.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.exclimation_placeholder_icon),
                    contentDescription = "Importance + 1",
                    colorFilter = ColorFilter.tint(Color(144, 0, 0)), // change to be based on user's task's importance and based on light or dark theme
                    modifier = Modifier
                        .size(50.dp, 25.dp)
                        .padding(top = 5.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.exclimation_placeholder_icon),
                    contentDescription = "Importance + 1",
                    colorFilter = ColorFilter.tint(Color(144, 0, 0)), // change to be based on user's task's importance and based on light or dark theme
                    modifier = Modifier
                        .size(50.dp, 25.dp)
                        .padding(top = 5.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.exclimation_placeholder_icon),
                    contentDescription = "Importance + 1",
                    colorFilter = ColorFilter.tint(Color(144, 0, 0)), // change to be based on user's task's importance and based on light or dark theme
                    modifier = Modifier
                        .size(50.dp, 25.dp)
                        .padding(top = 5.dp)
                )
            }
        }
        // change size to fit screen depending on how many tasks there are
        Spacer(modifier = Modifier.height(230.dp))
        // make into button to add task
        Box(modifier = Modifier
            .padding(top = 20.dp, bottom = 20.dp, start = 250.dp, end = 20.dp)
            .width(150.dp)
            .size(50.dp)
            .border(width = 2.dp, color = Color(138, 138, 138, 255)) // change based on dark or light theme
            .background(Color(102, 80, 164)) // change based on light or dark theme
        ){
            Image(
                painter = painterResource(id = R.drawable.plus_icon),
                contentDescription = "Plus Sign",
                colorFilter = ColorFilter.tint(Color(84, 188, 223)), // change to be based on user's task's importance and based on light or dark theme
                modifier = Modifier
                    .size(50.dp, 50.dp)
                    .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 5.dp)
            )
            Text(
                text = "Add Task",
                color = Color(84, 188, 223), // change depending on light or dark theme
                modifier = Modifier.fillMaxSize()
                    .padding(start = 55.dp, end = 5.dp, top = 15.dp, bottom = 15.dp)
            )
        }
        // end button

        // add a way to delete tasks
    }
}