package com.example.frenchvanillacalendar.ui.theme.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment


@Composable
fun SettingsScreen () {
    Box(
        modifier = Modifier.background(Color(0xFF6200EE)),
        contentAlignment = Alignment.Center,

        ){
        Text(text = "Settings")
    }
}