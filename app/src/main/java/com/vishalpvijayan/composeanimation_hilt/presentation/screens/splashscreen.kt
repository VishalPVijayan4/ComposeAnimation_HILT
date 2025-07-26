package com.vishalpvijayan.composeanimation_hilt.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(2000L) // Wait for 2 seconds
        navController.navigate("landing") {
            popUpTo("splash") { inclusive = true } // Remove splash from back stack
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF322B47)),  // Background color set here
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Welcome to",
                style = MaterialTheme.typography.headlineLarge,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFEEEBF5) // First text color
            )
            Text(
                fontSize = 24.sp,
                text = "Onboarding",
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xFFF8DC83) // Second text color
            )
        }
    }
}
