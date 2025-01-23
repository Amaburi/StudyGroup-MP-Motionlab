package com.example.jetpckcompose.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jetpckcompose.utils.BottomNavigationComponent
import com.example.jetpckcompose.R


val customFont = FontFamily(
    Font(R.font.playfair)
)
val customFont2 = FontFamily(
    Font(R.font.oswald)
)
val Poppins = FontFamily(
    Font(R.font.poppins)
)
val leagueSpartan = FontFamily(
    Font(R.font.leaguespartan)
)
@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = colorResource(id = R.color.black_primarybg),
        bottomBar = { BottomNavigationComponent(navController = navController) },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Spacer(modifier = Modifier.height(6.dp))
                Text(text ="PROFILE", style = TextStyle(fontFamily = Poppins, fontSize = 35.sp, fontWeight = FontWeight.Bold, color = Color.White))

                // Profile Picture Section
                Box(
                    modifier = Modifier
                        .size(150.dp)
                        .padding(top = 20.dp)
                        .clip(CircleShape)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.olsen_org),
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(CircleShape)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))


                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Hey, Olsen \uD83D\uDC4B",
                        style = TextStyle(fontFamily = leagueSpartan),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                // Settings Section
                SettingsOption(title = "Elizabeth Olsen", "Full Name")
                SettingsOption(title = "Olsen", "Nickname")
                SettingsOption(title = "Elizabeth@gmail.com", "Email")

                Spacer(modifier = Modifier.height(16.dp))

                // Logout Button
                Button(
                    onClick = {
                        navController.navigate(com.example.jetpckcompose.LoginScreen)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.greengacor),
                        contentColor = Color.White
                    ),
                ) {
                    Text(text = "LOGOUT", color = Color.White, fontWeight = FontWeight.Bold)
                }
            }
        }
    )
}

@Composable
fun SettingsOption(title: String, subtitle: String) {
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.fillMaxWidth().offset(x = 15.dp)
    ){
        Text(text = subtitle, color = colorResource(R.color.greengacor),style = TextStyle(fontFamily = Poppins,fontSize = 21.sp, fontWeight = FontWeight.Bold))
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = title, color = colorResource(R.color.brownsugar),style = TextStyle(fontSize = 20.sp, fontFamily = leagueSpartan, fontWeight = FontWeight.SemiBold))
        }
    }
}
