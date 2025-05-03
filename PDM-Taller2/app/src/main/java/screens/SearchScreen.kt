package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.foundation.clickable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController) {
    var buscar by remember { mutableStateOf("") }

    val filteredRestaurants = remember(buscar) {
        restaurants.filter { restaurant ->
            val nameMatch = restaurant.name.contains(buscar, ignoreCase = true)
            val categoryMatch = restaurant.categories.any { it.contains(buscar, ignoreCase = true) }
            val dishMatch = restaurant.menu.any { it.name.contains(buscar, ignoreCase = true) }

            nameMatch || categoryMatch || dishMatch
        }
    }

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
                    containerColor = Color.Blue,
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
                IconButton(onClick = { navController.navigate("RestaurantScreen") }) {
                    Icon(Icons.Filled.Search, contentDescription = "Restaurantes", tint = Color.White)
                }
                IconButton(onClick = { navController.navigate("MyOrders") }) {
                    Icon(Icons.Filled.ShoppingCart, contentDescription = "Mis órdenes", tint = Color.White)
                }
            }
        }
    ) { paddingValues ->
        Column(
            Modifier
                .fillMaxSize()
                .background(Color(0xFF0a1e54))
                .padding(paddingValues)
                .padding(horizontal = 20.dp)
                .background(Color(0xFF0a1e54))
        ) {
            TextField(
                value = buscar,
                onValueChange = { buscar = it },
                label = { Text("Buscar", color = Color.Black)},
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            LazyColumn {
                items(filteredRestaurants) { restaurant ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .clickable {
                                navController.navigate("RestaurantScreen/${restaurant.id}")
                            },
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF0a1e54)
                        )
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Image(
                                painter = painterResource(id = restaurant.imageUrl),
                                contentDescription = restaurant.name,
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Color.White),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Column {
                                Text(text = restaurant.name, color = Color.White)
                                Text(text = restaurant.description, color = Color.LightGray, fontSize = 12.sp)
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SearchScreenPreview(){
    val navController = rememberNavController()
    FoodSpotByLDuqueTheme {
        SearchScreen(navController)
    }
}