package com.twilio.kmmpoc.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }
}
