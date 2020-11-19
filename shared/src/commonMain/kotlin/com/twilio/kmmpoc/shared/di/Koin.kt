package com.twilio.kmmpoc.shared.di

import com.twilio.kmmpoc.shared.repository.AccessTokenAPI
import com.twilio.kmmpoc.shared.repository.AccessTokenRepository
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(sharedModule)
}

// called by iOS, JS etc
fun initKoin() = initKoin{}

val sharedModule = module {
    single { AccessTokenRepository() }
    single { AccessTokenAPI() }
}
