package com.opensource.tvmaze.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object KtorClient {
    val json= Json {
        encodeDefaults=true
        ignoreUnknownKeys=true
        isLenient=true
        explicitNulls=false
    }
    val httpClient= HttpClient(Android){
        install(Auth){}
        install(HttpTimeout){
            socketTimeoutMillis=30000
            requestTimeoutMillis=30000
            connectTimeoutMillis=30000
        }
        install(ContentNegotiation){
            json()
        }


        defaultRequest {
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }
    }
}