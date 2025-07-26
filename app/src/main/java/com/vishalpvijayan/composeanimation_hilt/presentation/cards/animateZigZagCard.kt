package com.vishalpvijayan.composeanimation_hilt.presentation.cards

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import com.vishalpvijayan.composeanimation_hilt.data.sampleData.OnboardingCard
import kotlinx.coroutines.launch

@Composable
fun AnimatedZigZagCard(card: OnboardingCard, expanded: Boolean) {
    val offsetX = remember { Animatable(if (card.id % 2 == 0) -300f else 300f) }
    val offsetY = remember { Animatable(300f) }
    val alpha = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        launch {
            offsetX.animateTo(0f, animationSpec = tween(700, easing = FastOutSlowInEasing))
        }
        launch {
            offsetY.animateTo(0f, animationSpec = tween(700, easing = FastOutSlowInEasing))
        }
        launch {
            alpha.animateTo(1f, animationSpec = tween(700))
        }
    }

    Box(
        modifier = Modifier
            .graphicsLayer {
                translationX = offsetX.value
                translationY = offsetY.value
                this.alpha = alpha.value
            }
    ) {
        ExpandableOnboardingCard(
            card = card,
            expanded = expanded,
            onExpand = {},
            onCollapse = {},
            showActionButton = false,
            onActionButtonClick = {}
        )
    }
}