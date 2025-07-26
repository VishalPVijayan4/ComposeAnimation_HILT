package com.vishalpvijayan.composeanimation_hilt.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.vishalpvijayan.composeanimation_hilt.presentation.components.AppBarWithBackButton


@Composable
fun LandingScreen(navController: NavController) {
    Scaffold(
        topBar = {
            AppBarWithBackButton(
                title = "Landing Page",
                backgroundColor = Color(0xFF322B47),
                titleColor = Color(0xFFFFFFFF),
                iconColor = Color(0xFFFFFFFF),
                onBackClick = { navController.popBackStack() }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFF322B47)),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    fontSize = 24.sp,
                    text = "Landing Page",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color(0xFFFFFFFF)
                )
            }
        }
    }
}



