package com.vishalpvijayan.composeanimation_hilt.data.remote


import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun getManualBuyEducationData() = apiService.getManualBuyEducationData()
}
