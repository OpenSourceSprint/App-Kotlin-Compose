package com.maze.tv.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun TopAppBar(){
    val context=LocalContext.current
    Row{
        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Default.Home, contentDescription = "Home Button")
        }
    }
}