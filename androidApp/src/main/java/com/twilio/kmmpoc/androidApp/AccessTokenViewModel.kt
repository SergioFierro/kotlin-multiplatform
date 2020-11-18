package com.twilio.kmmpoc.androidApp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.twilio.kmmpoc.shared.repository.AccessTokenRepository
import com.twilio.kmmpoc.shared.repository.LocalStorage
import kotlinx.coroutines.launch

class AccessTokenViewModel(private val accessTokenRepository: AccessTokenRepository, private val localStorage: LocalStorage): ViewModel() {

    fun saveAccessTokenURL(url: String) {
        localStorage.accessTokenURL = url
    }

    fun getAccessTokenURL() = localStorage.accessTokenURL

    fun getAccessToken(identity: String) {
        viewModelScope.launch {
            val result = getAccessTokenURL()?.let { accessTokenRepository.fetchAccessToken(it, identity) }

            Log.d("sergio", result?.token)
        }
    }
}