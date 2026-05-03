package com.everallity.ecommerceandroidapp.core.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.everallity.ecommerceandroidapp.core.presentation.component.MainTopBar
import com.everallity.ecommerceandroidapp.core.presentation.navigation.EcommerceNavGraph
import com.everallity.ecommerceandroidapp.core.util.TokenManager

@Composable
fun MainScreen(
     mainViewModel: MainViewModel = hiltViewModel(),
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val showTopBars = currentRoute in listOf("catalog_screen", "cart_screen")
    val showBotBars = currentRoute in listOf("catalog_screen", "cart_screen")


    Scaffold(
        topBar = {
            if (showTopBars) {
                when (currentRoute) {

                }
            }
        },
        bottomBar = {
            if (showBotBars) {
                when (currentRoute) {

                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            EcommerceNavGraph(navController)
        }
    }
}