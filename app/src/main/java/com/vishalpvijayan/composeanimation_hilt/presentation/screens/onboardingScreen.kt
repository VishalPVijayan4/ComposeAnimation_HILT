package com.vishalpvijayan.composeanimation_hilt.presentation.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.vishalpvijayan.composeanimation_hilt.data.sampleData.OnboardingCard
import com.vishalpvijayan.composeanimation_hilt.presentation.cards.AnimatedZigZagCard
import com.vishalpvijayan.composeanimation_hilt.presentation.cards.ExpandableOnboardingCard
import com.vishalpvijayan.composeanimation_hilt.presentation.components.AppBarWithBackButton
import kotlinx.coroutines.delay


@Composable
fun OnboardingScreen(
    navController: NavController,
    cards: List<OnboardingCard>,
    onNavigateToLanding: () -> Unit
) {
    var currentVisibleIndex by remember { mutableStateOf(0) }
    val fullyVisibleCards = remember { mutableStateListOf<OnboardingCard>() }
    var expandedCardId by remember { mutableStateOf<Int?>(null) }

    val isLastCardVisible by remember {
        derivedStateOf { currentVisibleIndex >= cards.size }
    }

    LaunchedEffect(Unit) {
        while (currentVisibleIndex < cards.size) {
            val card = cards[currentVisibleIndex]
            expandedCardId = card.id // Expand the new card
            delay(2000)

            fullyVisibleCards.add(card)
            currentVisibleIndex++
        }
    }

    val currentBackgroundColor = remember(expandedCardId) {
        cards.find { it.id == expandedCardId }?.backgroundColor ?: "#FFFFFF"
    }

    val animatedBackgroundColor = animateColorAsState(
        targetValue = Color(android.graphics.Color.parseColor(currentBackgroundColor)),
        animationSpec = tween(1000),
        label = "backgroundColor"
    )

    Scaffold(
        topBar = {
            AppBarWithBackButton(
                title = "Onboarding",
                titleColor = Color.White,
                iconColor = Color.White,
                backgroundColor = Color(android.graphics.Color.parseColor(currentBackgroundColor)),
                onBackClick = { navController.popBackStack() }
            )
        },
        bottomBar = {
            if (isLastCardVisible) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 46.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Button(onClick = onNavigateToLanding) {
                        Text(
                            text = "Save in Gold",
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(vertical = 6.dp)
                        )
                    }
                }
            }
        }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(animatedBackgroundColor.value)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(
                    top = innerPadding.calculateTopPadding(),
                    bottom = if (isLastCardVisible) 150.dp else innerPadding.calculateBottomPadding(),
                    start = 36.dp,
                    end = 36.dp
                ),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                reverseLayout = false
            ) {
                items(
                    count = fullyVisibleCards.size,
                    key = { index -> fullyVisibleCards[index].id }
                ) { index ->
                    val card = fullyVisibleCards[index]
                    ExpandableOnboardingCard(
                        card = card,
                        expanded = card.id == expandedCardId,
                        onExpand = { expandedCardId = card.id },
                        onCollapse = { if (expandedCardId == card.id) expandedCardId = null },
                        showActionButton = false,
                        onActionButtonClick = {}
                    )
                }

                if (currentVisibleIndex < cards.size) {
                    item {
                        val card = cards[currentVisibleIndex]
                        AnimatedZigZagCard(
                            card = card,
                            expanded = (card.id == expandedCardId),
                            onClick = {
                                expandedCardId = card.id
                            }
                        )
                    }
                }
            }
        }
    }
}
