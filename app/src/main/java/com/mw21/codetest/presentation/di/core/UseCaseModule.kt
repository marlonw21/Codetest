package com.mw21.codetest.presentation.di.core

import com.mw21.codetest.domain.repository.AddColaboratorRepository
import com.mw21.codetest.domain.repository.ColaboratorsRepository
import com.mw21.codetest.domain.repository.HomeRepository
import com.mw21.codetest.domain.repository.LogInRepositoy
import com.mw21.codetest.domain.usecase.LoginUseCase
import com.mw21.codetest.domain.usecase.addcolaborator.AddColaboratorToCloudFirestore
import com.mw21.codetest.domain.usecase.addcolaborator.SaveColaboratorToDBUseCase
import com.mw21.codetest.domain.usecase.colaborators.GetAllColabFromDBUseCase
import com.mw21.codetest.domain.usecase.home.BackupToCloudFirestoreUseCase
import com.mw21.codetest.domain.usecase.home.DownloadFileUseCase
import com.mw21.codetest.domain.usecase.home.GetJsonResponseUseCase
import com.mw21.codetest.domain.usecase.home.SaveContentFromFileToDBUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideLogInUseCase(logInRepositoy: LogInRepositoy): LoginUseCase = LoginUseCase(logInRepositoy)

    @Provides
    fun provideGetJsonResponseUseCase(homeRepository: HomeRepository): GetJsonResponseUseCase = GetJsonResponseUseCase(homeRepository)

    @Provides
    fun provideDownloadFileUseCae(homeRepository: HomeRepository): DownloadFileUseCase = DownloadFileUseCase(homeRepository)

    @Provides
    fun provideSaveContentFromFileUseCae(): SaveContentFromFileToDBUseCase = SaveContentFromFileToDBUseCase()

    @Provides
    fun provideBackupToCloudFirestoreUseCae(): BackupToCloudFirestoreUseCase = BackupToCloudFirestoreUseCase()

    @Provides
    fun provideSaveColaboratorToDBUseCase(addColaboratorRepository: AddColaboratorRepository): SaveColaboratorToDBUseCase = SaveColaboratorToDBUseCase(addColaboratorRepository)

    @Provides
    fun provideAddColaboratorToFirestore(addColaboratorRepository: AddColaboratorRepository): AddColaboratorToCloudFirestore = AddColaboratorToCloudFirestore(addColaboratorRepository)

    @Provides
    fun provideGetAllColabsUseCase(colaboratorRepository: ColaboratorsRepository): GetAllColabFromDBUseCase = GetAllColabFromDBUseCase(colaboratorRepository)

}