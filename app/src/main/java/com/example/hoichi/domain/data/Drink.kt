package com.example.hoichi.domain.data

data class Drink(
    val drinkId: String,
    val drinkName: String,
    val drinkInstructions: String,
    val drinkCategory: String,
    val drinkImage: String
) {
    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            drinkName,
            "${drinkName.first()}",
            "${drinkName.last()}",
        )
        return matchingCombinations.any() {
            it.contains(query, ignoreCase = true)
        }
    }
}