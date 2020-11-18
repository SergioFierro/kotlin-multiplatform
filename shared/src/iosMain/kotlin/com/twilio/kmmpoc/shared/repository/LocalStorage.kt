package com.twilio.kmmpoc.shared.repository

import org.koin.core.KoinComponent
import platform.Foundation.NSUserDefaults

actual class LocalStorage : KoinComponent {
    actual var accessTokenURL: String
        get() = NSUserDefaults.standardUserDefaults.stringForKey(url) ?: ""
        set(value) {
            NSUserDefaults.standardUserDefaults.setObject(value, url)
        }

    companion object {
        const val url = "URL"
    }
}