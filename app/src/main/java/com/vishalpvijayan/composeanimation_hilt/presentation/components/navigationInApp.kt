package com.vishalpvijayan.composeanimation_hilt.presentation.components

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vishalpvijayan.composeanimation_hilt.data.sampleData.getStaticCards
import com.vishalpvijayan.composeanimation_hilt.presentation.screens.LandingScreen
import com.vishalpvijayan.composeanimation_hilt.presentation.screens.OnboardingScreen
import com.vishalpvijayan.composeanimation_hilt.presentation.screens.SplashScreen

@Composable
fun NavigationInApp() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "splash") {

        //1. SPLASH SCREEN
        composable("splash") {
            SplashScreen(navController)
        }

        //2. LANDING SCREEN
        composable("landing") {
            LandingScreen(navController)
        }

        //3. LANDING SCREEN
        composable("onboarding") {
            OnboardingScreen(
                navController = navController,
                cards = getStaticCards(),
                onNavigateToLanding = { navController.navigate("landing") }
            )
        }

    }
}