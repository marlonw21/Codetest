package com.mw21.codetest.presentation.di.core

import com.mw21.codetest.presentation.di.Login.LoginSubComponent
import com.mw21.codetest.presentation.di.addcolaborator.AddColaboratorSubComponent
import com.mw21.codetest.presentation.di.colaborators.ColaboratorScope
import com.mw21.codetest.presentation.di.colaborators.ColaboratorSubComponent
import com.mw21.codetest.presentation.di.home.HomeSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules =[
    AppModule::class,
    DataBaseModule::class,
    LocalDataModule::class,
    NetModule::class,
    RemoteDataModule::class,
    RepositoryModule::class,
    UseCaseModule::class
]
)
interface AppComponent {
    fun logInSubComponent(): LoginSubComponent.Factory
    fun homeSubComponent(): HomeSubComponent.Factory
    fun addColaboratorSubComponent(): AddColaboratorSubComponent.Factory
    fun colaboratorSubComponent(): ColaboratorSubComponent.Factory
}