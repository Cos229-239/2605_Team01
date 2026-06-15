package com.example.frenchvanillacalendar

import android.content.IntentSender
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.frenchvanillacalendar.ui.theme.FrenchVanillaCalendarTheme
import android.os.CountDownTimer //import the countdown timer

//EventCountdownTimer class created
class EventCountdownTimer(private val eventTimeMillis: Long,
                          private val onTick: (days: Long, hours: Long, minutes: Long, seconds: Long) -> Unit,
                          private val onFinish:() -> Unit)

{private var timer: CountDownTimer? = null
    fun start(){
        val millisUntilEvent = eventTimeMillis - System.currentTimeMillis()

        if (millisUntilEvent <= 0){
                onFinish()
                return
            }
        timer = object: CountDownTimeer(millisUntilEvent, 1000L)
        {
            override fun onTick(millisUntilFinished: Long)
            {
                val days = millisUntilFinished / (1000 * 60 * 60 *24)
                val hours = (millisUntilFinished / (1000 * 60 * 60)) % 24
                val minutes = (millisUntilFinished /(1000 * 60)) % 60
                val seconds = (millisUntilFinished / 1000) % 60
                onTick(days, hours, minutes, seconds)
            }
        }

    }
}


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