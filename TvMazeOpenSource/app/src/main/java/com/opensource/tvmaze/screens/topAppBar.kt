package com.maze.tv.screens

import android.content.Intent
import android.os.Bundle
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import com.opensource.tvmaze.MainActivity

@Composable
fun TopAppBar(){
    val context=LocalContext.current
    Row{
        IconButton(onClick = {
            val intent = Intent(context, MainActivity::class.java)
            ContextCompat.startActivity(context, intent, Bundle.EMPTY)
        }) {
            Icon(imageVector = Icons.Default.Home, contentDescription = "Home Button")
        }
    }
}