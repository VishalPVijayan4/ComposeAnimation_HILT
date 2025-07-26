package com.vishalpvijayan.composeanimation_hilt.data.mapper

import com.vishalpvijayan.composeanimation_hilt.data.model.EducationCardDto
import com.vishalpvijayan.composeanimation_hilt.data.model.ManualBuyEducationDataDto
import com.vishalpvijayan.composeanimation_hilt.data.model.SaveButtonCtaDto
import com.vishalpvijayan.composeanimation_hilt.domain.model.EducationCard
import com.vishalpvijayan.composeanimation_hilt.domain.model.ManualBuyEducationData
import com.vishalpvijayan.composeanimation_hilt.domain.model.SaveButtonCta
import kotlin.collections.map


fun ManualBuyEducationDataDto.toDomain(): ManualBuyEducationData {
    return ManualBuyEducationData(
        cohort = cohort,
        ctaLottie = ctaLottie,
        seenCount = seenCount,
        actionText = actionText,
        introTitle = introTitle,
        screenType = screenType,
        combination = combination,
        toolBarIcon = toolBarIcon,
        toolBarText = toolBarText,
        introSubtitle = introSubtitle,
        saveButtonCta = saveButtonCta?.toDomain(),
        educationCardList = educationCardList?.map { it.toDomain() },
        introSubtitleIcon = introSubtitleIcon,
        expandCardStayInterval = expandCardStayInterval,
        shouldShowOnLandingPage = shouldShowOnLandingPage,
        collapseCardTiltInterval = collapseCardTiltInterval,
        shouldShowBeforeNavigating = shouldShowBeforeNavigating,
        collapseExpandIntroInterval = collapseExpandIntroInterval,
        bottomToCenterTranslationInterval = bottomToCenterTranslationInterval
    )
}

fun SaveButtonCtaDto.toDomain() = SaveButtonCta(icon, text, order, deeplink, textColor, strokeColor, backgroundColor)
fun EducationCardDto.toDomain() = EducationCard(image, endGradient, startGradient, strokeEndColor, backGroundColor, expandStateText, strokeStartColor, collapsedStateText)
