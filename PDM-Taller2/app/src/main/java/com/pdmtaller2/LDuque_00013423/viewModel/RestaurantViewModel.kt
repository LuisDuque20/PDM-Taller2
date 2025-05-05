package com.pdmtaller2.LDuque_00013423.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import com.pdmtaller2.LDuque_00013423.models.Dish
import com.pdmtaller2.LDuque_00013423.models.Restaurant
import com.pdmtaller2.LDuque_00013423.models.restaurants
import androidx.compose.runtime.*

class RestaurantViewModel : ViewModel() {

    var buscarPlatillo by mutableStateOf("")
        private set

    var restaurant by mutableStateOf<Restaurant?>(null)
        private set

    fun cargarRestaurante(restaurantId: Int) {
        restaurant = restaurants.find { it.id == restaurantId }
    }

    fun actualizarBusqueda(nuevoTexto: String) {
        buscarPlatillo = nuevoTexto
    }

    fun obtenerMenuFiltrado(): List<Dish> {
        return restaurant?.menu?.filter {
            it.name.contains(buscarPlatillo, ignoreCase = true)
        } ?: emptyList()
    }
}

