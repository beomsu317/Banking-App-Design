package com.bs.banking_app_design.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bs.banking_app_design.R
import com.bs.banking_app_design.ui.theme.LightGrey2
import com.bs.banking_app_design.ui.theme.PrimaryGrey
import com.bs.banking_app_design.ui.theme.PrimaryRed
import com.bs.banking_app_design.ui.theme.poppins

@Composable
fun SplashScreen(
    onNavigate: () -> Unit
) {
    Column {
        Logo()
        Hero()
        NextButton(onNavigate)
        SplashImage()
    }
}

@Composable
fun NextButton(
    onNavigate: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .size(70.dp)
            .padding(top = 10.dp, end = 20.dp),
        horizontalArrangement = Arrangement.End
    ) {
        FloatingActionButton(
            onClick = {
                onNavigate()
            },
            modifier = Modifier
                .size(60.dp),
            backgroundColor = PrimaryGrey,
        ) {
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "",
                tint = Color.White
            )
        }
    }
}

@Composable
fun SplashImage() {
    Image(
        painter = painterResource(id = R.drawable.splash_image),
        contentDescription = "",
        alignment = Alignment.BottomCenter,
        modifier = Modifier
            .padding(vertical = 60.dp, horizontal = 5.dp)
    )
}

@Composable
fun Hero() {
    Column(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        Text(
            text = buildAnnotatedString {
                append("Finance Your\n")
                pushStyle(
                    SpanStyle(
                        color = PrimaryRed,
                        fontFamily = poppins,
                        textDecoration = TextDecoration.Underline
                    )
                )
                append("Balance")
                pop()
                append(" Sheet")
            },
            fontSize = 46.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 50.sp,
            color = PrimaryGrey,
        )

        Text(
            text = buildAnnotatedString {
                append("Best payment method, connects your money to your ")
                pushStyle(
                    SpanStyle(
                        color = PrimaryGrey,
                        fontWeight = FontWeight.Bold,
                        fontFamily = poppins
                    )
                )
                append("friends and brands")
            },
            color = LightGrey2,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun Logo() {
    Row(
        modifier = Modifier.padding(20.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic__square),
            contentDescription = "",
            tint = Color.Unspecified,
        )

        Text(
            text = "Beenkio",
            modifier = Modifier
                .padding(start = 12.dp),
            fontSize = 16.sp,
            fontFamily = poppins,
            color = Color.DarkGray
        )
    }
}
