package com.everallity.ecommerceandroidapp.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.everallity.ecommerceandroidapp.features.auth.presentation.LoginScreen
import com.everallity.ecommerceandroidapp.features.catalog.presentation.CatalogScreen

@Composable
fun EcommerceNavGraph(navController: NavHostController, startDestination: String) {

    NavHost(navController = navController, startDestination = "login_screen") {
        composable("catalog_screen") {
            CatalogScreen(
                onProductClick = { productId ->
                 /*   navController.navigate("product_detail/$productId")*/
                }
            )
        }

        composable("login_screen"){
            LoginScreen(
                onNavigateToHome = {
                    navController.navigate("catalog_screen") {
                        popUpTo(route = "login_screen") { inclusive = true }
                    }
                }
            )
        }
    }
}