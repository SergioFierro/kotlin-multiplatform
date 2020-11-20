package com.sergiofierro.kotlin_multiplatform.shared.repository

import android.content.Context
import org.koin.core.KoinComponent

actual class LocalStorage(context: Context) : KoinComponent {

    private val sharedPreferences = context.getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE)

    actual var accessTokenURL: String
        get() = sharedPreferences.getString(url, "") ?: ""
        set(value) {
            sharedPreferences.edit().putString(url, value).apply()
        }

    companion object {
        const val url = "URL"
    }
}