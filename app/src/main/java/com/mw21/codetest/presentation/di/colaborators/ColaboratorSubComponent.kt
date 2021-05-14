package com.mw21.codetest.presentation.di.colaborators

import com.mw21.codetest.presentation.colaborator.ColaboratorsActivity
import dagger.Subcomponent

@ColaboratorScope
@Subcomponent(modules = [
    ColaboratorModule::class
])
interface ColaboratorSubComponent {
    fun inject(colaboratorsActivity: ColaboratorsActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): ColaboratorSubComponent
    }
}