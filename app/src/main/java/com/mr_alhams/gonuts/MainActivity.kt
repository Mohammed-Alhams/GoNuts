package com.mr_alhams.gonuts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mr_alhams.gonuts.ui.screen.home.HomeScreen
import com.mr_alhams.gonuts.ui.theme.GoNutsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoNutsTheme {
                HomeScreen()
            }
        }
    }
}