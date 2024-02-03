package com.example.hoichi.data

import com.example.hoichi.domain.data.Drink

data class DrinkDTO(
    val dateModified: String,
    val idDrink: String,
    val strAlcoholic: String,
    val strCategory: String,
    val strCreativeCommonsConfirmed: String,
    val strDrink: String,
    val strDrinkAlternate: Any,
    val strDrinkThumb: String,
    val strGlass: String,
    val strIBA: String,
    val strImageAttribution: String,
    val strImageSource: String,
    val strIngredient1: String,
    val strIngredient10: Any,
    val strIngredient11: Any,
    val strIngredient12: Any,
    val strIngredient13: Any,
    val strIngredient14: Any,
    val strIngredient15: Any,
    val strIngredient2: String,
    val strIngredient3: String,
    val strIngredient4: String,
    val strIngredient5: String,
    val strIngredient6: String,
    val strIngredient7: String,
    val strIngredient8: Any,
    val strIngredient9: Any,
    val strInstructions: String,
    val strInstructionsDE: String,
    val strInstructionsES: Any,
    val strInstructionsFR: Any,
    val strInstructionsIT: String,
    val strMeasure1: String,
    val strMeasure10: Any,
    val strMeasure11: Any,
    val strMeasure12: Any,
    val strMeasure13: Any,
    val strMeasure14: Any,
    val strMeasure15: Any,
    val strMeasure2: String,
    val strMeasure3: String,
    val strMeasure4: String,
    val strMeasure5: String,
    val strMeasure6: String,
    val strMeasure7: String,
    val strMeasure8: Any,
    val strMeasure9: Any,
    val strTags: String,
    val strVideo: Any
)

fun DrinkDTO.toDrink(): Drink {
    return Drink(
        drinkId = idDrink,
        drinkName = strDrink,
        drinkInstructions = strInstructions,
        drinkCategory = strCategory,
        drinkImage = strDrinkThumb
    )
}