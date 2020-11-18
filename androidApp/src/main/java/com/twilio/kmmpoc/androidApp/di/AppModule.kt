package com.twilio.kmmpoc.androidApp.di

import com.twilio.kmmpoc.androidApp.AccessTokenViewModel
import com.twilio.kmmpoc.shared.repository.LocalStorage
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { AccessTokenViewModel(get(), get()) }
}

val localStorageModule = module {
   single { LocalStorage(androidContext()) }
}
