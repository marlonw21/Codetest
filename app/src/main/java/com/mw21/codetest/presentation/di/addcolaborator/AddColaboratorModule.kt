package com.mw21.codetest.presentation.di.addcolaborator

import com.mw21.codetest.domain.usecase.addcolaborator.AddColaboratorToCloudFirestore
import com.mw21.codetest.domain.usecase.addcolaborator.SaveColaboratorToDBUseCase
import com.mw21.codetest.presentation.addcolaborator.AddColaboratorViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AddColaboratorModule {

    @AddColaboratorScope
    @Provides
    fun provideAddColaboratorViewModelFactory(saveColaboratorToDBUseCase: SaveColaboratorToDBUseCase,
                                              addColaboratorToCloudFirestore: AddColaboratorToCloudFirestore

    ): AddColaboratorViewModelFactory = AddColaboratorViewModelFactory(saveColaboratorToDBUseCase,addColaboratorToCloudFirestore)
}