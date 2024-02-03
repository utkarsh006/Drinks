package com.example.hoichi.domain.usecases

import com.example.hoichi.common.Resource
import com.example.hoichi.data.toDrink
import com.example.hoichi.domain.data.Drink
import com.example.hoichi.domain.repository.DrinkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetDrinksUseCase @Inject constructor(
    private val repository: DrinkRepository,
) {
    private var drinkName: String ?= null

    fun setDrinkName(drinkName: String){
        this.drinkName = drinkName
    }

    operator fun invoke(): Flow<Resource<List<Drink>>> = flow {
        try {
            emit(Resource.Loading())
            val drink = repository.getDrinks(drinkName!!).map { it.toDrink() }
            emit(Resource.Success(drink))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected Error Occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach Server"))
        }
    }
}