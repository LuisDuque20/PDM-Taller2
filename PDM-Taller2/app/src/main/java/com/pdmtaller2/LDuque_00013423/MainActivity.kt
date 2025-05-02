package com.pdmtaller2.LDuque_00013423

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.pdmtaller2.LDuque_00013423.ui.theme.FoodSpotByLDuqueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodSpotByLDuqueTheme {
                NavigationStack()
            }
        }
    }
}