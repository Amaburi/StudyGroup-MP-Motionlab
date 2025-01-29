package com.example.apijtpck

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.apijtpck.screens.PokemonDetailScreen
import com.example.apijtpck.screens.PokemonListScreen
import com.example.apijtpck.ui.theme.ApijtpckTheme
import com.example.apijtpck.utils.PokemonViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApijtpckTheme {
                PokemonApp()
            }
        }
    }
}

@Composable
fun PokemonApp() {
    val navController = rememberNavController()
    val viewModel: PokemonViewModel = viewModel()

    NavHost(navController, startDestination = "list") {
        composable("list") { PokemonListScreen(navController, viewModel) }
        composable("details/{pokemonName}",
            arguments = listOf(navArgument("pokemonName") { type = NavType.StringType })
        ) { backStackEntry ->
            val pokemonName = backStackEntry.arguments?.getString("pokemonName") ?: ""
            PokemonDetailScreen(pokemonName, navController)
        }
    }
}
