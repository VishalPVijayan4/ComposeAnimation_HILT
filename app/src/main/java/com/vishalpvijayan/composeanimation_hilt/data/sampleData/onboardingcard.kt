package com.vishalpvijayan.composeanimation_hilt.data.sampleData

data class OnboardingCard(
    val id: Int,
    val expandStateText: String,
    val collapsedStateText: String,
    val description: String,
    val imageRes: String,
    val backgroundColor: String,
    val startGradient: String,
    val endGradient: String,
    val strokeEndColor: String,
    val strokeStartColor: String,
)