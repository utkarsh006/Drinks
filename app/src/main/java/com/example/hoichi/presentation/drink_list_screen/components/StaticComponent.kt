package com.example.hoichi.presentation.drink_list_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.hoichi.R

@Composable
fun StaticComponent() {
    Spacer(modifier = Modifier.height(18.dp))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextComponent(
            text = stringResource(id = R.string.near),
            fontWeight = FontWeight.Bold,
            fontSize = 20f,
            color = Color.Black
        )

        TextComponent(
            text = stringResource(id = R.string.see),
            fontWeight = FontWeight.Medium,
            fontSize = 15f,
            color = Color.Black
        )
    }

    Spacer(modifier = Modifier.height(18.dp))

    Row(
        Modifier
            .fillMaxWidth()
            .background(color = Color(0xFFF3F2F2), RoundedCornerShape(14.dp))
            .padding(12.dp)
    ) {
        AsyncImage(
            model = R.drawable.ic_restaurant,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .height(85.dp)
                .clip(RoundedCornerShape(14.dp))
        )

        Spacer(modifier = Modifier.width(14.dp))

        Column {
            TextComponent(
                text = stringResource(id = R.string.blue),
                fontWeight = FontWeight.Bold,
                fontSize = 20f,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextComponent(
                text = stringResource(id = R.string.time),
                fontWeight = FontWeight.Bold,
                fontSize = 15f,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                TextComponent(
                    text = stringResource(id = R.string.steve),
                    fontWeight = FontWeight.Bold,
                    fontSize = 15f,
                    color = Color(0xFFDA4747)
                )

                TextComponent(
                    text = stringResource(id = R.string.rating),
                    fontWeight = FontWeight.Medium,
                    fontSize = 15f,
                    color = Color.Black
                )
            }
        }
    }

}