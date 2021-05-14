package com.mw21.codetest.data.repositry.addColaborator

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.mw21.codetest.data.db.DaoColaborators
import com.mw21.codetest.data.models.employee.Employee
import com.mw21.codetest.domain.repository.AddColaboratorRepository

class AddColaboratorRepositoryImpl(private val daoColaborators: DaoColaborators): AddColaboratorRepository {
    val db = Firebase.firestore
    override suspend fun saveColaboratorToDB(employee: Employee): Long = daoColaborators.saveHeroes(employee)

    override suspend fun addColaboratorToCloudFirestore(employee: Employee) {
        db.collection("employees")
            .add(employee)
            .addOnSuccessListener {
                    documentReference ->
                Log.d("TAG", "DocumentSnapshot added with ID: ${documentReference.id}")
                employeeisSavedToCloudFirestore.postValue(true)
            }.addOnFailureListener {
                    e ->
                Log.w("TAG", "Error adding document", e)
                employeeisSavedToCloudFirestore.postValue(false)
            }
    }

    override var employeeisSavedToCloudFirestore: MutableLiveData<Boolean> = MutableLiveData()
}