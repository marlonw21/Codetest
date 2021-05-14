package com.mw21.codetest.presentation.di.core

import com.mw21.codetest.data.api.APIService
import com.mw21.codetest.data.repositry.home.datasource.RemoteDataSource
import com.mw21.codetest.data.repositry.home.datasourceImpl.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides

@Module
class RemoteDataModule {
    @Provides
    fun provideHomeRemoteDataSource(apiService: APIService): RemoteDataSource = RemoteDataSourceImpl(apiService)
}