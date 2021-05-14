package com.mw21.codetest.domain.repository

import androidx.lifecycle.MutableLiveData

interface LogInRepositoy {
    suspend fun logIn(user: String, pass: String)
    var logInResult: MutableLiveData<Boolean>
}