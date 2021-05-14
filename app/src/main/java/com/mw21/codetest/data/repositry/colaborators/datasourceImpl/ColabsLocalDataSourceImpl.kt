package com.mw21.codetest.data.repositry.colaborators.datasourceImpl

import com.mw21.codetest.data.db.DaoColaborators
import com.mw21.codetest.data.models.employee.Employee
import com.mw21.codetest.data.repositry.colaborators.datasource.ColabsLocalDataSource

class ColabsLocalDataSourceImpl(private val daoColaborators: DaoColaborators): ColabsLocalDataSource {
    override suspend fun getAllColabs(): List<Employee> = daoColaborators.getEmployees()
}