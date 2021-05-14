package com.mw21.codetest.data.repositry.addColaborator.datasource

import com.mw21.codetest.data.models.employee.Employee

interface LocalDataSource {
    suspend fun saveEmployeeToDB(employee: Employee): Long
}