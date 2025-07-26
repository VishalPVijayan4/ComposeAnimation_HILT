package com.vishalpvijayan.composeanimation_hilt.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vishalpvijayan.composeanimation_hilt.data.sampleData.getStaticCards
import com.vishalpvijayan.composeanimation_hilt.presentation.screens.LandingScreen
import com.vishalpvijayan.composeanimation_hilt.presentation.screens.ManualBuyEducationScreen
import com.vishalpvijayan.composeanimation_hilt.presentation.screens.OnboardingScreen
import com.vishalpvijayan.composeanimation_hilt.presentation.screens.SplashScreen
import com.vishalpvijayan.composeanimation_hilt.presentation.viewModels.ManualBuyEducationViewModel



@Composable
fun NavigationInApp() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "splash") {

        //1. SPLASH SCREEN
        composable("splash") {
            SplashScreen(navController)
        }

        //2. ONBOARDING SCREEN WITH STATIC DATA
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

        //4. ONBOARDING SCREEN WITH REMOTE DATA
        composable("education") {
            val viewModel: ManualBuyEducationViewModel = hiltViewModel()
            LaunchedEffect(Unit) { viewModel.load() }

            ManualBuyEducationScreen(
                viewModel = viewModel,
                navController = navController,
                onNavigateToLanding = {
                    navController.navigate("landing")
                }
            )
        }
    }
}

