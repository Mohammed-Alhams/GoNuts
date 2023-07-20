package com.mr_alhams.gonuts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.mr_alhams.gonuts.ui.GoNutsNavGraph
import com.mr_alhams.gonuts.ui.theme.GoNutsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoNutsTheme {
                val navController = rememberNavController()
                GoNutsNavGraph(navController)
            }
        }
    }
}