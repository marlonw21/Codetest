package com.mw21.codetest.presentation.colaborator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mw21.codetest.R
import com.mw21.codetest.data.models.employee.Employee
import com.mw21.codetest.presentation.di.Injector
import com.mw21.codetest.presentation.maps.MapActivity
import kotlinx.android.synthetic.main.activity_colaborators.*
import javax.inject.Inject

class ColaboratorsActivity : AppCompatActivity(), OnItemClickListener {
    @Inject
    lateinit var factory: ColaboratorViewModelFactory
    private lateinit var colabsViewModel: ColaboratorViewModel
    var listUsers: ArrayList<Employee> = java.util.ArrayList()
    private lateinit var adapter: ColaboratorAdapter
            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colaborators)
                (application as Injector).createColaboratorsSubComponent()
                    .inject(this)

                colabsViewModel = ViewModelProvider(this, factory)
                    .get(ColaboratorViewModel::class.java)
            initRecycler()


         }

    private fun initRecycler() {
        ColaboradoRecycler.layoutManager = LinearLayoutManager(this)
        adapter = ColaboratorAdapter(this)
        ColaboradoRecycler.adapter = adapter
        getColabs()
    }

    override fun onItemClick(employee: Employee) {
        val intent = Intent(this, MapActivity::class.java)
            intent.putExtra("user", employee)
            intent.putParcelableArrayListExtra("listUsers", listUsers)
            startActivity(intent)
    }

    private fun getColabs(){
        colabsViewModel.getAllColabs().observe(this, Observer {
            if (it != null){
                adapter.setList(it)
                listUsers = ArrayList(it)
                adapter.notifyDataSetChanged()
            }else{
                Toast.makeText(this, "Error: No data", Toast.LENGTH_SHORT).show()
            }
        })
    }
}