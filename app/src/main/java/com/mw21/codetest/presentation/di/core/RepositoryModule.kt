package com.mw21.codetest.presentation.di.core

import com.mw21.codetest.data.db.DaoColaborators
import com.mw21.codetest.data.repositry.LoginRepositoryImpl
import com.mw21.codetest.data.repositry.addColaborator.AddColaboratorRepositoryImpl
import com.mw21.codetest.data.repositry.addColaborator.datasource.LocalDataSource
import com.mw21.codetest.data.repositry.colaborators.ColaboratorsRepositoryImpl
import com.mw21.codetest.data.repositry.home.HomeRepositoryImpl
import com.mw21.codetest.data.repositry.home.datasource.RemoteDataSource
import com.mw21.codetest.domain.repository.AddColaboratorRepository
import com.mw21.codetest.domain.repository.ColaboratorsRepository
import com.mw21.codetest.domain.repository.HomeRepository
import com.mw21.codetest.domain.repository.LogInRepositoy
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideLogInRepository(): LogInRepositoy = LoginRepositoryImpl()

    @Singleton
    @Provides
    fun provideHomeRepository(remoteDataSource: RemoteDataSource): HomeRepository = HomeRepositoryImpl(remoteDataSource)

    @Singleton
    @Provides
    fun provideAddColaboratorRepository(daoColaborators: DaoColaborators): AddColaboratorRepository = AddColaboratorRepositoryImpl(daoColaborators)

    @Singleton
    @Provides
    fun provideColaboratorRepository(daoColaborators: DaoColaborators): ColaboratorsRepository = ColaboratorsRepositoryImpl(daoColaborators)
}