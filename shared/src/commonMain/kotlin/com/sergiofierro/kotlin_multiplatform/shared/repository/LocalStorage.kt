package com.sergiofierro.kotlin_multiplatform.shared.repository

import org.koin.core.KoinComponent

expect class LocalStorage: KoinComponent {
    var accessTokenURL: String
}
