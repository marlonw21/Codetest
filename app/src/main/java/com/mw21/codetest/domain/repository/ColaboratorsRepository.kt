package com.mw21.codetest.domain.repository

import com.mw21.codetest.data.models.employee.Employee

interface ColaboratorsRepository {
    suspend fun getAllColabs(): List<Employee>
}