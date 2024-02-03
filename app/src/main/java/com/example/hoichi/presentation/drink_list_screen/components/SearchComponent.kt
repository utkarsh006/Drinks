package com.example.hoichi.presentation.drink_list_screen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.hoichi.R
import com.example.hoichi.presentation.drink_list_screen.DrinkListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchComponent(
    searchText: String,
    isSearching: Boolean,
    viewModel: DrinkListViewModel = hiltViewModel()
) {
    SearchBar(
        query = searchText, // text showed on SearchBar
        onQueryChange = viewModel::onSearchTextChange, // update the value of searchText
        onSearch = viewModel::onSearchTextChange, // the callback to be invoked when the input service triggers the ImeAction.Search action
        active = isSearching, // whether the user is searching or not
        onActiveChange = {}, // the callback to be invoked when this search bar's active state is changed
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        placeholder = {
            TextComponent(
                text = stringResource(id = R.string.search_drink),
                fontWeight = FontWeight.Normal,
                fontSize = 14f,
                color = Color.DarkGray
            )
        },

        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "",
                tint = Color.Red
            )
        },

        trailingIcon = {
            if (searchText.isNotEmpty()) {
                IconButton(onClick = { viewModel.onSearchTextChange("") }) {
                    Icon(
                        imageVector = Icons.Outlined.Close,
                        contentDescription = "",
                        tint = Color.Red
                    )
                }
            }
        },
        shape = RoundedCornerShape(10.dp)
    ) {
    }
}