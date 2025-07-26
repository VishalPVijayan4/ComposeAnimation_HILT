package com.vishalpvijayan.composeanimation_hilt.domain.usecase

import com.vishalpvijayan.composeanimation_hilt.domain.model.ManualBuyEducationData
import com.vishalpvijayan.composeanimation_hilt.domain.repository.ManualBuyEducationRepository
import javax.inject.Inject

class GetManualBuyEducationDataUseCase @Inject constructor(
    private val repository: ManualBuyEducationRepository
) {
    suspend operator fun invoke(): ManualBuyEducationData =
        repository.fetchManualBuyEducationData()
}