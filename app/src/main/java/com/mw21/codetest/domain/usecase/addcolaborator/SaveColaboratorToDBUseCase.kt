package com.mw21.codetest.domain.usecase.addcolaborator

import android.util.Log
import com.mw21.codetest.data.models.employee.Employee
import com.mw21.codetest.domain.repository.AddColaboratorRepository

class SaveColaboratorToDBUseCase(private val addColaboratorRepository: AddColaboratorRepository) {
    suspend fun execute(employee: Employee): Long = addColaboratorRepository.saveColaboratorToDB(employee)
}