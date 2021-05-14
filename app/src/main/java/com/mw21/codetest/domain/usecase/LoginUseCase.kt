package com.mw21.codetest.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.mw21.codetest.domain.repository.LogInRepositoy

class LoginUseCase(private val logInRepositoy: LogInRepositoy) {
    var logInUseCase = logInRepositoy.logInResult
    suspend fun execute(user: String, pass: String)= logInRepositoy.logIn(user, pass)
}