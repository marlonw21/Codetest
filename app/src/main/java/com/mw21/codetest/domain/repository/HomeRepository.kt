package com.mw21.codetest.domain.repository

import com.mw21.codetest.data.models.employee.Employee
import com.mw21.codetest.data.models.jsonresponse.JsonResponse
import retrofit2.Response

interface HomeRepository {
    suspend fun getJsonResponse(): JsonResponse // falta
    suspend fun downloadFileFromJson(url: String) //falta
    suspend fun saveContentFromFileToDB(employee: Employee)// falta
    suspend fun backupToCloudFirestore()// falta
}