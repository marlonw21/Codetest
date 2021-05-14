package com.mw21.codetest.presentation.di.core

import com.mw21.codetest.data.db.DaoColaborators
import com.mw21.codetest.data.repositry.addColaborator.datasource.LocalDataSource
import com.mw21.codetest.data.repositry.addColaborator.datasourceImpl.LocalDataSourceImpl
import com.mw21.codetest.data.repositry.colaborators.datasource.ColabsLocalDataSource
import com.mw21.codetest.data.repositry.colaborators.datasourceImpl.ColabsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideAddColaboratorLocalDataSource(daoColaborators: DaoColaborators): LocalDataSource {
        return LocalDataSourceImpl(daoColaborators)
    }

    @Singleton
    @Provides
    fun provideColabsLocalDataSource(daoColaborators: DaoColaborators): ColabsLocalDataSource = ColabsLocalDataSourceImpl(daoColaborators)
}