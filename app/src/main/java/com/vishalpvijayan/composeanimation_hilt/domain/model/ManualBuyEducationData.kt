package com.vishalpvijayan.composeanimation_hilt.domain.model


data class ManualBuyEducationData(
    val cohort: String?,
    val ctaLottie: String?,
    val seenCount: Int?,
    val actionText: String?,
    val introTitle: String?,
    val screenType: String?,
    val combination: String?,
    val toolBarIcon: String?,
    val toolBarText: String?,
    val introSubtitle: String?,
    val saveButtonCta: SaveButtonCta?,
    val educationCardList: List<EducationCard>?,
    val introSubtitleIcon: String?,
    val expandCardStayInterval: Int?,
    val shouldShowOnLandingPage: Boolean?,
    val collapseCardTiltInterval: Int?,
    val shouldShowBeforeNavigating: Boolean?,
    val collapseExpandIntroInterval: Int?,
    val bottomToCenterTranslationInterval: Int?
)

data class SaveButtonCta(
    val icon: String?,
    val text: String?,
    val order: Int?,
    val deeplink: String?,
    val textColor: String?,
    val strokeColor: String?,
    val backgroundColor: String?
)

data class EducationCard(
    val image: String?,
    val endGradient: String?,
    val startGradient: String?,
    val strokeEndColor: String?,
    val backGroundColor: String?,
    val expandStateText: String?,
    val strokeStartColor: String?,
    val collapsedStateText: String?
)
