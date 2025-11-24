package com.example.cinepeek

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cinepeek.ui.MovieViewModel
import com.example.cinepeek.ui.components.AppLogo
import com.example.cinepeek.ui.screens.MovieDetailsScreen
import com.example.cinepeek.ui.screens.MainScreen
import com.example.cinepeek.ui.theme.CinePeekTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("StateFlowValueCalledInComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = MovieViewModel()
        setContent {
            val navController = rememberNavController()
            var isDarkMode by remember { mutableStateOf(false) }
            CinePeekTheme {
                AppLogo()
                NavHost(navController = navController, startDestination = "main") {
                    composable("main") {
                        MainScreen(viewModel = viewModel,
                            navController = navController,
                            isDarkMode = isDarkMode,
                            onToggleTheme = { isDarkMode = it})
                    }
                    composable("details/{movieId}") { backStackEntry ->
                        val movieId = backStackEntry.arguments?.getString("movieId")?.toInt()
                        val movie = viewModel.movies.value.firstOrNull { it.id == movieId }
                        movie?.let {
                            MovieDetailsScreen(it, darkTheme = isDarkMode)
                        }
                    }
                }
            }
        }
    }
}
