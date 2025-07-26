package com.vishalpvijayan.composeanimation_hilt.presentation.cards

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import coil.compose.rememberAsyncImagePainter
import com.vishalpvijayan.composeanimation_hilt.data.sampleData.OnboardingCard
import com.vishalpvijayan.composeanimation_hilt.presentation.components.ButtonWithGif


@Composable
fun ExpandableOnboardingCard(
    card: OnboardingCard,
    expanded: Boolean,
    onExpand: () -> Unit,
    onCollapse: () -> Unit,
    showActionButton: Boolean,
    onActionButtonClick: () -> Unit
) {
    val shape = RoundedCornerShape(60.dp)

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
            .border(width = 1.dp, brush = borderGradient, shape = shape),
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
                    modifier = Modifier.fillMaxWidth().width(340.dp).height(350.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Spacer(modifier = Modifier.height(16.dp))

                    Image(
                        painter = rememberAsyncImagePainter(card.imageRes),
                        contentDescription = null,
                        modifier = Modifier
                            .width(360.dp)
                            .height(250.dp)
                            .clip(RoundedCornerShape(
                                topStart = 16.dp,
                                topEnd = 16.dp,
                                bottomStart = 16.dp,
                                bottomEnd = 16.dp
                            )),
                        contentScale = ContentScale.FillHeight
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
                        fontSize = 16.sp,
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






