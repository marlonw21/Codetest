package com.mw21.codetest.data.repositry.home.datasourceImpl

import com.mw21.codetest.data.api.APIService
import com.mw21.codetest.data.models.jsonresponse.JsonResponse
import com.mw21.codetest.data.repositry.home.datasource.RemoteDataSource
import retrofit2.Response

class RemoteDataSourceImpl(private val apiService: APIService): RemoteDataSource {
    override suspend fun getJsonResponse(): Response<JsonResponse> = apiService.getJsonResponse()
}