package com.example.hoichi

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.hoichi.domain.data.Drink
import com.example.hoichi.presentation.drink_list_screen.DrinkListScreen
import com.example.hoichi.presentation.drink_details_screen.DrinkDetailScreen
import com.google.gson.Gson

@Composable
fun AppNavGraph() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = NavScreen.DrinkListScreen.route
        ) {
            composable(
                route = NavScreen.DrinkListScreen.route
            ) {
                DrinkListScreen(navController)
            }

            composable(
                route = NavScreen.DrinkDetailScreen.route + "?drink={drink}",
                arguments = listOf(
                    navArgument("drink") {
                        type = NavType.StringType
                    }
                )
            ) {
                val drink = Gson().fromJson(it.arguments?.getString("drink"), Drink::class.java)
                DrinkDetailScreen(drink)
            }
        }
    }
}