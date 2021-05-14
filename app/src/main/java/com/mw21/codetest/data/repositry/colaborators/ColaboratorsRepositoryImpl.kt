package com.mw21.codetest.data.repositry.colaborators

import com.mw21.codetest.data.db.DaoColaborators
import com.mw21.codetest.data.models.employee.Employee
import com.mw21.codetest.domain.repository.ColaboratorsRepository

class ColaboratorsRepositoryImpl(private val daoColaborators: DaoColaborators): ColaboratorsRepository {
    override suspend fun getAllColabs(): List<Employee> = daoColaborators.getEmployees()
}