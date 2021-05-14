package com.mw21.codetest.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mw21.codetest.domain.usecase.LoginUseCase

class LogInViewModelFactory(private val loginUseCase: LoginUseCase): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = LogInViewModel(loginUseCase) as T
}