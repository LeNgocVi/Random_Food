package com.example.random_food

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.random_food.respone.FoodData
import com.example.random_food.screen.FoodScreen
import com.example.random_food.ui.theme.Random_foodTheme
import com.example.random_food.view.FoodDataDetails
import com.example.random_food.view.FoodGrid
import com.google.gson.Gson

@ExperimentalMaterialApi
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Random_foodTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        NavigatePage()
                    }

                }
            }
        }
    }
}


@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun NavigatePage(){
    val navHostController = rememberNavController()

    NavHost(
        navController = navHostController,
        startDestination = "food_random"
    ){
        composable("food_data"){
            FoodGrid(navHostController)
        }
        composable("food_grid_detail/{item}",
            arguments = listOf(
                navArgument("item"){
                    type = NavType.StringType
                }
            )
        ){backStackEntry ->
            backStackEntry?.arguments?.getString("item")?.let{ json ->
                val item = Gson().fromJson(json, FoodData::class.java)
                FoodDataDetails(data = item, navController = navHostController)
            }
        }
        composable("food_random"){
            FoodScreen(navHostController)
        }

    }
}

