package screens

import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.pdmtaller2.LDuque_00013423.models.shoppingCart
import com.pdmtaller2.LDuque_00013423.ui.theme.FoodSpotByLDuqueTheme
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pdmtaller2.LDuque_00013423.viewModel.RestaurantViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantScreen(navController: NavController, restaurantId: Int) {
    val modifier = Modifier
    val restaurantViewModel: RestaurantViewModel = viewModel()
    LaunchedEffect(restaurantId) {
        restaurantViewModel.cargarRestaurante(restaurantId)
    }
    val restaurant = restaurantViewModel.restaurant
    val buscarPlatillo = restaurantViewModel.buscarPlatillo
    val filteredMenu = restaurantViewModel.obtenerMenuFiltrado()

    val context = LocalContext.current

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("FoodSpot", maxLines = 1, overflow = TextOverflow.Ellipsis)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White
                )
            )
        },
        bottomBar = {
            Row(
                modifier.fillMaxWidth(),
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
        if (restaurant != null) {
            Column(
                modifier
                    .fillMaxSize()
                    .background(Color(0xFF0a1e54))
                    .padding(paddingValues)
                    .padding(20.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                Row(
                    modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = restaurant.name,
                        color = Color.White,
                        fontSize = 50.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Text(
                        text = restaurant.description,
                        color = Color.White,
                        fontSize = 20.sp,
                        fontStyle = FontStyle.Italic,
                        fontFamily = FontFamily.Serif
                    )
                }

                Spacer(modifier.height(16.dp))

                TextField(
                    value = buscarPlatillo,
                    onValueChange = {
                        restaurantViewModel.actualizarBusqueda(it)
                    },
                    label = { Text(text = "Buscar platillo") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 0.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(10)
                        ),
                )

                Spacer(modifier.height(8.dp))

                Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Text(text = "Menú:", color = Color.White)
                }

                LazyColumn(
                    modifier
                        .fillMaxWidth()
                        .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(10))
                        .padding(horizontal = 15.dp, vertical = 15.dp)
                ) {
                    items(filteredMenu) { dish ->
                        Column(
                            modifier
                                .padding(vertical = 4.dp)
                                .height(250.dp)
                        ) {
                            Row(
                                modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(
                                    modifier.weight(1f)
                                ) {
                                    Text(text = dish.name, color = Color.White)
                                    Text(text = dish.description, color = Color.LightGray)
                                }
                                Button(onClick = {
                                    shoppingCart.add(dish)
                                    Toast.makeText(
                                        context,
                                        "${dish.name} agregado al carrito",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }) {
                                    Text(text = "Comprar")
                                }
                            }
                            Image(
                                painter = painterResource(id = dish.imageUrl),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }
            }
        } else {
            Text(text = "Restaurante no encontrado", color = Color.Red)
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