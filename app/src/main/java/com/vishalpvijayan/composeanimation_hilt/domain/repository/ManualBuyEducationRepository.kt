package com.vishalpvijayan.composeanimation_hilt.domain.repository

import com.vishalpvijayan.composeanimation_hilt.domain.model.ManualBuyEducationData

interface ManualBuyEducationRepository {
    suspend fun fetchManualBuyEducationData(): ManualBuyEducationData
}