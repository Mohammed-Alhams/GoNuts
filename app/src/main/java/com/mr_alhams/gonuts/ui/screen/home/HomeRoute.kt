package com.mr_alhams.gonuts.ui.screen.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mr_alhams.gonuts.app_navigation.Screen

fun NavGraphBuilder.homeRoute(navController: NavController) {
    composable(Screen.HomeScreen.route) { HomeScreen(navController = navController) }
}