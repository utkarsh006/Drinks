package com.example.hoichi.domain.repository

import com.example.hoichi.data.DrinkDTO

interface DrinkRepository {
    suspend fun getDrinks(drinkName: String): List<DrinkDTO>

}