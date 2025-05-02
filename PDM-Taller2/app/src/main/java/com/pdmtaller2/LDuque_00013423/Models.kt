package com.pdmtaller2.LDuque_00013423

import androidx.compose.runtime.mutableStateListOf

data class Dish(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: Int
)

data class Restaurant(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: Int,
    val categories: List<String>,
    val menu: List<Dish>
)

val shoppingCart = mutableStateListOf<Dish>()