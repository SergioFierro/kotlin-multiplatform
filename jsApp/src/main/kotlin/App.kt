import com.twilio.kmmpoc.shared.Greeting
import com.twilio.kmmpoc.shared.repository.AccessTokenResponse
import com.twilio.kmmpoc.shared.repository.LocalStorage
import react.*
import react.dom.*
import kotlinx.coroutines.*
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLInputElement

fun platform() = Greeting().greeting()

val App = functionalComponent<RProps> { _ ->
    val appDependencies = useContext(AppDependenciesContext)
    val repository = appDependencies.repository

    val (accessToken, setAccessToken) = useState(AccessTokenResponse("", "", ""))

    val (url, setUrl) = useState(String())

    val (identity, setIdentity) = useState(String())

    val (wasClicked, setClicked) = useState(false)

    useEffect(dependencies = listOf()) {
        setUrl(LocalStorage().accessTokenURL)
    }
    useEffectWithCleanup(dependencies = listOf(wasClicked)) {
        val mainScope = MainScope()

        if (wasClicked && url.isNotEmpty()) {
            mainScope.launch {
                setAccessToken(
                    repository.fetchAccessToken(url, identity)
                )
                setClicked(false)
            }
        }
        return@useEffectWithCleanup { mainScope.cancel() }
    }

    h1 {
        +platform()
    }

    div(classes = "withMargin") {
        input {
            attrs {
                value = identity
                onChangeFunction = {
                    val text = (it.target as HTMLInputElement).value
                    setIdentity(text)
                }
            }
        }
    }

    div(classes = "withMargin") {
        input(type = InputType.text) {
            attrs {
                value = url
                onChangeFunction = {
                    val text = (it.target as HTMLInputElement).value
                    setUrl(text)
                    LocalStorage().accessTokenURL = text
                }
            }
        }
    }

    div(classes = "withMargin") {
        button {
            attrs {
                text("Get access token")
                onClickFunction = {
                    setClicked(true)
                }
            }
        }
    }

    ul {
        li {
            +"Token: ${accessToken.token}"
        }
        li {
            +"Identity: ${accessToken.identity}"
        }
        li {
            +"ServiceSid: ${accessToken.serviceSid}"
        }
    }
}
