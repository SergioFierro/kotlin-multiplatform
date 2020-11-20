package com.sergiofierro.kotlin_multiplatform.androidApp.di

import com.sergiofierro.kotlin_multiplatform.androidApp.AccessTokenViewModel
import com.sergiofierro.kotlin_multiplatform.shared.repository.LocalStorage
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { AccessTokenViewModel(get(), get()) }
}

val localStorageModule = module {
   single { LocalStorage(androidContext()) }
}
