package com.mw21.codetest.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mw21.codetest.data.models.employee.Employee

@Dao
interface DaoColaborators {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveHeroes(employee: Employee): Long

    @Query("SELECT * FROM Employee")
    suspend fun getEmployees(): List<Employee>

}