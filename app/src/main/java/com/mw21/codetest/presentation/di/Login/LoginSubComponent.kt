package com.mw21.codetest.presentation.di.Login

import com.mw21.codetest.presentation.login.LoginActivity
import dagger.Subcomponent

@LogInScope
@Subcomponent(modules = [
    LogInModule::class
])
interface LoginSubComponent {
    fun inject(loginActivity: LoginActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): LoginSubComponent
    }
}