package com.example.hoichi.presentation.drink_details_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hoichi.domain.data.Drink
import com.example.hoichi.presentation.drink_list_screen.components.DrinkListItem

@Composable
fun DrinkDetailScreen(
    drink: Drink
) {
    Column(modifier = Modifier.fillMaxSize()) {
        DrinkListItem(drink = drink, onItemClicked = {})

        Spacer(Modifier.height(6.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = drink.drinkInstructions,
                style = TextStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.Magenta
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                modifier = Modifier.padding(8.dp),
                text = "Drink Category : ${drink.drinkCategory}",
                style = TextStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.Magenta
                )
            )
        }
    }
}