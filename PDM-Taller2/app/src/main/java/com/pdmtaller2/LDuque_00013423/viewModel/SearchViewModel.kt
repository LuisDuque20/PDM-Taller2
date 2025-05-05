package com.pdmtaller2.LDuque_00013423.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.pdmtaller2.LDuque_00013423.models.restaurants

class SearchViewModel : ViewModel() {

    var buscar by mutableStateOf("")
        private set

    var filteredRestaurants = mutableStateOf(restaurants)
        private set

    fun actualizarBusqueda(nuevoTexto: String) {
        buscar = nuevoTexto
        filterRestaurants()
    }

    private fun filterRestaurants() {
        filteredRestaurants.value = restaurants.filter { restaurant ->
            val nameMatch = restaurant.name.contains(buscar, ignoreCase = true)
            val categoryMatch = restaurant.categories.any { it.contains(buscar, ignoreCase = true) }
            val dishMatch = restaurant.menu.any { it.name.contains(buscar, ignoreCase = true) }

            nameMatch || categoryMatch || dishMatch
        }
    }
}
