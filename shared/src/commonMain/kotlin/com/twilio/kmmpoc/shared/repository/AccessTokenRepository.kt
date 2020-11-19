package com.twilio.kmmpoc.shared.repository

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.koin.core.KoinComponent
import org.koin.core.inject

class AccessTokenRepository() : KoinComponent {

    private val coroutineScope: CoroutineScope = MainScope()
    private val accessTokenAPI: AccessTokenAPI by inject()

    suspend fun fetchAccessToken(url: String, identity: String) = accessTokenAPI.fetchAccessToken(url, identity)

    private fun asd(url: String, identity: String) = flow {
            println("Sergio6")
            println("Sergio $url")
            val response = accessTokenAPI.fetchAccessToken(url, identity)
            println("Sergio7")
            emit(response)
        }.flowOn(Dispatchers.Default)

    fun fetchAccessToken2(url: String, identity: String, success: (AccessTokenResponse) -> Unit) {
        println("Sergio")
        println("Sergio $url")
        println("Sergio $identity")
        val url2 = "https://verify-push-sample-backend.herokuapp.com/accessTokens"
        println("Sergio $url2")
        coroutineScope.launch {
            println("Sergio1")
//            val response = asd(url, identity)?.collect{
//                success(it)
//            }
            asd(url2, identity).collect {
                println("Sergio2")
                success(it)
            }
            println("Sergio3")
//            println(response.token)
//            println(response.identity)
//            success(response)
        }
        println("Sergio4")
        asd(url2, identity)
        println("Sergio5")
    }

    fun stopObservingPeopleUpdates() {
        coroutineScope.cancel()
    }
}