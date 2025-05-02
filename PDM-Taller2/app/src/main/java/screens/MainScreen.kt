package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pdmtaller2.LDuque_00013423.restaurants
import com.pdmtaller2.LDuque_00013423.ui.theme.FoodSpotByLDuqueTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
    val modifier = Modifier
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "FoodSpot",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.DarkGray,
                    titleContentColor = Color.White
                )
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                IconButton(onClick = { navController.navigate("MainScreen") }) {
                    Icon(Icons.Filled.Home, contentDescription = "Pantalla principal", tint = Color.White)
                }
                IconButton(onClick = { navController.navigate("SearchScreen") }) {
                    Icon(Icons.Filled.Search, contentDescription = "Restaurantes", tint = Color.White)
                }
                IconButton(onClick = { navController.navigate("MyOrders") }) {
                    Icon(Icons.Filled.ShoppingCart, contentDescription = "Mis órdenes", tint = Color.White)
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier
                .fillMaxSize()
                .background(Color(0xFF0a1e54))
                .padding(paddingValues)
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            val categories = listOf("Comida mexicana", "Comida rapida", "Postres")
            categories.forEach { category ->
                Column {
                    Text(text = category, color = Color.White)
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(10))
                            .padding(5.dp)
                    ) {
                        val filteredRestaurants = restaurants.filter { it.categories.contains(category) }
                        items(filteredRestaurants.size) { index ->
                            val restaurant = filteredRestaurants[index]
                            Column(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .fillMaxHeight()
                                    .width(150.dp)
                                    .width(200.dp)
                                    .border(
                                        width = 1.dp,
                                        color = Color.White,
                                        shape = RoundedCornerShape(10)
                                    ),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Button(onClick = {navController.navigate("RestaurantScreen/${restaurant.id}")}
                                    , modifier.fillMaxSize(),
                                    shape = RoundedCornerShape(10),
                                    colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Green,
                                    contentColor = Color.White
                                ))
                                {
                                    Text(text = restaurant.name, color = Color.White)
                                }
                            }
                        }
                    }
                    Spacer(modifier.height(10.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    val navController = rememberNavController()
    FoodSpotByLDuqueTheme {
        MainScreen(navController)
    }
}