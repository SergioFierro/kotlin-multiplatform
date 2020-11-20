package com.sergiofierro.kotlin_multiplatform.androidApp

import android.app.Application
import com.sergiofierro.kotlin_multiplatform.androidApp.di.appModule
import com.sergiofierro.kotlin_multiplatform.androidApp.di.localStorageModule
import com.sergiofierro.kotlin_multiplatform.shared.di.initKoin
import com.sergiofierro.kotlin_multiplatform.shared.di.sharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinComponent

class Application : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger()
            androidContext(this@Application)
            modules(localStorageModule, appModule, sharedModule)
        }
    }
}