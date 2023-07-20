package com.mr_alhams.gonuts.app_navigation//package com.mr_alhams.gonuts.ui

sealed class Screen(val route: String) {
    object OnBoardingScreen : Screen("onBoardingScreen")
    object HomeScreen : Screen("homeScreen")
    object DetailsScreen : Screen("detailsScreen")
}
