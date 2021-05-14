package com.mw21.codetest.data.models.jsonresponse

data class JsonResponse(
    val code: Int,
    val `data`: Data,
    val success: Boolean
)