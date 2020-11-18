package com.twilio.kmmpoc.androidApp.di

import com.twilio.kmmpoc.androidApp.AccessTokenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { AccessTokenViewModel(get()) }
}
