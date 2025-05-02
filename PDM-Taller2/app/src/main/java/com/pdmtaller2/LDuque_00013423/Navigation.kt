package com.pdmtaller2.LDuque_00013423

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import screens.MainScreen
import screens.MyOrdersScreen
import screens.RestaurantScreen

@Composable
fun NavigationStack(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination="MainScreen"){
        composable("MainScreen"){
            MainScreen(navController = navController)
        }
        composable("RestaurantScreen"){
            RestaurantScreen(navController = navController)
        }
        composable("MyOrders"){
            MyOrdersScreen(navController = navController)
        }
    }
}