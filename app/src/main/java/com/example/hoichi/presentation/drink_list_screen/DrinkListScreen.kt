package com.example.hoichi.presentation.drink_list_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.hoichi.NavScreen
import com.example.hoichi.R
import com.example.hoichi.presentation.drink_list_screen.components.DrinkListItem
import com.example.hoichi.presentation.drink_list_screen.components.SearchComponent
import com.example.hoichi.presentation.drink_list_screen.components.StaticComponent
import com.example.hoichi.presentation.drink_list_screen.components.TextComponent
import com.google.gson.Gson


@Composable
fun DrinkListScreen(
    navController: NavController,
    viewModel: DrinkListViewModel = hiltViewModel()
) {
    val state by viewModel.state
    val searchText by viewModel.searchText.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {

        TextComponent(
            text = stringResource(id = R.string.lets_eat),
            fontWeight = FontWeight.Bold,
            fontSize = 32f,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(18.dp))

        SearchComponent(searchText = searchText, isSearching = isSearching)

        StaticComponent()

        Spacer(modifier = Modifier.height(16.dp))

        val filteredList = viewModel.searchDrink(state.drinks)

        if (isSearching) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        } else {
            LazyColumn() {
                items(items = filteredList, key = { it.drinkName }) { drink ->
                    DrinkListItem(
                        drink = drink,
                        onItemClicked = {
                            val drinkString = Gson().toJson(drink)
                            navController.navigate(
                                NavScreen.DrinkDetailScreen.route + "?drink=$drinkString"
                            )
                        }
                    )
                    Divider()
                }
            }
        }

        // If an error occurs, display an error message
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
        }

        if (state.isLoading && !isSearching) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}