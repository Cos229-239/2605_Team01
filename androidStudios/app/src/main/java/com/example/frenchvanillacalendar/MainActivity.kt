package com.example.frenchvanillacalendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.frenchvanillacalendar.ui.theme.FrenchVanillaCalendarTheme
import com.example.frenchvanillacalendar.ui.theme.ui.view.NavigationDrawer
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
