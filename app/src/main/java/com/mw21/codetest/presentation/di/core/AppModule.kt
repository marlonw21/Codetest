package com.mw21.codetest.presentation.di.core

import android.content.Context
import com.mw21.codetest.presentation.di.Login.LoginSubComponent
import com.mw21.codetest.presentation.di.addcolaborator.AddColaboratorSubComponent
import com.mw21.codetest.presentation.di.colaborators.ColaboratorSubComponent
import com.mw21.codetest.presentation.di.home.HomeSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
@Module(subcomponents = [
    LoginSubComponent::class,
    HomeSubComponent::class,
    AddColaboratorSubComponent::class,
    ColaboratorSubComponent::class
])
class AppModule (private val context: Context) {
    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}