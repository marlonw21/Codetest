package com.mw21.codetest.presentation.di.Login

import com.mw21.codetest.domain.usecase.LoginUseCase
import com.mw21.codetest.presentation.login.LogInViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class LogInModule {
    @LogInScope
    @Provides
    fun provideLogInViewModelFactorty(loginUseCase: LoginUseCase): LogInViewModelFactory =  LogInViewModelFactory(loginUseCase)
}