package com.mw21.codetest.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mw21.codetest.data.models.employee.Employee

@Database(entities = [Employee::class],
version = 1,
exportSchema = false)
abstract class ColaboratorDataBase: RoomDatabase() {
    abstract fun DaoColaborators(): DaoColaborators
}