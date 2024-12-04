package com.example.jetpckcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


import com.example.jetpckcompose.ui.theme.JetpckcomposeTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpckcomposeTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = LoginScreen) {
                    composable<LoginScreen> {
                        LoginScreen(navController)
                    }
                    composable<HomeScreen> {
                        HomeScreen(navController)
                    }
                    composable<RegisterScreen> {
                        RegisterScreen(navController)
                    }
                }
            }
        }
    }
}


@Serializable
object LoginScreen

@Serializable
object HomeScreen

@Serializable
object RegisterScreen