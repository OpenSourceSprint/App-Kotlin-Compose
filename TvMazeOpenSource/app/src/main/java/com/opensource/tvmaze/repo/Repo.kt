package com.opensource.tvmaze.repo

import com.opensource.tvmaze.network.KtorClient
import com.opensource.tvmaze.network.KtorClient.json
import com.opensource.tvmaze.network.MovieData
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class Repo {
    suspend fun fetchData():Array<MovieData>{
        val request= KtorClient.httpClient.get(urlString = "https://api.tvmaze.com/search/shows?q=all").bodyAsText()
        val reqArray=json.decodeFromString<Array<MovieData>>(request)
        KtorClient.httpClient.close()
        return reqArray
    }
}