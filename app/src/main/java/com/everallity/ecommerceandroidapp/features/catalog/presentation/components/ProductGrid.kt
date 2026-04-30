package com.everallity.ecommerceandroidapp.features.catalog.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.everallity.ecommerceandroidapp.core.ui.theme.EcommerceAndroidAppTheme
import com.everallity.ecommerceandroidapp.features.catalog.domain.Product

@Composable
fun ProductGridList(
    products: List<Product>,
    onProductClick: (Int) -> Unit
    ) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
            .background(Color(0xFFF5F5F5)),
        contentPadding = PaddingValues(10.dp)
    ) {
        items(products) { product ->
            ProductItemCard(
                product = product,
                onProductClick = { onProductClick(product.id) }
                )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewProductGrid() {
    val mockProducts = listOf(
        Product(1, "PS5 Console", "Console", "url", "499", brand = "Sony"),
        Product(2, "DualSense Edge", "Controller", "url", "199", brand = "Sony"),
        Product(3, "Spider-Man 2", "Game", "url", "69", brand = "Insomniac"),
        Product(4, "Pulse 3D Headset", "Audio", "url", "99", brand = "Sony"),
        Product(5, "Charging Station", "Accessory", "url", "29", brand = "Sony"),
        Product(6, "PS5 Cover Red", "Accessory", "url", "55", brand = "Sony")
    )

    EcommerceAndroidAppTheme {
        ProductGridList(products = mockProducts) {}
    }
}