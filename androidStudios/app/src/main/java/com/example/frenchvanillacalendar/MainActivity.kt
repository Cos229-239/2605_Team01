package com.example.frenchvanillacalendar

import android.content.IntentSender
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.frenchvanillacalendar.ui.theme.ui.view.NavigationDrawer
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
//        timer = object: CountDownTimeer(millisUntilEvent, 1000L)
//        {
//            override fun onTick(millisUntilFinished: Long)
//            {
//                val days = millisUntilFinished / (1000 * 60 * 60 *24)
//                val hours = (millisUntilFinished / (1000 * 60 * 60)) % 24
//                val minutes = (millisUntilFinished /(1000 * 60)) % 60
//                val seconds = (millisUntilFinished / 1000) % 60
//                onTick(days, hours, minutes, seconds)
//            }
//        }

    }
}


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FrenchVanillaCalendarTheme {
                NavigationDrawer()
            }
        }
    }
}
