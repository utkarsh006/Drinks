package com.example.hoichi.di

import com.example.hoichi.common.Constants
import com.example.hoichi.data.DrinkApi
import com.example.hoichi.data.repository.DrinkRepoImpl
import com.example.hoichi.domain.repository.DrinkRepository
import com.example.hoichi.domain.usecases.GetDrinksUseCase
import com.example.hoichi.domain.usecases.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): DrinkApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DrinkApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDrinkRepository(drinkApi: DrinkApi): DrinkRepository {
        return DrinkRepoImpl(drinkApi)
    }

    @Provides
    @Singleton
    fun provideCityUseCase(cityRepository: DrinkRepository) : UseCases{
        return UseCases(
            getDrinksUseCase = GetDrinksUseCase(cityRepository),
        )
    }

}