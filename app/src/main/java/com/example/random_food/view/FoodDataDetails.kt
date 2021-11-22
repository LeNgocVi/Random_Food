package com.example.random_food.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.random_food.R
import com.example.random_food.respone.FoodData
import com.example.random_food.ui.theme.Purple500

@Composable
fun FoodDataDetails(data : FoodData, navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

    ){

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Purple500),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = "Make it easy Grid",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,

            )
            Spacer(modifier =Modifier.padding(20.dp))
            Image(
                painterResource(R.drawable.banhkem3),
                contentDescription = "Food Image",
                modifier = Modifier
                    .width(70.dp)
                    .height(70.dp)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Spacer(modifier =Modifier.padding(10.dp))

            Text(
                text = data.name,
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,

            )
            Spacer(modifier =Modifier.padding(20.dp))

            Text(
                text = data.desc,
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,

                )
        }
    }
}