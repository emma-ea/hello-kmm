package com.emma_ea.hellokmm

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class Greeting {

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun greeting(): String {

        val rockets: List<RocketLaunch> =
            httpClient.get("https://api.spacexdata.com/v4/launches").body()
        val lastLaunchSuccess = rockets.last { it.launchSuccess == true }

        return "Hello there, ${Platform().platform.reversed()}!" +
                "\nThere are only ${daysUntilNewYear()} left until New Year! \uD83C\uDF85\uD83C\uDFFC " +
                "\nThe last successful launch was ${lastLaunchSuccess.launchDateUTC} \uD83D\uDE80 "
    }
}