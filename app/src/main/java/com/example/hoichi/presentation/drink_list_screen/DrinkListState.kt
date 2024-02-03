package com.example.hoichi.presentation.drink_list_screen

import com.example.hoichi.domain.data.Drink

data class DrinkListState(
    val isLoading: Boolean = false,
    val drinks: List<Drink> = emptyList(),
    val error: String = ""
)
