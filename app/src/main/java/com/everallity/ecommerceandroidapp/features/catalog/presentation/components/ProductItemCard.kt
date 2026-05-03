package com.everallity.ecommerceandroidapp.features.catalog.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.everallity.ecommerceandroidapp.core.presentation.theme.EcommerceAndroidAppTheme
import com.everallity.ecommerceandroidapp.features.catalog.domain.Product

@Composable
fun ProductItemCard(
    product: Product,
    onProductClick: () -> Unit) {
    Card(
        onClick = onProductClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column {
            AsyncImage(
                model = product.imageUrl,
                contentDescription = product.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .padding(5.dp),
                contentScale = ContentScale.Fit
            )

            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 30.dp),
                thickness = 0.5.dp,
                color = Color.LightGray.copy(alpha = 1f)
            )

            Row(modifier = Modifier.fillMaxWidth()
                .padding(10.dp)) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .weight(1f)
                ) {
                    Text(
                        text = product.name,
                        style = MaterialTheme.typography.titleLarge,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = product.price,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color(0xFFEE4D2D),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = product.brand,
                        style = MaterialTheme.typography.labelLarge,
                        color = Color.Gray
                    )
                }

                OutlinedIconButton(
                    onClick = {},
                    modifier = Modifier.size(36.dp)
                        .align(Alignment.Bottom),
                    border = BorderStroke(1.dp, Color(0xFFEE4D2D)),
                    colors = IconButtonDefaults.outlinedIconButtonColors(
                        containerColor = Color.White,
                        contentColor = Color(0xFFEE4D2D)
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.AddShoppingCart,
                        contentDescription = "Add to Cart",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }


        }
    }


}

@Preview(showBackground = true)
@Composable
fun PreviewProductItemCard() {
    val dummyProduct = Product(1, "PS5 Console", "Console", "url", "499", brand = "Sony")
    EcommerceAndroidAppTheme {
        ProductItemCard(product = dummyProduct) {}
    }

}