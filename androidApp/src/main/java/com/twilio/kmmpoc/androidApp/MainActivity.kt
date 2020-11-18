package com.twilio.kmmpoc.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.twilio.kmmpoc.shared.Greeting
import android.widget.TextView
import org.koin.androidx.viewmodel.ext.android.viewModel

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {

    private val accessTokenViewModel: AccessTokenViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()

        val accessTokenURL: EditText = findViewById(R.id.accessTokenURL)
        accessTokenURL.setText(accessTokenViewModel.url)
        val getToken: Button = findViewById(R.id.getToken)
        getToken.setOnClickListener {
            accessTokenViewModel.url = accessTokenURL.text.toString()
            accessTokenViewModel.getAccessToken("identity")
        }
    }
}
