package com.example.jetpckcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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

@Composable
fun HomeScreen(navController: NavController) {
    var isYellow by remember { mutableStateOf(false) }
    Scaffold(modifier = Modifier.fillMaxSize(),
        content = {
            Image(
                modifier = Modifier
                    .size(100.dp)
                    .offset(x = 290.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Motion Logo",
            )
            Text(
                text = "Welcome To Re:Live",
                textAlign = TextAlign.Center,
                modifier = Modifier.offset(y = 220.dp, x = 38.dp),
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = colorResource(R.color.greengacor)
                )
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(210.dp)
                        .padding(12.dp)
                        .clip(RoundedCornerShape(66.dp)),
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 16.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .width(140.dp)
                                    .height(140.dp)
                                    .clip(RoundedCornerShape(16.dp))
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.manabstract),
                                    contentDescription = "Exercise Image",
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .padding(start = 16.dp)
                                    .align(Alignment.CenterVertically)
                            ) {
                                Text(
                                    text = "Halo!",
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "Lorem Ipsum Dolor sit amet, consectetur adipiscing elit",
                                    color = Color.Gray
                                )
                            }
                        }


                        Icon(
                            painter = painterResource(
                                id = if (isYellow) R.drawable.staryellow else R.drawable.starr
                            ),
                            contentDescription = "Star Icon",
                            tint = Color.Yellow,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(8.dp)
                                .size(40.dp)
                                .offset((-20).dp)
                                .clickable {
                                    isYellow = !isYellow
                                }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.greengacor),
                        contentColor = Color.White
                    ),
                    onClick = {
                        navController.navigateUp()
                    }
                ) {
                    Text("Logout")
                }
            }
        }
    )
}

@Preview
@Composable
fun HomeScreenPreview() {
    Scaffold(modifier = Modifier.fillMaxSize(),
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(color = Color.LightGray)
                        .padding(12.dp),
                ) {
                    Row(modifier = Modifier.fillMaxSize()) {
                        Box(
                            modifier = Modifier
                                .size(76.dp)
                                .background(color = Color.Gray)
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Column {
                            Text(
                                "Title",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.SemiBold
                            )

                            Text("Description")
                        }

                    }
                }

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {

                    }
                ) {
                    Text("Logout")
                }
            }
        }
    )
}