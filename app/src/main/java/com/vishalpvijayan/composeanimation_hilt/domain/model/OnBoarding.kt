package com.vishalpvijayan.composeanimation_hilt.domain.model

data class OnboardingCard(
    val id: Int,
    val imageRes: String,
    val startGradient: String,
    val endGradient: String,
    val strokeStartColor: String,
    val strokeEndColor: String,
    val expandStateText: String,
    val collapsedStateText: String,
    val description: String = ""
)

