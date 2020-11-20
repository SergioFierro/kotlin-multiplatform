package com.sergiofierro.kotlin_multiplatform.shared.repository

import org.koin.core.KoinComponent
import org.koin.core.inject

class AccessTokenRepository() : KoinComponent {

    private val accessTokenAPI: AccessTokenAPI by inject()

    suspend fun fetchAccessToken(url: String, identity: String) = accessTokenAPI.fetchAccessToken(url, identity)
}