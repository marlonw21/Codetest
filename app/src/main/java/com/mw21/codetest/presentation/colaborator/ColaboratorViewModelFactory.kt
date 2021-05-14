package com.mw21.codetest.presentation.colaborator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mw21.codetest.domain.usecase.colaborators.GetAllColabFromDBUseCase

class ColaboratorViewModelFactory(private val getAllColabFromDBUseCase: GetAllColabFromDBUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = ColaboratorViewModel(getAllColabFromDBUseCase) as T
}