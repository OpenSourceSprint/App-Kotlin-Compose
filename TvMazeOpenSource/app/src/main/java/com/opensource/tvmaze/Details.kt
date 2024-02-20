package com.opensource.tvmaze

import android.app.Activity
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.maze.tv.network.ParseData
import com.maze.tv.screens.DetailsScreenLayoutWithTopBar

class Details : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val movieData2=intent.getParcelableExtra<ParseData>("parcel")
        val movieScore=movieData2?.movieScore
        val movieName=movieData2?.name
        val movieSummary=movieData2?.summary
        val movieRating=movieData2?.average
        val movieLanguage=movieData2?.language
        val movieImage=movieData2?.medium

        setContent {
            Column(Modifier.fillMaxSize().background(Color.White)) {
                DetailsScreenLayoutWithTopBar(
                    movieScore = movieScore,
                    name = movieName,
                    summary = movieSummary,
                    average = movieRating,
                    language = movieLanguage,
                    medium = movieImage
                )
            }
        }
    }

    companion object {
        fun kill(context: Context){
            val activity = (context as Activity)
            activity.finish()
        }
    }
}