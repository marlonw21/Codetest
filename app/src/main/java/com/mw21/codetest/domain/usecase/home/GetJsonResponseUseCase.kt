package com.mw21.codetest.domain.usecase.home

import com.mw21.codetest.data.models.jsonresponse.JsonResponse
import com.mw21.codetest.domain.repository.HomeRepository
import retrofit2.Response

class GetJsonResponseUseCase(private val homeRepository: HomeRepository) {
    suspend fun execute() : JsonResponse = homeRepository.getJsonResponse()
}