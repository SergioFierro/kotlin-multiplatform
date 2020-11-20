package com.sergiofierro.kotlin_multiplatform.shared


class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}
