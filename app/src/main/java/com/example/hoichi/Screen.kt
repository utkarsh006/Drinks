package com.example.hoichi

sealed class NavScreen(val route: String) {
    object DrinkListScreen : NavScreen("meal_list_screen")
    object DrinkDetailScreen : NavScreen("meal_detail_screen")
}