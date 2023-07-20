package com.mr_alhams.gonuts.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mr_alhams.gonuts.app_navigation.Screen
import com.mr_alhams.gonuts.ui.screen.cart.cartRoute
import com.mr_alhams.gonuts.ui.screen.details.detailsRoute
import com.mr_alhams.gonuts.ui.screen.fav.favouriteRoute
import com.mr_alhams.gonuts.ui.screen.home.homeRoute
import com.mr_alhams.gonuts.ui.screen.notif.notificationsRoute
import com.mr_alhams.gonuts.ui.screen.on_boarding.onBoardingRoute
import com.mr_alhams.gonuts.ui.screen.profile.profileRoute

@Composable
fun GoNutsNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.OnBoardingScreen.route
    ) {
        onBoardingRoute(navController)
        homeRoute(navController)
        detailsRoute(navController)
        profileRoute()
        notificationsRoute()
        cartRoute()
        favouriteRoute()
    }
}