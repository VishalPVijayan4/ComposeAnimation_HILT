package com.vishalpvijayan.composeanimation_hilt.data.remote


import com.vishalpvijayan.composeanimation_hilt.data.model.ManualBuyEducationDataDto
import retrofit2.http.GET

interface ApiService {
    @GET("796729cca6c55a7d089e")
    suspend fun getManualBuyEducationData(): ApiResponse
}

data class ApiResponse(
    val data: ManualBuyEducationDataResponse,
    val success: Boolean
)

data class ManualBuyEducationDataResponse(
    val manualBuyEducationData: ManualBuyEducationDataDto
)
