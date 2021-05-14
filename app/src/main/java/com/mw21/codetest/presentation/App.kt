package com.mw21.codetest.presentation

import android.app.Application
import android.content.Context
import com.mw21.codetest.presentation.di.Injector
import com.mw21.codetest.presentation.di.Login.LoginSubComponent
import com.mw21.codetest.presentation.di.addcolaborator.AddColaboratorSubComponent
import com.mw21.codetest.presentation.di.colaborators.ColaboratorSubComponent
import com.mw21.codetest.presentation.di.core.*
import com.mw21.codetest.presentation.di.home.HomeSubComponent

class App: Application(), Injector{
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule("https://dl.dropboxusercontent.com"))
            .remoteDataModule(RemoteDataModule())
            .build()

    }

    override fun createLogInSubComponent(): LoginSubComponent =appComponent.logInSubComponent().create()
    override fun createHomeSubComponent(): HomeSubComponent = appComponent.homeSubComponent().create()
    override fun createAddColaboratorSubComponent(): AddColaboratorSubComponent = appComponent.addColaboratorSubComponent().create()
    override fun createColaboratorsSubComponent(): ColaboratorSubComponent = appComponent.colaboratorSubComponent().create()


}