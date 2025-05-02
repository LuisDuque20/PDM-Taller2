package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import com.pdmtaller2.LDuque_00013423.restaurants
import com.pdmtaller2.LDuque_00013423.ui.theme.FoodSpotByLDuqueTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantScreen(navController: NavController, restaurantId: Int){
    val modifier = Modifier
    val restaurant = restaurants.find { it.id == restaurantId }

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
    )
    { paddingValues ->
        if (restaurant != null) {
            Column(
                modifier
                    .fillMaxSize()
                    .background(Color(0xFF0a1e54))
                    .padding(paddingValues)
                    .padding(vertical = 20.dp)
                    .padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = restaurant.name,
                        color = Color.White,
                        fontSize = 50.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif)
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center)
                {
                    Text(text = restaurant.description, color = Color.White, fontSize = 20.sp, fontStyle = FontStyle.Italic, fontFamily = FontFamily.Serif)
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Menú:", color = Color.White)

                LazyColumn(modifier.fillMaxWidth().border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(10)).padding(horizontal = 10.dp, vertical = 10.dp))
                {
                    items(restaurant.menu) { dish ->
                        Column(modifier.padding(vertical = 4.dp).height(300.dp))
                        {
                                Text(text = dish.name, color = Color.White)
                                Text(text = dish.description, color = Color.LightGray)
                                Spacer(modifier = Modifier.height(8.dp))
                            Row(modifier.fillMaxSize()){ dish.imageUrl }
                        }
                    }
                }
            }
        } else {
            Text("Restaurante no encontrado", color = Color.Red)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RestaurantScreenPreview() {
    val navController = rememberNavController()
    FoodSpotByLDuqueTheme {
        RestaurantScreen(navController, restaurantId = 1)
    }
}