package com.mw21.codetest.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mw21.codetest.domain.usecase.home.BackupToCloudFirestoreUseCase
import com.mw21.codetest.domain.usecase.home.DownloadFileUseCase
import com.mw21.codetest.domain.usecase.home.GetJsonResponseUseCase
import com.mw21.codetest.domain.usecase.home.SaveContentFromFileToDBUseCase

class HomeViewModelFactory(private val getJsonResponseUseCase: GetJsonResponseUseCase,
                           private val downloadFileUseCase: DownloadFileUseCase,
                           private val saveContentFromFileToDBUseCase: SaveContentFromFileToDBUseCase,
                           private val backupToCloudFirestoreUseCase: BackupToCloudFirestoreUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =  HomeViewModel(
        getJsonResponseUseCase,
        downloadFileUseCase,
        saveContentFromFileToDBUseCase,
        backupToCloudFirestoreUseCase
    ) as T
}