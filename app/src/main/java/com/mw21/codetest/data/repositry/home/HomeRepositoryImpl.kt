package com.mw21.codetest.data.repositry.home

import android.util.Log
import com.mw21.codetest.data.models.employee.Employee
import com.mw21.codetest.data.models.jsonresponse.JsonResponse
import com.mw21.codetest.data.repositry.home.datasource.RemoteDataSource
import com.mw21.codetest.domain.repository.HomeRepository
import retrofit2.Response

class HomeRepositoryImpl(private val remoteDataSource: RemoteDataSource): HomeRepository {
    override suspend fun getJsonResponse(): JsonResponse {
        lateinit var body : JsonResponse
        try {
            val response = remoteDataSource.getJsonResponse()
            if (response.body() != null){
                body = response.body()!!
            }
        }catch (e: Exception){
            Log.d("Exception", "getJsonResponseImpl")
        }
        return body
    }

    override suspend fun downloadFileFromJson(url: String) {
        TODO("Not yet implemented")
    }

    override suspend fun saveContentFromFileToDB(employee: Employee) {
        TODO("Not yet implemented")
    }

    override suspend fun backupToCloudFirestore() {
        TODO("Not yet implemented")
    }
}