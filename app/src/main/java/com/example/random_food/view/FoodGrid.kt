package com.example.random_food.view

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.random_food.R
import com.example.random_food.respone.FoodData
import com.example.random_food.screen.TopAppBar
import com.example.random_food.ui.theme.Purple500
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@ExperimentalFoundationApi
@Composable
fun FoodGrid(navController: NavController){
    val context = LocalContext.current
    val dataFileString = getJsonDataFromAsset(context, "data.json")
    val gson = Gson()
    val gridSampleType = object : TypeToken<List<FoodData>>() {}.type
     var sampleData : List<FoodData> = gson.fromJson(dataFileString, gridSampleType)
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Purple500),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            TopAppBar(
                title = "Food data",
                icon = Icons.Filled.List,
                onIconClick = {
                    navController.navigate("food_random")
                }
            )
//            Text(
//                text = "Food Random",
//                color = Color.White,
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold
//            )
        }

        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            modifier = Modifier.padding(10.dp)
        ){
            items(sampleData){ data ->
                SampleDataGridItem(data, navController)
            }
        }
    }



}

@Composable
fun SampleDataGridItem(data: FoodData, navController: NavController) {
    Card(
        modifier = Modifier
            .clickable {
                val itemVal = Gson().toJson(data)
                navController.navigate("food_grid_detail/{$itemVal}")
            }
            .padding(10.dp)
            .fillMaxSize(),
        elevation = 5.dp,
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(
             modifier = Modifier.padding(10.dp)
        )
        {
            Image(
                painterResource(R.drawable.banhkem3),
                contentDescription = "Food Image",
                modifier = Modifier
                    .width(70.dp)
                    .height(70.dp)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(5.dp))
            )
            Spacer(modifier =Modifier.padding(3.dp))
            Text(
                text = data.name,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier =Modifier.padding(5.dp))
            Text(
                text = data.desc,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}


fun getJsonDataFromAsset(context: Context, data: String): String {
    return context.assets.open(data).bufferedReader().use { it.readText() }
}
