package com.example.cinepeek.ui.widget

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.action.actionStartActivity
import androidx.glance.action.clickable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.unit.ColorProvider
import androidx.glance.layout.Column
import androidx.glance.layout.padding
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import com.example.cinepeek.MainActivity
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.appwidget.cornerRadius
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.height
import androidx.glance.layout.size
import com.example.cinepeek.R

class MovieSmallWidget : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            WidgetContent()
        }
    }
}

@SuppressLint("RestrictedApi")
@Composable
fun WidgetContent() {
    Column(
        modifier = GlanceModifier
            .background(
                ColorProvider(R.color.widget_card_background)
            )
            .padding(16.dp)
            .cornerRadius(12.dp)
            .clickable(actionStartActivity<MainActivity>()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo
        Image(
            provider = ImageProvider(R.drawable.cinepeek_icon),
            contentDescription = "CinePeek Logo",
            modifier = GlanceModifier
                .size(64.dp)
                .padding(bottom = 8.dp)
        )

        // App Name
        Text(
            text = "🎬 CinePeek",
            style = TextStyle(ColorProvider(R.color.widget_text_primary))
        )

        Spacer(modifier = GlanceModifier.height(4.dp))

        // Featured Movie
        Text(
            text = "Top Movie: Interstellar",
            style = TextStyle(color = ColorProvider(R.color.widget_text_secondary))
        )
    }
}


class MovieSmallWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = MovieSmallWidget()
}
