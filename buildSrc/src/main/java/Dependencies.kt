
object Versions {
    const val kotlin = "1.4.10"
    const val kotlinCoroutines = "1.3.9-native-mt"
    const val ktor = "1.4.0"
    const val kotlinxSerialization = "1.0.0-RC"
    const val koin = "3.0.0-alpha-4"
    const val kermit = "0.1.8"

    const val compose = "1.0.0-alpha07"
    const val lifeCycle = "2.2.0"
    const val nav_compose = "1.0.0-alpha02"
    const val accompanist = "0.3.3.1"

    const val junit = "4.13"
}

object AndroidSdk {
    const val min = 24
    const val compile = 30
    const val target = compile
}

object Compose {
    const val ui = "androidx.compose.ui:ui:${Versions.compose}"
    const val uiGraphics = "androidx.compose.ui:ui-graphics:${Versions.compose}"
    const val uiTooling = "androidx.ui:ui-tooling:${Versions.compose}"
    const val foundationLayout = "androidx.compose.foundation:foundation-layout:${Versions.compose}"
    const val material = "androidx.compose.material:material:${Versions.compose}"
    const val runtimeLiveData = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
    const val navigation = "androidx.navigation:navigation-compose:${Versions.nav_compose}"
    const val accompanist= "dev.chrisbanes.accompanist:accompanist-coil:${Versions.accompanist}"
}

object LifeCycle {
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycle}"
    const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycle}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifeCycle}"
    const val extensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifeCycle}"
}

object Koin {
    const val core = "org.koin:koin-core:${Versions.koin}"
    const val android = "org.koin:koin-android:${Versions.koin}"
    const val androidViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
}

object Ktor {
    const val clientCore = "io.ktor:ktor-client-core:${Versions.ktor}"
    const val clientJson = "io.ktor:ktor-client-json:${Versions.ktor}"
    const val clientLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
    const val clientSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"

    const val clientAndroid = "io.ktor:ktor-client-android:${Versions.ktor}"
    const val clientIos = "io.ktor:ktor-client-ios:${Versions.ktor}"
    const val clientJs = "io.ktor:ktor-client-js:${Versions.ktor}"
}

object Serialization {
    const val core = "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.kotlinxSerialization}"
}

