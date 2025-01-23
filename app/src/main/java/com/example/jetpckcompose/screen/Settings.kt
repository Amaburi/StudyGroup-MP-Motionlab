package com.example.jetpckcompose.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpckcompose.R
import com.example.jetpckcompose.utils.BottomNavigationComponent

@Composable
fun SettingsScreen(navController: NavController) {
    var notificationsEnabled by remember { mutableStateOf(false) }
    var soundEnabled by remember { mutableStateOf(false) }
    var vibrateEnabled by remember { mutableStateOf(false) }
    var remainderEnabled by remember { mutableStateOf(false) }

    var darkModeEnabled by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = colorResource(R.color.black_primarybg),
        bottomBar = {
            BottomNavigationComponent(navController = navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Settings",
                style = MaterialTheme.typography.headlineLarge,
                color = colorResource(android.R.color.white),
                modifier = Modifier.padding(16.dp)
            )

            // Notifications Setting
            SettingItem(title = "General Notification") {
                Switch(
                    checked = notificationsEnabled,
                    onCheckedChange = { notificationsEnabled = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = colorResource(android.R.color.white),
                        uncheckedThumbColor = colorResource(android.R.color.white),
                        checkedTrackColor = colorResource(android.R.color.white).copy(alpha = 0.5f),
                        uncheckedTrackColor = colorResource(android.R.color.white).copy(alpha = 0.5f)
                    )
                )
            }
            SettingItem(title = "Sound") {
                Switch(
                    checked = soundEnabled,
                    onCheckedChange = { soundEnabled = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = colorResource(android.R.color.white),
                        uncheckedThumbColor = colorResource(android.R.color.white),
                        checkedTrackColor = colorResource(android.R.color.white).copy(alpha = 0.5f),
                        uncheckedTrackColor = colorResource(android.R.color.white).copy(alpha = 0.5f)
                    )
                )
            }
            SettingItem(title = "Vibrate") {
                Switch(
                    checked = vibrateEnabled,
                    onCheckedChange = { vibrateEnabled = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = colorResource(android.R.color.white),
                        uncheckedThumbColor = colorResource(android.R.color.white),
                        checkedTrackColor = colorResource(android.R.color.white).copy(alpha = 0.5f),
                        uncheckedTrackColor = colorResource(android.R.color.white).copy(alpha = 0.5f)
                    )
                )
            }
            SettingItem(title = "Remainder") {
                Switch(
                    checked = remainderEnabled,
                    onCheckedChange = { remainderEnabled = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = colorResource(android.R.color.white),
                        uncheckedThumbColor = colorResource(android.R.color.white),
                        checkedTrackColor = colorResource(android.R.color.white).copy(alpha = 0.5f),
                        uncheckedTrackColor = colorResource(android.R.color.white).copy(alpha = 0.5f)
                    )
                )
            }

            // Dark Mode Setting
            SettingItem(title = "Dark Mode") {
                Switch(
                    checked = darkModeEnabled,
                    onCheckedChange = { darkModeEnabled = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = colorResource(android.R.color.white),
                        uncheckedThumbColor = colorResource(android.R.color.white),
                        checkedTrackColor = colorResource(android.R.color.white).copy(alpha = 0.5f),
                        uncheckedTrackColor = colorResource(android.R.color.white).copy(alpha = 0.5f)
                    )
                )
            }
        }
    }
}

@Composable
fun SettingItem(title: String, content: @Composable RowScope.() -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = title, style = MaterialTheme.typography.bodyLarge, color = colorResource(android.R.color.white))
        content()
    }
}