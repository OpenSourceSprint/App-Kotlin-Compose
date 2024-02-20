package com.opensource.tvmaze.network

import kotlinx.serialization.Serializable

@Serializable
data class MovieData(
    val score:Double,
    val show:Data
)
@Serializable
data class Data(
    val id:Int,
    val name:String,
    val image:ImageClass?,
    val language:String,
    val summary:String,
    val rating:RateClass
)
@Serializable
data class ImageClass(
    val medium:String,
    val original:String
)

@Serializable
data class RateClass(
    val average:Double?
)