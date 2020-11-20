import com.sergiofierro.kotlin_multiplatform.shared.di.initKoin
import com.sergiofierro.kotlin_multiplatform.shared.repository.AccessTokenRepository
import react.child
import react.createContext
import react.dom.render

object AppDependencies {
    val repository = AccessTokenRepository()
}

val AppDependenciesContext = createContext<AppDependencies>()
fun main() {
    initKoin()
    render(kotlinx.browser.document.getElementById("root")) {
        AppDependenciesContext.Provider(AppDependencies) {
            child(App)
        }
    }
}