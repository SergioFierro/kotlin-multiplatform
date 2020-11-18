package com.twilio.kmmpoc.androidApp

import android.app.Application
import com.twilio.kmmpoc.androidApp.di.appModule
import com.twilio.kmmpoc.shared.di.initKoin
import com.twilio.kmmpoc.shared.di.sharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinComponent

class Application : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger()
            androidContext(this@Application)
            modules(appModule, sharedModule)
        }
    }
}