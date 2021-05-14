package com.mw21.codetest.data.api

import com.mw21.codetest.data.models.jsonresponse.JsonResponse
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("/s/5u21281sca8gj94/getFile.json?dl=0")
    suspend fun getJsonResponse(): Response<JsonResponse>
}