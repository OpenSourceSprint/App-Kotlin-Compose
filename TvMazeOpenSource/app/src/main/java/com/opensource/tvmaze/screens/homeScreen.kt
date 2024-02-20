@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class
)

package com.maze.tv.screens


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.maze.tv.network.ParseData
import com.opensource.tvmaze.Details
import com.opensource.tvmaze.network.MovieData



@Composable
fun HomeScreenLayout2(context:Context,arr:Array<MovieData>){
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)){
        for(movie in arr){
            ScreenCard(context = context, movie = movie)
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}

@Composable
fun ScreenCard(context: Context, movie: MovieData){
    Card(onClick = {
        val intent=Intent(context, Details::class.java)
        val movieParcel=ParseData(
            movie.score,
            movie.show.name,
            movie.show.summary,//movie.show.summary,
            movie.show.rating.average,
            movie.show.language,
            movie.show?.image?.medium)
        intent.putExtra("parcel",movieParcel)
        startActivity(context,intent, Bundle.EMPTY)
    },
        colors = CardDefaults.cardColors(Color.LightGray), elevation = CardDefaults.cardElevation(17.dp)) {
        Row(Modifier.fillMaxWidth()){
            if(movie.show.image != null){GlideImage(model = movie.show.image?.original,
                contentDescription = "Movie Image",
                Modifier
                    .height(80.dp)
                    .width(80.dp))}
            else{
                Text(text = "No Image available", fontSize = 6.sp)}
            Column (Modifier.height(100.dp)){
                Text(text = movie.show.name, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Text(text = movie.show.summary,//movie.show.summary,
                    fontSize = 12.sp, fontWeight = FontWeight.Light)
            }
        }
        Spacer(modifier = Modifier.width(6.dp))
    }
}


