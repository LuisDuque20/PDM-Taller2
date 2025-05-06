package com.pdmtaller2.LDuque_00013423.viewModel
import androidx.lifecycle.ViewModel
import com.pdmtaller2.LDuque_00013423.models.Restaurant
import com.pdmtaller2.LDuque_00013423.models.restaurants

class MainViewModel : ViewModel() {

    private val _categories = listOf(
        "Comida rapida",
        "Comida mexicana",
        "Comida italiana",
        "Comida asiatica",
        "Comida saludable",
        "Postres y Dulces",
        "Bebidas"
    )

    val categories: List<String> = _categories

    fun getRestaurantsByCategory(category: String): List<Restaurant> {
        return restaurants.filter { it.categories.contains(category) }
    }
}