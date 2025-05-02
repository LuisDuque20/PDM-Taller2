package com.pdmtaller2.LDuque_00013423

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import screens.MainScreen
import screens.MyOrdersScreen
import screens.RestaurantScreen
import screens.SearchScreen

@Composable
fun NavigationStack(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination="MainScreen"){
        composable("MainScreen"){
            MainScreen(navController = navController)
        }
        composable("SearchScreen"){
            SearchScreen(navController = navController)
        }
        composable("MyOrders"){
            MyOrdersScreen(navController = navController)
        }
        composable("RestaurantScreen/{restaurantId}"){ backStackEntry ->
            val restaurantId = backStackEntry.arguments?.getString("restaurantId")?.toIntOrNull()
            restaurantId?.let{
                RestaurantScreen(navController = navController, restaurantId = it)
            }
        }
    }
}