package com.mw21.codetest.presentation.colaborator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mw21.codetest.data.models.employee.Employee
import com.mw21.codetest.domain.usecase.colaborators.GetAllColabFromDBUseCase

class ColaboratorViewModel(private val getAllColabFromDBUseCase: GetAllColabFromDBUseCase): ViewModel() {
    fun getAllColabs() = liveData {
        emit(getAllColabFromDBUseCase.execute())
    }
}