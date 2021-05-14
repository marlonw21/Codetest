package com.mw21.codetest.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mw21.codetest.domain.usecase.LoginUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LogInViewModel(private val loginUseCase: LoginUseCase): ViewModel() {
        var logInResult = loginUseCase.logInUseCase
        fun logIn(user: String, pass: String){
            CoroutineScope(Dispatchers.IO).launch {
                loginUseCase.execute(user, pass)
            }
        }
}