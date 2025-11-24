package com.example.cinepeek.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.cinepeek.data.model.Movie
import com.example.cinepeek.ui.theme.CinePeekTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailsScreen(movie: Movie, darkTheme: Boolean) {
    CinePeekTheme(darkTheme = darkTheme) {
        Scaffold(
            topBar = { TopAppBar(title = { Text(text = movie.title ?: "Movie Details", style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold)) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface
                )
            ) }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = rememberAsyncImagePainter(movie.poster_path),
                    contentDescription = movie.title,
                    modifier = Modifier
                        .height(500.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    "Release Date: ${movie.release_date ?: movie.first_air_date ?: "N/A"}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text("Rating: ⭐ ${movie.vote_average}", style = MaterialTheme.typography.bodyMedium)
                movie.director?.let {
                    Text("Director: $it", style = MaterialTheme.typography.bodyMedium)
                }
                movie.actors?.let {
                    Text("Actors: $it", style = MaterialTheme.typography.bodyMedium)
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text("Overview:", style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold))
                Text(movie.overview ?: "No description available",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}
