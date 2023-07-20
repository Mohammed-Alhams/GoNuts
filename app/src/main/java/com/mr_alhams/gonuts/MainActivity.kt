package com.mr_alhams.gonuts

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mr_alhams.gonuts.app_navigation.BottomBarScreen
import com.mr_alhams.gonuts.ui.GoNutsNavGraph
import com.mr_alhams.gonuts.ui.theme.Background
import com.mr_alhams.gonuts.ui.theme.GoNutsTheme
import com.mr_alhams.gonuts.ui.theme.Primary
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoNutsTheme {
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = { BottomBar(navController = navController) }
                ) {
                    Box(
                        modifier = Modifier
                            .background(Background)
                            .padding(bottom = it.calculateBottomPadding())
                    ) {
                        GoNutsNavGraph(navController)
                    }
                }
            }
        }
    }
}


@Composable
fun BottomBar(navController: NavHostController) {

    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Favourite,
        BottomBarScreen.Notifications,
        BottomBarScreen.Cart,
        BottomBarScreen.Profile,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = screens.any { it.route == currentDestination?.route }

    if (bottomBarDestination) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .shadow(1.dp, spotColor = Color.LightGray)
                .height(80.dp)
                .fillMaxWidth(),
        ) {
            screens.forEach { screen ->
                this.AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {

    val isSelected = currentDestination?.hierarchy?.any {
        it.route == screen.route
    } == true

    val icon = if (isSelected) screen.unselectedIcon else screen.icon

    Icon(
        painter = painterResource(id = icon),
        contentDescription = screen.title,
        tint = Primary,
        modifier = Modifier.clickable {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )

}