package com.example.jetpckcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpckcompose.screen.HomeScreen
import com.example.jetpckcompose.screen.LoginScreen
import com.example.jetpckcompose.screen.ProfileScreen
import com.example.jetpckcompose.screen.RegisterScreen
import com.example.jetpckcompose.screen.SettingsScreen


import com.example.jetpckcompose.ui.theme.JetpckcomposeTheme
import com.google.firebase.FirebaseApp
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
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
                    composable<ProfileScreen> {
                        ProfileScreen(navController)
                    }
                    composable<SettingsScreen> {
                        SettingsScreen(navController)
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

@Serializable
object ProfileScreen

@Serializable
object SettingsScreen