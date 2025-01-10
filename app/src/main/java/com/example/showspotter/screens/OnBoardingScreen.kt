package com.example.showspotter.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.showspotter.R

@SuppressLint("SuspiciousIndentation")
@Composable
fun OnBoarding(goToLogInScreen: () -> Unit,goToSignUpScreen:()->Unit) {
    val colorList = listOf(Color(0xFF0F2027),Color(0xFF203A43),Color(0xFF2c5364))
        Pager()
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .border(width = 2.dp,Color.Black,RoundedCornerShape(10.dp)),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(text="WELCOME!",
                        modifier = Modifier.fillMaxWidth().padding(start=25.dp,top=10.dp),
                        fontSize = 25.sp,
                        fontFamily = FontFamily(Font(R.font.interbold)),
                        color = Color.White,
                        textAlign = TextAlign.Start,
                    )

                    Button(
                        onClick = {
                                goToSignUpScreen()
                        },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .padding(start = 20.dp, end = 20.dp, top = 15.dp)
                            .fillMaxWidth()
                            .height(60.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF1b059c),
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "Register", fontSize = 14.sp)
                    }

                    Button(
                        onClick = {
                            goToLogInScreen()
                        },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .padding(start = 20.dp, end = 20.dp, top = 25.dp)
                            .fillMaxWidth()
                            .height(60.dp),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color(0xFF1b059c),
                            containerColor = Color.White
                        ),
                        border = BorderStroke(width = 0.2.dp, color = Color.Gray)
                    ) {
                        Text(text = "Log in")
                    }
                }
    }
}