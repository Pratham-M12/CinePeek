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
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.appwidget.cornerRadius
import androidx.glance.unit.ColorProvider
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.layout.size
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import com.example.cinepeek.MainActivity
import com.example.cinepeek.R

class MovieMediumWidget : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            MovieMediumContent()
        }
    }
}

@SuppressLint("RestrictedApi")
@Composable
fun MovieMediumContent() {
    Row(
        modifier = GlanceModifier
            .background(ColorProvider(R.color.widget_card_background))
            .padding(12.dp)
            .cornerRadius(12.dp)
            .clickable(actionStartActivity<MainActivity>()),
        verticalAlignment = androidx.glance.layout.Alignment.CenterVertically
    ) {
        // Poster with bigger size
        Image(
            provider = ImageProvider(R.drawable.poster_interstellar),
            contentDescription = "Movie Poster",
            modifier = GlanceModifier
                .size(120.dp)
                .cornerRadius(8.dp)
                .padding(end = 12.dp)
        )

        // Movie Info Column
        Column {
            Text(
                text = "Interstellar",
                style = TextStyle(ColorProvider(R.color.widget_text_primary))
            )

            Spacer(modifier = GlanceModifier.height(4.dp))

            Text(
                text = "⭐ 8.6 / 10",
                style = TextStyle(ColorProvider(R.color.widget_text_secondary))
            )

            Spacer(modifier = GlanceModifier.height(4.dp))

            Text(
                text = "2014 | Sci-Fi / Adventure",
                style = TextStyle(ColorProvider(R.color.widget_text_secondary))
            )
        }
    }
}


class MovieMediumWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = MovieMediumWidget()
}
