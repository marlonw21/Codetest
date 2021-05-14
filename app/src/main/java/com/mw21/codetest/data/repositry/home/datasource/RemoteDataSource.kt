package com.mw21.codetest.data.repositry.home.datasource

import com.mw21.codetest.data.models.jsonresponse.JsonResponse
import retrofit2.Response

interface RemoteDataSource {
    suspend fun getJsonResponse(): Response<JsonResponse>
}