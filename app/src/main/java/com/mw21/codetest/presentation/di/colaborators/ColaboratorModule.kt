package com.mw21.codetest.presentation.di.colaborators

import com.mw21.codetest.domain.usecase.colaborators.GetAllColabFromDBUseCase
import com.mw21.codetest.presentation.colaborator.ColaboratorViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ColaboratorModule {
    @ColaboratorScope
    @Provides
    fun provideColabViewModelFactory(getAllColabFromDBUseCase: GetAllColabFromDBUseCase): ColaboratorViewModelFactory = ColaboratorViewModelFactory(getAllColabFromDBUseCase)
}