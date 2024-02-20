package com.opensource.tvmaze

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.content.ContextCompat
import com.maze.tv.screens.HomeScreenLayout2
import com.opensource.tvmaze.network.MovieData
import com.opensource.tvmaze.repo.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(Bundle.EMPTY)
        setContent {
            var movies:Array<MovieData>
            var internetConnection:Boolean

            runBlocking {
                withContext(Dispatchers.IO){
                    movies=Repo().fetchData()
                    internetConnection=true

                }
            }

            if(internetConnection){
                HomeScreenLayout2(context = this, arr = movies)
            }
        }
    }

    companion object{
        fun start(context: Context){
            val intent= Intent(context,MainActivity::class.java)
            ContextCompat.startActivity(context, intent, Bundle.EMPTY)
        }
    }
}

