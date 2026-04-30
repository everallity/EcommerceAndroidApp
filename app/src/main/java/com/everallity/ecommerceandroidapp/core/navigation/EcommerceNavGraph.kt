package com.everallity.ecommerceandroidapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.everallity.ecommerceandroidapp.features.catalog.presentation.CatalogScreen

@Composable
fun EcommerceNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "catalog_screen") {
        composable(route = "catalog_screen") {
            CatalogScreen(
                onProductClick = { productId ->
                 /*   navController.navigate("product_detail/$productId")*/
                }
            )
        }
    }
}