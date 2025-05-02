package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pdmtaller2.LDuque_00013423.ui.theme.FoodSpotByLDuqueTheme

@Composable
fun MyOrdersScreen(navController: NavController){
    val modifier = Modifier
    Column(modifier.fillMaxSize().background(Color.White)){  }
}

@Preview(showBackground = true)
@Composable
fun MyOrdersScreenPreview() {
    val navController = rememberNavController()
    FoodSpotByLDuqueTheme {
        MyOrdersScreen(navController)
    }
}