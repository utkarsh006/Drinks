package com.example.hoichi.data.repository

import com.example.hoichi.data.DrinkApi
import com.example.hoichi.data.DrinkDTO
import com.example.hoichi.domain.repository.DrinkRepository
import javax.inject.Inject

class DrinkRepoImpl @Inject constructor(
    private val api: DrinkApi
) : DrinkRepository {
    override suspend fun getDrinks(drinkName: String): List<DrinkDTO> {
        val response = api.getCity(drinkName)
        return response.drinks
    }
}