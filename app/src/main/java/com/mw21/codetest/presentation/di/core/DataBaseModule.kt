package com.mw21.codetest.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.mw21.codetest.data.db.ColaboratorDataBase
import com.mw21.codetest.data.db.DaoColaborators
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideColaboratorDatabase(context: Context): ColaboratorDataBase{
        return Room.databaseBuilder(context, ColaboratorDataBase::class.java, "employees")
            .build()
    }

    @Singleton
    @Provides
    fun provideColaboratorDao(colaboratorDataBase: ColaboratorDataBase): DaoColaborators{
        return colaboratorDataBase.DaoColaborators()
    }
}