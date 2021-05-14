package com.mw21.codetest.presentation.di

import com.mw21.codetest.presentation.di.Login.LoginSubComponent
import com.mw21.codetest.presentation.di.addcolaborator.AddColaboratorSubComponent
import com.mw21.codetest.presentation.di.colaborators.ColaboratorSubComponent
import com.mw21.codetest.presentation.di.home.HomeSubComponent

interface Injector {
    fun createLogInSubComponent(): LoginSubComponent
    fun createHomeSubComponent() : HomeSubComponent
    fun createAddColaboratorSubComponent(): AddColaboratorSubComponent
    fun createColaboratorsSubComponent(): ColaboratorSubComponent
}