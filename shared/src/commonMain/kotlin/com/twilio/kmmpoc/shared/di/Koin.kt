package com.twilio.kmmpoc.shared.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(sharedModule)
}

// called by iOS etc
fun initKoin() = initKoin{}

val sharedModule = module {
//    single { PeopleInSpaceRepository() }
//    single { PeopleInSpaceApi() }
//    single { Kermit(getLogger()) }
}
