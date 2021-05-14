package com.mw21.codetest.presentation.addcolaborator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mw21.codetest.domain.usecase.addcolaborator.AddColaboratorToCloudFirestore
import com.mw21.codetest.domain.usecase.addcolaborator.SaveColaboratorToDBUseCase

class AddColaboratorViewModelFactory(private val saveColaboratorToDBUseCase: SaveColaboratorToDBUseCase,
                                     private val addColaboratorToCloudFirestore: AddColaboratorToCloudFirestore
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = AddColaboratorViewModel(saveColaboratorToDBUseCase,addColaboratorToCloudFirestore) as T
}