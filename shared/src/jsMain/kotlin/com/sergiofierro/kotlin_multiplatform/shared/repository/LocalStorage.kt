package com.sergiofierro.kotlin_multiplatform.shared.repository

import org.koin.core.KoinComponent
import kotlinx.browser.localStorage

actual class LocalStorage : KoinComponent {

    actual var accessTokenURL: String
        get() = localStorage.getItem(url) ?: ""
        set(value) {
            localStorage.setItem(url, value)
        }

    companion object {
        const val url = "URL"
    }
}
