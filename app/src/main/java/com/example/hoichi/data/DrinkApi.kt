package com.example.hoichi.data

import retrofit2.http.GET
import retrofit2.http.Query

interface DrinkApi {

    // API LINK: https://www.thecocktaildb.com/api/json/v1/1/search.php?s=mojito
    @GET("api/json/v1/1/search.php")
    suspend fun getCity(
        @Query("s") drinkName: String
    ): Drink
}
