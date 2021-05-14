package com.mw21.codetest.domain.usecase.colaborators

import com.mw21.codetest.data.models.employee.Employee
import com.mw21.codetest.domain.repository.ColaboratorsRepository

class GetAllColabFromDBUseCase(private val colaboratorRepository: ColaboratorsRepository) {
    suspend fun execute(): List<Employee> = colaboratorRepository.getAllColabs()
}