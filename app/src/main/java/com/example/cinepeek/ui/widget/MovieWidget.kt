package com.example.cinepeek.ui.widget

import android.annotation.SuppressLint
import androidx.compose.ui.unit.dp
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.action.clickable
import androidx.glance.layout.*
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import com.example.cinepeek.R
import com.example.cinepeek.MainActivity
import androidx.glance.action.actionStartActivity

class MovieWidget : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            MovieWidgetContent()
        }
    }
}

@SuppressLint("RestrictedApi")
@Composable
fun MovieWidgetContent() {
    Box(
        modifier = GlanceModifier
            .fillMaxSize()
            .background(ColorProvider(R.color.widget_background))
            .padding(12.dp)
            .clickable(actionStartActivity<MainActivity>()), // opens app on tap
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                provider = ImageProvider(R.drawable.cinepeek_icon),
                contentDescription = "CinePeek Logo",
                modifier = GlanceModifier.size(64.dp)
            )
            Spacer(modifier = GlanceModifier.height(8.dp))
            Text(
                text = "🎬 CinePeek",
                style = TextStyle(color = ColorProvider(R.color.widget_text_white))
            )
            Spacer(modifier = GlanceModifier.height(4.dp))
            Text(
                text = "Tap to explore movies",
                style = TextStyle(color = ColorProvider(R.color.widget_text_gray))
            )
        }
    }
}
