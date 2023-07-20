package com.mr_alhams.gonuts.ui.screen.details

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mr_alhams.gonuts.ui.screen.details.DetailsArgs.Companion.INDEX_ARG


private const val ROUTE = "detailsScreen"

fun NavController.navigateToDetails(index: Int) {
    navigate("$ROUTE/$index")
}

fun NavGraphBuilder.detailsRoute() {
    composable(
        route = "$ROUTE/{$INDEX_ARG}",
        arguments = listOf(navArgument(INDEX_ARG) { NavType.IntType }),
    ) { DetailsScreen() }
}

class DetailsArgs(savedStateHandle: SavedStateHandle) {
    val index = checkNotNull(savedStateHandle.get<Any?>(INDEX_ARG).toString())

    companion object {
        const val INDEX_ARG = "index"
    }
}