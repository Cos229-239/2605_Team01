package com.example.frenchvanillacalendar.ui.theme.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.example.frenchvanillacalendar.R
import com.example.frenchvanillacalendar.data.model.drawerItems
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import kotlinx.coroutines.*
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import java.util.Calendar
import androidx.compose.runtime.mutableStateOf

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawer()
{
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val navController = rememberNavController()
    var selectedItemIndex by remember{ mutableIntStateOf(value = 0) }
    var weekStartsOn by remember { mutableIntStateOf(Calendar.SUNDAY) }
    var weekStartDate by remember { mutableStateOf("June 1, 2026")}      // tracks start day
    var weekLength by remember { mutableIntStateOf(7) }                  // calculates how many days a week

    val items = listOf(
        drawerItems(title = "Calendar", icon = R.drawable.calendar_icon),
        drawerItems(title = "Task Lists", icon = R.drawable.tasklist_icon),
        drawerItems(title = "Countdowns", icon = R.drawable.countdown_icon),
        drawerItems(title = "Settings", icon = R.drawable.settings_icon)
    )

    val screenTitle = when (selectedItemIndex){
        0 -> "Calendar"
        1 -> "Task Lists"
        2 -> "Countdowns"
        3 -> "Settings"
        else -> "Calendar"
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet (drawerContainerColor = Color(102, 80, 164)) {
                Column(
                    modifier = Modifier.fillMaxWidth(fraction = 0.9f)
                        .padding(10.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                ) {
                    Text(
                        text = "French Vanilla Calendar",
                        modifier = Modifier.padding(start = 10.dp)
                            .fillMaxWidth(),
                        color = Color(255,255,255)
                    )
                }


                items.forEachIndexed { index, drawerItems ->
                    NavigationDrawerItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                            scope.launch {
                                drawerState.close()
                                val route = when (selectedItemIndex) {
                                    0 -> "Calendar"
                                    1 -> "Task Lists"
                                    2 -> "Countdowns"
                                    3 -> "Settings"
                                    else -> "Calendar"
                                }

                                navController.navigate(route) {
                                    popUpTo("Calendar") {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        },
                        icon = {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = ImageVector.vectorResource(id = drawerItems.icon),
                                    contentDescription = null,
                                    modifier = Modifier.padding(10.dp)
                                        .size(20.dp),
                                    tint = Color(130, 224, 255)
                                )
                                Text(
                                    text = drawerItems.title,
                                    color = Color(130, 224, 255)
                                )
                            }
                        },
                        label = {
                            Text(text = drawerItems.title)
                        },
                        modifier = Modifier.fillMaxWidth().padding(5.dp)
                    )
                }
            }
        }

    ) {

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = screenTitle,
                            modifier = Modifier.padding(end = 60.dp)
                                .fillMaxWidth(),
                            color = Color(130, 224, 255),
                            textAlign = TextAlign.Center
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(Color(102, 80, 164)),
                    navigationIcon = {
                        OutlinedButton(
                            onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            },
                            shape = CircleShape
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.hamburger_open_menu),
                                contentDescription = null,
                                tint = Color(255,255,255)
                            )
                        }
                    }
                )
            },

            ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "Calendar",
                modifier = Modifier.padding(innerPadding)
            ) {
                composable("Calendar") {
                    CalendarScreen(
                        weekStartsOn = weekStartsOn,        // Users selected starting day
                        weekLength = weekLength             // Days displayed for the week/row
                    )
                }
                composable("Task Lists"){TaskScreen()}
                composable("Countdowns"){CountdownScreen()}
                composable("Settings") {                        // So cool ^^^^
                    SettingsScreen(
                        weekStartsOn = weekStartsOn,                    // Week starting point
                        onWeekStartsOnChange = { selectedDay ->
                            weekStartsOn = selectedDay
                        },
                        weekStartDate = weekStartDate,                  // Week start dates
                        onWeekStartDateChange = { selectedDate ->
                            weekStartDate = selectedDate
                        },
                        weekLength = weekLength,                        // Week length/adjust to user
                        onWeekLengthChange = { selectedLength ->
                            weekLength = selectedLength
                        }
                    )
                }
            }

        }
    }
}
