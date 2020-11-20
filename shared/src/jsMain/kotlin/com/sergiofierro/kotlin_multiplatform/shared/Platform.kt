package com.sergiofierro.kotlin_multiplatform.shared

import kotlinx.browser.window

actual class Platform actual constructor() {
    actual val platform: String = "JS ${window.navigator.userAgent}"
}