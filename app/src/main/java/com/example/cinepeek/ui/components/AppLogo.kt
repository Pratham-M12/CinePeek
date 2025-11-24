package com.example.cinepeek.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.cinepeek.R

@Composable
fun AppLogo() {
    Image(
        painter = painterResource(id = R.drawable.cinepeek_icon),
        contentDescription = "CinePeek Logo",
        modifier = Modifier
            .height(72.dp)
            .width(72.dp),
        contentScale = ContentScale.Fit
    )
}
