package com.mw21.codetest.domain.usecase.addcolaborator

import com.mw21.codetest.data.models.employee.Employee
import com.mw21.codetest.domain.repository.AddColaboratorRepository
import okhttp3.internal.addHeaderLenient

class AddColaboratorToCloudFirestore(private val addColaboratorRepository: AddColaboratorRepository) {
    var employeeInCloudFirestore = addColaboratorRepository.employeeisSavedToCloudFirestore
    suspend fun execute(employee: Employee) = addColaboratorRepository.addColaboratorToCloudFirestore(employee)
}