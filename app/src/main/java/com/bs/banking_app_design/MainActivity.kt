package com.bs.banking_app_design

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bs.banking_app_design.ui.screens.HomeScreen
import com.bs.banking_app_design.ui.screens.SplashScreen
import com.bs.banking_app_design.ui.theme.BankingAppDesignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankingAppDesignTheme {
                Surface(
                    color = Color.White,
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "splash_screen") {
                        composable("splash_screen") {
                            SplashScreen(
                                onNavigate = {
                                    navController.navigate("home_screen")
                                }
                            )
                        }
                        composable("home_screen") {
                            HomeScreen()
                        }
                    }
                }
            }
        }
    }
}
