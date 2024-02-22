package com.opensource.tvmaze.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.opensource.tvmaze.MainActivity

@Composable
fun NoInternet(context: Context){
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        Text(text = "No internet connection!", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Toast.makeText(LocalContext.current,"Network Issues!", Toast.LENGTH_SHORT).show()
        Button(onClick = {
            MainActivity.start(context)
        }) {
            Text(text = "Retry")
        }
    }
}