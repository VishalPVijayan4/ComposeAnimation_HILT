package com.vishalpvijayan.composeanimation_hilt.data.repository

import com.vishalpvijayan.composeanimation_hilt.data.mapper.toDomain
import com.vishalpvijayan.composeanimation_hilt.domain.model.ManualBuyEducationData
import com.vishalpvijayan.composeanimation_hilt.domain.repository.ManualBuyEducationRepository
import com.vishalpvijayan.composeanimation_hilt.data.remote.RemoteDataSource
import javax.inject.Inject

class ManualBuyEducationRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : ManualBuyEducationRepository {
    override suspend fun fetchManualBuyEducationData(): ManualBuyEducationData {
        val response = remoteDataSource.getManualBuyEducationData()
        return response.data.manualBuyEducationData.toDomain()
    }
}