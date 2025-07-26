package com.vishalpvijayan.composeanimation_hilt.data.model


import com.google.gson.annotations.SerializedName

data class ManualBuyEducationDataDto(
    @SerializedName("cohort") val cohort: String?,
    @SerializedName("ctaLottie") val ctaLottie: String?,
    @SerializedName("seenCount") val seenCount: Int?,
    @SerializedName("actionText") val actionText: String?,
    @SerializedName("introTitle") val introTitle: String?,
    @SerializedName("screenType") val screenType: String?,
    @SerializedName("combination") val combination: String?,
    @SerializedName("toolBarIcon") val toolBarIcon: String?,
    @SerializedName("toolBarText") val toolBarText: String?,
    @SerializedName("introSubtitle") val introSubtitle: String?,
    @SerializedName("saveButtonCta") val saveButtonCta: SaveButtonCtaDto?,
    @SerializedName("educationCardList") val educationCardList: List<EducationCardDto>?,
    @SerializedName("introSubtitleIcon") val introSubtitleIcon: String?,
    @SerializedName("expandCardStayInterval") val expandCardStayInterval: Int?,
    @SerializedName("shouldShowOnLandingPage") val shouldShowOnLandingPage: Boolean?,
    @SerializedName("collapseCardTiltInterval") val collapseCardTiltInterval: Int?,
    @SerializedName("shouldShowBeforeNavigating") val shouldShowBeforeNavigating: Boolean?,
    @SerializedName("collapseExpandIntroInterval") val collapseExpandIntroInterval: Int?,
    @SerializedName("bottomToCenterTranslationInterval") val bottomToCenterTranslationInterval: Int?
)

data class SaveButtonCtaDto(
    @SerializedName("icon") val icon: String?,
    @SerializedName("text") val text: String?,
    @SerializedName("order") val order: Int?,
    @SerializedName("deeplink") val deeplink: String?,
    @SerializedName("textColor") val textColor: String?,
    @SerializedName("strokeColor") val strokeColor: String?,
    @SerializedName("backgroundColor") val backgroundColor: String?
)

data class EducationCardDto(
    @SerializedName("image") val image: String?,
    @SerializedName("endGradient") val endGradient: String?,
    @SerializedName("startGradient") val startGradient: String?,
    @SerializedName("strokeEndColor") val strokeEndColor: String?,
    @SerializedName("backGroundColor") val backGroundColor: String?,
    @SerializedName("expandStateText") val expandStateText: String?,
    @SerializedName("strokeStartColor") val strokeStartColor: String?,
    @SerializedName("collapsedStateText") val collapsedStateText: String?
)
