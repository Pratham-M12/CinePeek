package com.example.cinepeek.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NightsStay
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cinepeek.data.model.Movie
import com.example.cinepeek.ui.MovieViewModel
import com.example.cinepeek.ui.components.MovieItem
import com.example.cinepeek.ui.theme.CinePeekTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MovieViewModel, navController: NavController, isDarkMode: Boolean, onToggleTheme: (Boolean) -> Unit) {
    val icon = if (isDarkMode) Icons.Default.NightsStay else Icons.Default.WbSunny
    val movies by viewModel.movies.collectAsState()
    CinePeekTheme(darkTheme = isDarkMode){
        Scaffold(
            topBar = { TopAppBar(title = { Text("🎬 CinePeek") },
                actions = {IconButton(onClick = { onToggleTheme(!isDarkMode) }){
                    Icon(imageVector = if (isDarkMode) Icons.Default.NightsStay else Icons.Default.WbSunny, contentDescription = "Toggle Theme", tint = if (isDarkMode) Color.Yellow else Color(0xFFFFA500))
                }
                }) }
        ) { padding ->
            Box(modifier = Modifier.padding(padding)) {
                if (movies.isNotEmpty()) {
                    LazyVerticalGrid(
                        columns = GridCells.Adaptive(150.dp),
                        contentPadding = PaddingValues(8.dp)
                    ) {
                        items(movies) { movie ->
                            MovieItem(movie) { navController.navigate("details/${movie.id}") }
                        }
                    }
                } else {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = androidx.compose.ui.Alignment.Center
                    ) {
                        Text("Loading movies…", style = MaterialTheme.typography.bodyLarge)
                    }
                }
            }
        }
    }
}
