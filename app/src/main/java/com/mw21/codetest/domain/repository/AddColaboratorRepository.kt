package com.mw21.codetest.domain.repository

import androidx.lifecycle.MutableLiveData
import com.mw21.codetest.data.models.employee.Employee

interface AddColaboratorRepository {
    suspend fun saveColaboratorToDB(employee: Employee):Long
    suspend fun addColaboratorToCloudFirestore(employee: Employee)

    abstract var employeeisSavedToCloudFirestore: MutableLiveData<Boolean>
}