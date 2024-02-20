@file:OptIn(ExperimentalGlideComposeApi::class, ExperimentalGlideComposeApi::class)

package com.maze.tv.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage


@Composable
fun DetailsScreenLayout(
    movieScore: Double?,
    name: String?,
    summary: String?,
    average: Double?,
    language: String?,
    medium: String?
){
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White), horizontalAlignment = Alignment.CenterHorizontally)
    {
        //name
        Text("$name", fontSize = 35.sp)
        //image
        Row(Modifier.fillMaxWidth()) {
            if(medium != null){GlideImage(model = medium, contentDescription = "Movie Image")}
            else{Text(text = "No Image available", fontSize = 16.sp)}
        }
        //score
        Row (Modifier.fillMaxWidth()) {
            if (movieScore != null){Text(text = "Movie Imdb score is: $movieScore", fontSize = 20.sp)}
            else{Text(text = "No Imdb score available", fontSize = 16.sp)}
        }
        //rating
        Row(Modifier.fillMaxWidth())  {
            if (average != 0.0){Text(text = "Movie average rating is: $average", fontSize = 20.sp)}
            else{Text(text = "No rating available", fontSize = 16.sp)}
        }
        //language
        Row(Modifier.fillMaxWidth())  {
            if (language != null){Text(text = "Movie's original language is: $language", fontSize = 20.sp)}
            else{Text(text = "No original language available", fontSize = 16.sp)}
        }
        //summary
        Row(Modifier.fillMaxWidth())  {
            if (summary != null){
                Column {
                    Text(text = "Movie summary is:", fontSize = 20.sp)
                    Text(text = "$summary", fontSize = 16.sp)
                }
            }
            else{Text(text = "No Imdb score available", fontSize = 16.sp)}
        }


    }
}


@Composable
fun DetailsScreenLayoutWithTopBar(
    movieScore: Double?,
    name: String?,
    summary: String?,
    average: Double?,
    language: String?,
    medium: String?
){
    TopAppBar()
    DetailsScreenLayout(
        movieScore = movieScore,
        name = name,
        summary = summary,
        average = average,
        language = language,
        medium = medium
    )

}