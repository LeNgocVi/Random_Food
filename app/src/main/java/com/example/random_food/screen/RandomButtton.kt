package com.example.random_food.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp


@ExperimentalMaterialApi
@Composable
fun RandomButton(onActiveClick: () -> Unit){
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp)
    ) {
        Button(
            onClick = {
                onActiveClick.invoke()
            },
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.Red,
            ),
        ) {
            Text(
                text = "Random Button",
                style = TextStyle(color = Color.LightGray)
            )
        }
    }
}


