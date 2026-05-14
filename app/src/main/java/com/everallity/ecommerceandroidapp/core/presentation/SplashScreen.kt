package com.everallity.ecommerceandroidapp.core.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.everallity.ecommerceandroidapp.R

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color(0xFF73FF4A)),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier.size(150.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSplashScreen() {
    MaterialTheme{
        SplashScreen()
    }
}
