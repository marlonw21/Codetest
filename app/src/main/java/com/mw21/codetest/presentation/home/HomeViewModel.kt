package com.mw21.codetest.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mw21.codetest.domain.usecase.home.BackupToCloudFirestoreUseCase
import com.mw21.codetest.domain.usecase.home.DownloadFileUseCase
import com.mw21.codetest.domain.usecase.home.GetJsonResponseUseCase
import com.mw21.codetest.domain.usecase.home.SaveContentFromFileToDBUseCase

class HomeViewModel(private val getJsonResponseUseCase: GetJsonResponseUseCase,
                    private val downloadFileUseCase: DownloadFileUseCase,
                    private val saveContentFromFileToDBUseCase: SaveContentFromFileToDBUseCase,
                    private val backupToCloudFirestoreUseCase: BackupToCloudFirestoreUseCase
): ViewModel() {
    fun getJsonResponse() = liveData{
        emit(getJsonResponseUseCase.execute())
    }
}