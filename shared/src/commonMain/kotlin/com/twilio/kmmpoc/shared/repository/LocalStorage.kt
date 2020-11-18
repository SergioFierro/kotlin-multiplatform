package com.twilio.kmmpoc.shared.repository

import org.koin.core.KoinComponent

expect class LocalStorage: KoinComponent {
    var accessTokenURL: String
}
