package com.mw21.codetest.presentation.di.addcolaborator

import com.mw21.codetest.presentation.addcolaborator.AddColaboratorActivity
import dagger.Subcomponent

@AddColaboratorScope
@Subcomponent(modules = [
    AddColaboratorModule::class
])
interface AddColaboratorSubComponent {
    fun inject(addColaboratorActivity: AddColaboratorActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): AddColaboratorSubComponent
    }
}