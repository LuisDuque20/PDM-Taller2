package com.pdmtaller2.LDuque_00013423.viewModel
import androidx.lifecycle.ViewModel
import com.pdmtaller2.LDuque_00013423.models.Dish

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.pdmtaller2.LDuque_00013423.models.shoppingCart


class MyOrdersViewModel : ViewModel() {
    var orders by mutableStateOf(listOf<Dish>())
        private set

    init {
        actualizarOrdenes()
    }

    fun actualizarOrdenes() {
        orders = shoppingCart.toList()
    }
}

