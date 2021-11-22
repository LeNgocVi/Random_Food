package com.example.random_food.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
public fun FoodItem(
    name: String,
    price: String,
    image: Int,
){
    Card(
        modifier = Modifier
            .background(Color.Gray)
            .fillMaxWidth()
            .padding(),

    ) {
        Column(
            modifier = Modifier.fillMaxWidth() ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "Food Item",
                modifier = Modifier
                    .width(140.dp)
                    .height(120.dp),
            )
            Text(
                text = name,
                style = TextStyle( fontSize = 20.sp )
            )
            Text(
                text = price,
                style = TextStyle( fontSize = 20.sp ))

        }

    }
}
