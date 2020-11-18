package com.twilio.kmmpoc.androidApp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.twilio.kmmpoc.shared.repository.AccessTokenRepository
import com.twilio.kmmpoc.shared.repository.LocalStorage
import kotlinx.coroutines.launch

class AccessTokenViewModel(private val accessTokenRepository: AccessTokenRepository, private val localStorage: LocalStorage): ViewModel() {

    var url: String
        get() = localStorage.accessTokenURL
        set(value) {
            localStorage.accessTokenURL = value
        }

    fun getAccessToken(identity: String) {
        viewModelScope.launch {
            val result = accessTokenRepository.fetchAccessToken(url, identity)
            Log.d("sergio", result.token)
        }
    }
}