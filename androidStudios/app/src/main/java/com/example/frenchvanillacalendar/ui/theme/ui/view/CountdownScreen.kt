package com.example.frenchvanillacalendar.ui.theme.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.frenchvanillacalendar.EventCountdownTimer
import java.util.Locale
import androidx.compose.runtime.*


@Composable

fun CountdownScreen
            (eventTimerMillis: Long,initialEventName: String? )

{

    var timerText by remember{ mutableStateOf("00D 00H 00M 00S 00MS") }
    var eventName = initialEventName ?: "Unknown Event"
    var eventStatus by remember{ mutableStateOf("Time Remaining..")}
    var countdownTimer: EventCountdownTimer? = null

    LaunchedEffect(eventTimerMillis)
    {
        timerText = String.format(Locale.getDefault(), "00D 00H 00M 00S 00MS")
    }

    Box(
        modifier = Modifier.background(Color(0xFF6200EE)),
        contentAlignment = Alignment.Center,

        ){
        Text(text = "Countdowns")
    }

}