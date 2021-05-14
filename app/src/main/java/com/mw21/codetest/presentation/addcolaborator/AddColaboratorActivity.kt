package com.mw21.codetest.presentation.addcolaborator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.mw21.codetest.R
import com.mw21.codetest.data.models.employee.Employee
import com.mw21.codetest.data.models.employee.Location
import com.mw21.codetest.presentation.di.Injector
import kotlinx.android.synthetic.main.activity_add_colaborator.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import java.util.concurrent.ThreadLocalRandom
import javax.inject.Inject

class AddColaboratorActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: AddColaboratorViewModelFactory
    private lateinit var addColaboratorViewModel: AddColaboratorViewModel
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_colaborator)
        (application as Injector).createAddColaboratorSubComponent()
            .inject(this)

        addColaboratorViewModel = ViewModelProvider(this, factory)
            .get(AddColaboratorViewModel::class.java)

        addBtn.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            checkFields(name, email)
        }


    }

    private fun checkFields(name: String, email: String) {
        if (!name.isNullOrEmpty() && !email.isNullOrEmpty()){
            addColaboratorToDB(name, email)
        }
    }

    private fun saveColaboratorToCloudFirestore(employee: Employee) {
        CoroutineScope(Dispatchers.IO).launch {
            addColaboratorViewModel.saveColaboratorToCloudFirestore(employee)
        }
        addColaboratorViewModel.employeeInCloudFirestore.observe(this, androidx.lifecycle.Observer {
            if (it){
                Toast.makeText(this, "Usuario guardado", Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(this, "Error firebase: Error adding document", Toast.LENGTH_SHORT).show()
                finish()
            }
        })
//        db.collection("employees")
//            .add(employee)
//            .addOnSuccessListener {
//                    documentReference ->
//                Log.d("TAG", "DocumentSnapshot added with ID: ${documentReference.id}")
//                Toast.makeText(this, "Usuario guardado", Toast.LENGTH_SHORT).show()
//                finish()
//            }.addOnFailureListener {
//                    e ->
//                Log.w("TAG", "Error adding document", e)
//                Toast.makeText(this, "Error firebase: Error adding document $e", Toast.LENGTH_SHORT).show()
//                finish()
//            }
    }

    private fun addColaboratorToDB(name: String, email: String) {
        var lat = ThreadLocalRandom.current().nextDouble(51.3257, 52.4557)
        var long = ThreadLocalRandom.current().nextDouble(51.3257, 99.4557)
        val employee = Employee(0, Location(lat, long*-1),email, name)
        CoroutineScope(Dispatchers.IO).launch {
            addColaboratorViewModel.saveColaborator(employee)
        }
        addColaboratorViewModel.isInserted.observe(this, androidx.lifecycle.Observer {
            if (it) {
                saveColaboratorToCloudFirestore(employee)
            } else {
                Toast.makeText(this, "Error al guardar el usuario", Toast.LENGTH_SHORT).show()
            }
        })
    }
}