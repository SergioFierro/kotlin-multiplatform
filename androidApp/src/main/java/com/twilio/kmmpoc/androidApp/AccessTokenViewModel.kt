package com.twilio.kmmpoc.androidApp

import androidx.lifecycle.*
import com.twilio.kmmpoc.shared.repository.AccessTokenRepository
import com.twilio.kmmpoc.shared.repository.AccessTokenResponse
import com.twilio.kmmpoc.shared.repository.LocalStorage
import kotlinx.coroutines.Dispatchers

class AccessTokenViewModel(private val accessTokenRepository: AccessTokenRepository, private val localStorage: LocalStorage): ViewModel() {

    private val identity: MutableLiveData<String> = MutableLiveData()
    val accessToken: LiveData<AccessTokenResponse> = identity.switchMap {
        liveData(context = viewModelScope.coroutineContext + Dispatchers.IO) {
            emit(accessTokenRepository.fetchAccessToken(url.value ?: "", it))
        }
    }

    private val _url: MutableLiveData<String> = MutableLiveData()
    val url: LiveData<String> = _url

    init {
        setURL(localStorage.accessTokenURL)
    }

    fun setURL(url: String) {
        localStorage.accessTokenURL = url
        _url.value = url
    }

    fun getAccessToken(identity: String) {
        this.identity.value = identity
    }
}