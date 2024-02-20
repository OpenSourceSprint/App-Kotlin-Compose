package com.maze.tv.network

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
class ParseData(
    val movieScore: Double?,
    val name: String?,
    val summary: String?,
    val average: Double?,
    val language: String?,
    val medium: String?
):Parcelable