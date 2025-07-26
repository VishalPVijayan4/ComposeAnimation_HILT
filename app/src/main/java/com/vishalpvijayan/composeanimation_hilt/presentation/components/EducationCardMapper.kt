package com.vishalpvijayan.composeanimation_hilt.domain.mapper

import com.vishalpvijayan.composeanimation_hilt.domain.model.EducationCard
import com.vishalpvijayan.composeanimation_hilt.domain.model.OnboardingCard


fun EducationCard.toOnboardingCard(index: Int): OnboardingCard {
    return OnboardingCard(
        id = index,
        imageRes = this.image ?: "",
        startGradient = this.startGradient ?: "#FFFFFF",
        endGradient = this.endGradient ?: "#FFFFFF",
        strokeStartColor = this.strokeStartColor ?: "#FFFFFFFF",
        strokeEndColor = this.strokeEndColor ?: "#FFFFFFFF",
        expandStateText = this.expandStateText ?: "",
        collapsedStateText = this.collapsedStateText ?: "",
        description = ""
    )
}
