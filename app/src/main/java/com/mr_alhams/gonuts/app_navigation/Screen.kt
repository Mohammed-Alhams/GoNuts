package com.mr_alhams.gonuts.app_navigation

import com.mr_alhams.gonuts.R

sealed class Screen(val route: String) {
    object OnBoardingScreen : Screen("onBoardingScreen")
    object HomeScreen : Screen("homeScreen")
    object FavouriteScreen : Screen("favouriteScreen")

    object NotificationsScreen : Screen("notificationsScreen")

    object CartScreen : Screen("cartScreen")

    object ProfileScreen : Screen("profileScreen")

    object DetailsScreen : Screen("detailsScreen")
}

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int,
    val unselectedIcon: Int
) {
    object Home : BottomBarScreen(
        route = Screen.HomeScreen.route, "Home", R.drawable.home, R.drawable.home_filled
    )

    object Favourite : BottomBarScreen(
        route = Screen.FavouriteScreen.route, "Favourite", R.drawable.heart, R.drawable.heart_filled
    )

    object Notifications : BottomBarScreen(
        route = Screen.NotificationsScreen.route,
        "Notifications",
        R.drawable.notification,
        R.drawable.notification_filled
    )

    object Cart : BottomBarScreen(
        route = Screen.CartScreen.route, "Cart", R.drawable.buy, R.drawable.buy_filled
    )

    object Profile : BottomBarScreen(
        route = Screen.ProfileScreen.route, "Profile", R.drawable.user, R.drawable.user
    )
}