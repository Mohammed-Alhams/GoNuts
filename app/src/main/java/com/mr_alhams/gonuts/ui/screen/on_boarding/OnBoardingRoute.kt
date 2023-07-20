package com.mr_alhams.gonuts.ui.screen.on_boarding

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mr_alhams.gonuts.app_navigation.Screen

fun NavGraphBuilder.onBoardingRoute(navController: NavController) {
    composable(Screen.OnBoardingScreen.route) { OnBoardingScreen(navController = navController) }
}