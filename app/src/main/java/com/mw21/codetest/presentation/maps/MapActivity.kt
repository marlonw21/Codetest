package com.mw21.codetest.presentation.maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.mw21.codetest.R
import com.mw21.codetest.data.models.employee.Employee
import java.util.ArrayList

class MapActivity : AppCompatActivity(), OnMapReadyCallback {
    lateinit var currentEmployee: Employee
    private lateinit var map: GoogleMap
    var employeesList: ArrayList<Employee> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
            val employee: Employee? = intent.getParcelableExtra("user")
            val employees = intent.getParcelableArrayListExtra<Employee>("listUsers")
        Log.d("USERS", employees.toString())
        currentEmployee = employee!!
        employeesList = employees!!

        createFragment()
    }

    private fun createFragment() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap?) {
        map = p0!!
        map.setOnMarkerClickListener{marker ->
            if (marker.isInfoWindowShown) {
                marker.hideInfoWindow()
            } else {
                marker.showInfoWindow()
            }
            true

        }
        createMarker(currentEmployee)
        drawMarkersList(employeesList)

    }

    private fun createMarker(employee: Employee){
            val coordinates = LatLng(employee.location.lat, employee.location.log)
            val marker = MarkerOptions().position(coordinates).title(employee.name)
            map.addMarker(marker)
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 18f),4000,null)
    }

    private fun drawMarkersList(employees: ArrayList<Employee>?){
        if (employees != null){
            for (i in 0..employees?.size?.minus(1)!!){
                val coordinates = LatLng(employees?.get(i).location.lat,employees?.get(i).location.log)
                val marker = MarkerOptions().position(coordinates).title(employees[i].name)
                map.addMarker(marker)
            }
        }

    }

}