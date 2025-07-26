package com.vishalpvijayan.composeanimation_hilt.presentation.screens

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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
    var currentVisibleIndex by remember { mutableIntStateOf(0) }
    val fullyVisibleCards = remember { mutableStateListOf<OnboardingCard>() }
    var expandedCardId by remember { mutableStateOf<Int?>(null) }

    val isLastCardVisible by remember {
        derivedStateOf { currentVisibleIndex >= cards.size }
    }

    LaunchedEffect(Unit) {
        while (currentVisibleIndex < cards.size) {
            val isLast = currentVisibleIndex == cards.lastIndex
            expandedCardId = cards[currentVisibleIndex].id
            delay(2000)

            if (!isLast) {
                expandedCardId = null // Collapse card unless it's the last one
            }

            fullyVisibleCards.add(cards[currentVisibleIndex])
            currentVisibleIndex++
        }
    }

    Scaffold(
        topBar = {
            AppBarWithBackButton(
                title = "Onboarding",
                backgroundColor = Color(0xFF322B47),
                titleColor = Color(0xFFFFFFFF),
                iconColor = Color(0xFFFFFFFF),
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
                        Text("Save in Gold")
                    }
                }
            }
        }
    ) { innerPadding ->

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
                val isLastCard = index == fullyVisibleCards.lastIndex && currentVisibleIndex >= cards.size

                ExpandableOnboardingCard(
                    card = card,
                    expanded = isLastCard,
                    onExpand = {},
                    onCollapse = {},
                    showActionButton = false,
                    onActionButtonClick = {}
                )
            }
            if (currentVisibleIndex < cards.size) {
                item {
                    val card = cards[currentVisibleIndex]
                    AnimatedZigZagCard(
                        card = card,
                        expanded = (card.id == expandedCardId)
                    )
                }
            }
        }
    }
}
