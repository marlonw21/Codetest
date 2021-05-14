package com.mw21.codetest.data.repositry.addColaborator.datasourceImpl

import com.mw21.codetest.data.db.DaoColaborators
import com.mw21.codetest.data.models.employee.Employee
import com.mw21.codetest.data.repositry.addColaborator.datasource.LocalDataSource

class LocalDataSourceImpl(private val daoColaborators: DaoColaborators): LocalDataSource {
    override suspend fun saveEmployeeToDB(employee: Employee): Long = daoColaborators.saveHeroes(employee)
}