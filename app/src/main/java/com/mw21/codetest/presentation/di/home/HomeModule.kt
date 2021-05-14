package com.mw21.codetest.presentation.di.home

import com.mw21.codetest.domain.usecase.home.BackupToCloudFirestoreUseCase
import com.mw21.codetest.domain.usecase.home.DownloadFileUseCase
import com.mw21.codetest.domain.usecase.home.GetJsonResponseUseCase
import com.mw21.codetest.domain.usecase.home.SaveContentFromFileToDBUseCase
import com.mw21.codetest.presentation.home.HomeViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class HomeModule {
    @HomeScope
    @Provides
    fun provideHomeViewModeFactory(
        getJsonResponseUseCase: GetJsonResponseUseCase,
        downloadFileUseCase: DownloadFileUseCase,
        saveContentFromFileToDBUseCase: SaveContentFromFileToDBUseCase,
        backupToCloudFirestoreUseCase: BackupToCloudFirestoreUseCase
    ): HomeViewModelFactory = HomeViewModelFactory(
        getJsonResponseUseCase,
        downloadFileUseCase,
        saveContentFromFileToDBUseCase,
        backupToCloudFirestoreUseCase
    )
}