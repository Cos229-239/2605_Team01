package com.example.frenchvanillacalendar

import android.content.IntentSender
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.frenchvanillacalendar.ui.theme.FrenchVanillaCalendarTheme
import android.os.CountDownTimer //import the countdown timer
import com.example.frenchvanillacalendar.ui.theme.ui.view.NavigationDrawer


interface TimerListener //created interface of timer listener
{
    fun onTick(days: Long, hours: Long, minutes: Long, seconds: Long, millis: Long) //added to millis
    fun onFinish()
}
//EventCountdownTimer class created
class EventCountdownTimer
    (private val eventTimeMillis: Long,
     private val listener: TimerListener)
    //private val onTick: (days: Long, hours: Long, minutes: Long, seconds: Long, millis: Long) -> Unit,
    //private val onFinish:() -> Unit)

{
    private var timer: CountDownTimer? = null
    fun start()
    {
        val millisUntilEvent = eventTimeMillis - System.currentTimeMillis()

        if (millisUntilEvent <= 0)
            {
                listener.onFinish()
                return
            }
        timer = object: CountDownTimer(millisUntilEvent, 1000L)
        {
            override fun onTick(millisUntilFinished: Long) //the setup of the timer
            {
                val days = millisUntilFinished / (1000 * 60 * 60 *24)
                val hours = (millisUntilFinished / (1000 * 60 * 60)) % 24
                val minutes = (millisUntilFinished /(1000 * 60)) % 60
                val seconds = (millisUntilFinished / 1000) % 60
                val millis = (millisUntilFinished % 1000)
                //this@EventCountdownTimer
                listener.onTick(days, hours, minutes, seconds, millis)
                //onTick(days, hours, minutes, seconds, millis)
            }
            override fun onFinish()
            {
                listener.onFinish()
            //this@EventCountdownTimer.onFinish()
            }
        }
            .start()
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