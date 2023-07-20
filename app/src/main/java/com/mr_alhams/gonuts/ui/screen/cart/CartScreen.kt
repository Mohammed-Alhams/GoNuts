package com.mr_alhams.gonuts.ui.screen.cart

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mr_alhams.gonuts.app_navigation.Screen

@Composable
fun CartScreen() {
    Box(Modifier.fillMaxSize()) {

    }
}

fun NavGraphBuilder.cartRoute() {
    composable(Screen.CartScreen.route) { CartScreen() }
}