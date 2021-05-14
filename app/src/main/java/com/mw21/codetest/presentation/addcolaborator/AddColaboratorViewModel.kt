package com.mw21.codetest.presentation.addcolaborator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mw21.codetest.data.models.employee.Employee
import com.mw21.codetest.domain.usecase.addcolaborator.AddColaboratorToCloudFirestore
import com.mw21.codetest.domain.usecase.addcolaborator.SaveColaboratorToDBUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddColaboratorViewModel(
        private val saveColaboratorToDBUseCase: SaveColaboratorToDBUseCase,
        private val addColaboratorToCloudFirestore: AddColaboratorToCloudFirestore
): ViewModel() {
        var isInserted : MutableLiveData<Boolean> = MutableLiveData()
        var employeeInCloudFirestore = addColaboratorToCloudFirestore.employeeInCloudFirestore
        suspend fun saveColaborator(employee: Employee){
                if (saveColaboratorToDBUseCase.execute(employee) == -1L){
                        isInserted.postValue(false)
                }else{
                        isInserted.postValue(true)
                }

        }

        suspend fun saveColaboratorToCloudFirestore(employee: Employee) = addColaboratorToCloudFirestore.execute(employee)
}