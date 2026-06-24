package com.example.frenchvanillacalendar.data.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image

data class drawerItems(
    val title: String,
    val icon: Int,
) {
    @Composable
    fun DisplayIcon(){
        Image(
            painter = painterResource(id = icon),
            contentDescription = title
        )
    }
}
