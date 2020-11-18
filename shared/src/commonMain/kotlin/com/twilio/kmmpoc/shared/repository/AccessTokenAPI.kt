package com.twilio.kmmpoc.shared.repository

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class AccessTokenResponse(val token: String, val serviceSid: String, val identity: String)

@Serializable
data class AstroResult(val message: String, val number: Int, val people: List<Assignment>)

@Serializable
data class Assignment(val craft: String, val name: String)

@Serializable
data class AccessTokenRequest(val identity: String)
class AccessTokenAPI {
    private val nonStrictJson = Json { isLenient = true; ignoreUnknownKeys = true }

    private val client by lazy {
        HttpClient {
            install(JsonFeature) {
                serializer = KotlinxSerializer(nonStrictJson)
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
        }
    }

    suspend fun fetchAccessToken(url: String, identity: String) = client.post<AccessTokenResponse>{
        url(url)
        contentType(ContentType.Application.Json)
        body = AccessTokenRequest(identity)
    }
}