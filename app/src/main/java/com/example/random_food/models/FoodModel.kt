package com.example.random_food.models

import androidx.annotation.DrawableRes

data class FoodModel(
    val name: String,
    val price: String,
    @DrawableRes val image: Int = 0
){

}