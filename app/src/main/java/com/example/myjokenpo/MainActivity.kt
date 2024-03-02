package com.example.myjokenpo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myjokenpo.ui.theme.Purple80


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "main"){
                composable(route = "main"){
                    Menu(navController)
                }
                composable(route = "battle/{choose}"){ entry ->
                    entry.arguments?.getString("choose")?.let{choose ->
                        Battle(choose = choose, navController)
                    }
                }
            }
        }
    }
}
