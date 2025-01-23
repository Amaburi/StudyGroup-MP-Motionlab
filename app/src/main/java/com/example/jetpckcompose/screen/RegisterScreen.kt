package com.example.jetpckcompose.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jetpckcompose.R
import com.google.firebase.auth.FirebaseAuth

@Composable
fun RegisterScreen(navController: NavController) {
    val context = LocalContext.current
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = colorResource(R.color.black_primarybg),
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.motion),
                    contentDescription = "App Logo",
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Re:Live",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = colorResource(R.color.greengacor)
                    )
                )

                Spacer(modifier = Modifier.height(32.dp))

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Username") },
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = colorResource(R.color.greengacor),
                        unfocusedIndicatorColor = Color.Gray,
                    ),
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = colorResource(R.color.greengacor),
                        unfocusedIndicatorColor = Color.Gray,
                    ),
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = colorResource(R.color.greengacor),
                        unfocusedIndicatorColor = Color.Gray,
                    ),
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val icon =
                            if (passwordVisible) R.drawable.eye_clsd else R.drawable.eye_opn
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                painter = painterResource(id = icon),
                                contentDescription = "Toggle Password Visibility"
                            )
                        }
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = gender,
                    onValueChange = { gender = it },
                    label = { Text("Gender (Male | Female)") },
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = colorResource(R.color.greengacor),
                        unfocusedIndicatorColor = Color.Gray,
                    ),
                )

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        Toast.makeText(
                            context,
                            "Registration Successful!",
                            Toast.LENGTH_SHORT
                        ).show()
                        val auth = FirebaseAuth.getInstance()
                        if (email.isBlank() || password.isBlank()) {
                            Toast.makeText(
                                context,
                                "Email or password cannot be empty",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            auth.createUserWithEmailAndPassword(email, password)
                                .addOnCompleteListener { task ->
                                    if (task.isSuccessful) {
                                        Toast.makeText(
                                            context,
                                            "Login Successful!",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                        navController.navigate(com.example.jetpckcompose.LoginScreen)
                                    } else {
                                        Toast.makeText(
                                            context,
                                            "Error: ${task.exception?.message}",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                        }

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.greengacor),
                        contentColor = Color.White
                    ),
                ) {
                    Text(text = "Register", style = MaterialTheme.typography.bodyLarge)
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Already have an account? Navigation to Login
                TextButton(onClick = { navController.navigate(com.example.jetpckcompose.LoginScreen) }) {
                    Text(
                        text = "Already have an account? Login",
                        color = colorResource(R.color.greengacor),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    )
}

@Preview
@Composable
fun RegisterScreen() {
    val context = LocalContext.current
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.motion),
                    contentDescription = "App Logo",
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Register",
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = colorResource(R.color.greengacor)
                    )
                )

                Spacer(modifier = Modifier.height(32.dp))

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Username") },
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = colorResource(R.color.greengacor),
                        unfocusedIndicatorColor = Color.Gray,
                    ),
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = colorResource(R.color.greengacor),
                        unfocusedIndicatorColor = Color.Gray,
                    ),
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = colorResource(R.color.greengacor),
                        unfocusedIndicatorColor = Color.Gray,
                    ),
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val icon =
                            if (passwordVisible) R.drawable.eye_clsd else R.drawable.eye_opn
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                painter = painterResource(id = icon),
                                contentDescription = "Toggle Password Visibility"
                            )
                        }
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = gender,
                    onValueChange = { gender = it },
                    label = { Text("Gender (Male | Female)") },
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = colorResource(R.color.greengacor),
                        unfocusedIndicatorColor = Color.Gray,
                    ),
                )

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        Toast.makeText(
                            context,
                            "Registration Successful!",
                            Toast.LENGTH_SHORT
                        ).show()

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.greengacor),
                        contentColor = Color.White
                    ),
                ) {
                    Text(text = "Register", style = MaterialTheme.typography.bodyLarge)
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Already have an account? Navigation to Login
                TextButton(onClick = { }) {
                    Text(
                        text = "Already have an account? Login",
                        color = colorResource(R.color.greengacor),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    )
}
