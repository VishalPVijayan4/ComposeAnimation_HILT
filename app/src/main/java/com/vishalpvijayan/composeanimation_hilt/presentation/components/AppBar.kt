package com.vishalpvijayan.composeanimation_hilt.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarWithBackButton(
    title: String,
    onBackClick: () -> Unit,
    backgroundColor: Color = Color(0xFF322B47),
    titleColor: Color = Color(0xFFEEEBF5),
    iconColor: Color = Color(0xFFF8DC83)
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = titleColor
            )
        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = iconColor
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = backgroundColor
        )
    )
}


