package com.vishalpvijayan.composeanimation_hilt.presentation.screens


import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.vishalpvijayan.composeanimation_hilt.domain.mapper.toOnboardingCard
import com.vishalpvijayan.composeanimation_hilt.domain.model.OnboardingCard
import com.vishalpvijayan.composeanimation_hilt.presentation.components.AppBarWithBackButton
import com.vishalpvijayan.composeanimation_hilt.presentation.components.ButtonWithGif
import com.vishalpvijayan.composeanimation_hilt.presentation.viewModels.ManualBuyEducationViewModel
import kotlinx.coroutines.delay


@Composable
fun ExpandableOnboardingCard(
    card: OnboardingCard,
    expanded: Boolean,
    onExpand: () -> Unit,
    onCollapse: () -> Unit,
    showActionButton: Boolean,
    onActionButtonClick: () -> Unit
) {
    val shape = RoundedCornerShape(20.dp)

    val backgroundGradient = Brush.linearGradient(
        colors = listOf(
            Color(card.startGradient.toColorInt()),
            Color(card.endGradient.toColorInt())
        )
    )

    val borderGradient = Brush.horizontalGradient(
        colors = listOf(
            Color(card.strokeStartColor.toColorInt()),
            Color(card.strokeEndColor.toColorInt())
        )
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize()
            .clickable { if (!expanded) onExpand() else onCollapse() }
            .border(width = 1.dp, brush = borderGradient, shape = RoundedCornerShape(
                16.dp
            )),
        shape = shape,
        elevation = CardDefaults.cardElevation(8.dp),
    ) {
        Box(
            modifier = Modifier
                .background(brush = backgroundGradient)
                .padding(16.dp)
        ) {
            if (expanded) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Spacer(modifier = Modifier.height(16.dp))

                    Image(
                        painter = rememberAsyncImagePainter(card.imageRes),
                        contentDescription = null,
                        modifier = Modifier
                            .width(360.dp)
                            .height(350.dp)
                            .clip(RoundedCornerShape(
                                topStart = 16.dp,
                                topEnd = 16.dp,
                                bottomStart = 16.dp,
                                bottomEnd = 16.dp
                            )),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = card.expandStateText,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = 6.dp)
                    )

                    /*Text(
                        text = card.description,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(8.dp)
                    )*/

                    if (showActionButton) {
                        Spacer(modifier = Modifier.height(16.dp))
                        ButtonWithGif(onActionButtonClick = onActionButtonClick)
                    }
                }
            } else {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(card.imageRes),
                        contentDescription = null,
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Text(
                        text = card.collapsedStateText,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        fontSize = 20.sp,
                        modifier = Modifier.weight(1f)
                    )

                    IconButton(onClick = onExpand) {
                        Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Expand", tint = Color.LightGray)
                    }
                }
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManualBuyEducationScreen(
    navController: NavController,
    onNavigateToLanding: () -> Unit,
    viewModel: ManualBuyEducationViewModel = hiltViewModel()
) {
    val data by viewModel.state.collectAsStateWithLifecycle()
    val educationCards = data?.educationCardList ?: emptyList()

    // Map domain EducationCard to UI OnboardingCard with stable IDs
    val cards = remember(educationCards) {
        educationCards.mapIndexed { index, card -> card.toOnboardingCard(index) }
    }

    var currentVisibleIndex by remember { mutableIntStateOf(0) }
    val fullyVisibleCards = remember { mutableStateListOf<OnboardingCard>() }
    var expandedCardId by remember { mutableStateOf<Int?>(null) }

    val isLastCardVisible by remember {
        derivedStateOf { currentVisibleIndex >= cards.size }
    }

    // Animate card appearances one by one
    LaunchedEffect(data) {
        if (data == null) return@LaunchedEffect
        currentVisibleIndex = 0
        fullyVisibleCards.clear()
        expandedCardId = null

        while (currentVisibleIndex < cards.size) {
            val card = cards[currentVisibleIndex]
            expandedCardId = card.id
            delay(2000)
            fullyVisibleCards.add(card)
            currentVisibleIndex++
        }
    }

    val currentBackgroundColor = remember(expandedCardId) {
        cards.find { it.id == expandedCardId }?.startGradient ?: "#FFFFFF"
    }

    val animatedBackgroundColor = animateColorAsState(
        targetValue = try {
            Color(currentBackgroundColor.toColorInt())
        } catch (e: Exception) {
            Color.White
        },
        animationSpec = tween(durationMillis = 1000),
        label = "backgroundColor"
    )

    Scaffold(
        topBar = {
            AppBarWithBackButton(
                title = "Onboarding",
                titleColor = Color.White,
                iconColor = Color.White,
                backgroundColor = Color(currentBackgroundColor.toColorInt()),
                onBackClick = { navController.popBackStack() }
            )
        },
        /*topBar = {
            TopAppBar(
                title = {
                    Text(text = data?.toolBarText ?: "Education")
                },
                navigationIcon = {
                    data?.toolBarIcon?.let { iconUrl ->
                        Icon(
                            painter = rememberAsyncImagePainter(iconUrl),
                            contentDescription = null,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }
                }
            )
        },*/
        bottomBar = {
            if (isLastCardVisible) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 46.dp),
                    contentAlignment = Alignment.Center
                ) {
                    ButtonWithGif(onActionButtonClick = {
                        navController.navigate("landing")
                    })
                    /*Button(
                        onClick = {  },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = try {
                                Color(android.graphics.Color.parseColor(data?.saveButtonCta?.backgroundColor ?: "#272239"))
                            } catch (e: Exception) {
                                Color(0xFF272239)
                            }
                        )
                    ) {
                        Text(
                            text = data?.saveButtonCta?.text ?: "Save in Gold",
                            color = try {
                                Color(android.graphics.Color.parseColor(data?.saveButtonCta?.textColor ?: "#FDF3D6"))
                            } catch (e: Exception) {
                                Color(0xFFFDF3D6)
                            }
                        )
                    }*/
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
                verticalArrangement = Arrangement.spacedBy(16.dp)
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

                // Next card that is being animated into view
                if (currentVisibleIndex < cards.size) {
                    item {
                        val card = cards[currentVisibleIndex]
                        ExpandableOnboardingCard(
                            card = card,
                            expanded = card.id == expandedCardId,
                            onExpand = { expandedCardId = card.id },
                            onCollapse = { if (expandedCardId == card.id) expandedCardId = null },
                            showActionButton = false,
                            onActionButtonClick = {}
                        )
                    }
                }
            }
        }
    }
}
