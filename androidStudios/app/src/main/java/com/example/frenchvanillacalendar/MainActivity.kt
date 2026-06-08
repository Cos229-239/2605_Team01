package com.example.frenchvanillacalendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    }
}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FrenchVanillaCalendarTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FrenchVanillaCalendarTheme {
        Greeting("Android")
    }
}