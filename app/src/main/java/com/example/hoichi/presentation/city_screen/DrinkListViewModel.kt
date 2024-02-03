package com.example.hoichi.presentation.city_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hoichi.common.Resource
import com.example.hoichi.domain.data.Drink
import com.example.hoichi.domain.usecases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DrinkListViewModel @Inject constructor(
    private val useCases: UseCases,
) : ViewModel() {

    private val _state = mutableStateOf(DrinkListState())
    val state: State<DrinkListState> get() = _state

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private var searchJob: Job? = null

    private fun getCities(filmName: String) {
        // Cancel the previous search job to avoid unnecessary API calls
        searchJob?.cancel()

        if (filmName.isNotEmpty()) {
            // Delay the API call using debounce (e.g., 300 milliseconds)
            searchJob = viewModelScope.launch {
                delay(300)
                performSearch(filmName)
            }
        } else {
            // Handle the case when the search query is empty
            _state.value = DrinkListState(drinks = emptyList())
        }
    }


    private fun performSearch(drinkName: String) {
        if (drinkName.isNotEmpty()) {
            useCases.getDrinksUseCase.setDrinkName(drinkName)
        }

        useCases.getDrinksUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = DrinkListState(drinks = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value = DrinkListState(error = result.message ?: "Unexpected Error")
                }

                is Resource.Loading -> {
                    _state.value = DrinkListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)

    }

    // This fn will be called from UI if user types something
    fun onSearchTextChange(text: String) {
        _searchText.value = text

        if (text.isEmpty()) {
            _state.value = DrinkListState(drinks = listOf())
        } else {
            getCities(text)
        }
    }

    fun searchDrink(drinkList: List<Drink>): List<Drink> {
        val list = if (searchText.value.isEmpty()) {
            drinkList
        } else {
            drinkList.filter {
                it.doesMatchSearchQuery(searchText.value)
            }
        }
        return list
    }
}
