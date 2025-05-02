package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pdmtaller2.LDuque_00013423.ui.theme.FoodSpotByLDuqueTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController){
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
            modifier
                .fillMaxSize()
                .background(Color.DarkGray)
                .padding(paddingValues)
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        )
        {
            Text(text = "Restaurantes", color = Color.White)
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