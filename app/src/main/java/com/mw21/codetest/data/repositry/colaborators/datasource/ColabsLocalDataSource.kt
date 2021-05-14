package com.mw21.codetest.data.repositry.colaborators.datasource


import com.mw21.codetest.data.models.employee.Employee

interface ColabsLocalDataSource {
    suspend fun getAllColabs(): List<Employee>

}