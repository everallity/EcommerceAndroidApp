package com.everallity.ecommerceandroidapp.features.catalog.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.catalogGraph(
    onProductClick: (Int) -> Unit
) {
    composable(route = "catalog") {
        CatalogScreen(onProductClick = onProductClick)
    }
}