package com.sergiofierro.kotlin_multiplatform.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.ScrollableColumn
import com.sergiofierro.kotlin_multiplatform.shared.Greeting
import androidx.compose.material.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawShadow
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.sergiofierro.kotlin_multiplatform.shared.repository.AccessTokenRepository
import com.sergiofierro.kotlin_multiplatform.shared.repository.AccessTokenResponse
import com.sergiofierro.kotlin_multiplatform.shared.repository.LocalStorage
import org.koin.androidx.viewmodel.ext.android.viewModel

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {

    private val accessTokenViewModel: AccessTokenViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainLayout(accessTokenViewModel)
        }
    }
}

@Composable
fun MainLayout(accessTokenViewModel: AccessTokenViewModel) {
   Box(modifier = Modifier.fillMaxSize().then(Modifier.padding(all = 8.dp)), alignment = Alignment.TopCenter) {
       ScrollableColumn(horizontalAlignment = Alignment.CenterHorizontally) {

           val paddingModifier = Modifier.padding(vertical = 4.dp)
           Text (
               text = greet(),
               fontSize = TextUnit.Companion.Sp(24),
               fontWeight = Bold,
               modifier = Modifier.padding(all = 16.dp)
           )
           val accessTokenURL: String by accessTokenViewModel.url.observeAsState(String())
           OutlinedTextField(
               value = accessTokenURL,
               onValueChange = { accessTokenViewModel.setURL(it) },
               label = { Text("Access token URL") },
               keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri),
               maxLines = 2,
               modifier = paddingModifier.then(Modifier.fillMaxWidth())
           )

           val identityState = remember { mutableStateOf(TextFieldValue()) }
           OutlinedTextField(
               value = identityState.value,
               onValueChange = { identityState.value = it },
               label = { Text("Identity") },
               maxLines = 2,
               modifier = paddingModifier.then(Modifier.fillMaxWidth())
           )

           val maxWidth = Modifier.fillMaxWidth(0.3f)
           val accessTokenResponse: AccessTokenResponse by accessTokenViewModel.accessToken.observeAsState(
               AccessTokenResponse("", "", "")
           )
           Row(modifier = Modifier.fillMaxSize()) {
               Text(
                   text = "Token: ",
                   modifier = paddingModifier.then(maxWidth)
               )
               Text(
                   text = accessTokenResponse.token,
                   overflow = TextOverflow.Ellipsis,
                   maxLines = 6,
                   modifier = paddingModifier
               )
           }

           Row(modifier = Modifier.fillMaxSize()) {
               Text(
                   text = "Identity: ",
                   modifier = paddingModifier.then(maxWidth)
               )
               Text(
                   text = accessTokenResponse.identity,
                   overflow = TextOverflow.Ellipsis,
                   maxLines = 3,
                   modifier = paddingModifier
               )
           }

           Row(modifier = Modifier.fillMaxSize()) {
               Text(
                   text = "ServiceSid: ",
                   modifier = paddingModifier.then(maxWidth)
               )
               Text(
                   text = accessTokenResponse.serviceSid,
                   overflow = TextOverflow.Ellipsis,
                   maxLines = 3,
                   modifier = paddingModifier
               )
           }

           Button(
               onClick = {
                   accessTokenViewModel.getAccessToken(identityState.value.text)
               },
               modifier = paddingModifier.then(Modifier.drawShadow(elevation = 3.dp))
           ) {
               Text("Generate access token")
           }
       }
   }
}

@Preview
@Composable
fun MainLayoutPreview() {
    MaterialTheme {
        MainLayout(AccessTokenViewModel(AccessTokenRepository(), LocalStorage(ContextAmbient.current)))
    }
}