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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
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
import coil.compose.AsyncImage
import com.pdmtaller2.LDuque_00013423.shoppingCart
import com.pdmtaller2.LDuque_00013423.ui.theme.FoodSpotByLDuqueTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyOrdersScreen(navController: NavController) {
    val modifier = Modifier
    val myOrders = shoppingCart
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
                .padding(horizontal = 20.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(text = "Mis órdenes", color = Color.White)
            if (myOrders.isNotEmpty()) {
                LazyColumn(
                    modifier
                        .fillMaxSize()
                        .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(10))
                        .padding(horizontal = 15.dp, vertical = 15.dp)
                ) {
                    itemsIndexed(items = myOrders) { index, dish ->
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                        ) {
                            Text(text = dish.name, color = Color.White)
                            Text(text = dish.description, color = Color.LightGray)
                            Spacer(modifier = Modifier.height(8.dp))
                            AsyncImage(
                                model = dish.imageUrl,
                                contentDescription = dish.description,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(150.dp)
                            )
                        }
                    }
                }
            } else {
                Text(text = "No hay órdenes registradas", color = Color.White)
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun MyOrdersScreenPreview() {
    val navController = rememberNavController()
    FoodSpotByLDuqueTheme {
        MyOrdersScreen(navController)
    }
}